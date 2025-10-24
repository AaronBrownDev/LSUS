package syntax

import "fmt"

type Parser struct {
	pos    uint32
	tokens []Token
}

func NewParser(tokens []Token) *Parser {
	return &Parser{
		pos:    0,
		tokens: tokens,
	}
}

func (p *Parser) currentToken() Token {
	if p.pos >= uint32(len(p.tokens)) {
		return _EOF
	}
	return p.tokens[p.pos]
}

func (p *Parser) advance() {
	if p.pos < uint32(len(p.tokens)) {
		p.pos++
	}
}

func (p *Parser) expects(desired Token) bool {
	if p.currentToken() == desired {
		p.advance()
		return true
	}
	return false
}

// ParseBoolStmt
func (p *Parser) ParseBoolStmt() (bool, error) {

	// Handles <IT>.
	// Handles <IT>
	isValid, err := p.ParseImplyTerm()
	if err != nil {
		return false, err
	}

	// Handles .
	if p.currentToken() != _PERIOD {
		return false, fmt.Errorf("syntax error: expected '.' but found %v at position %d", p.currentToken(), p.pos)
	}
	p.advance()

	// Handles EOF
	if p.currentToken() != _EOF {
		return false, fmt.Errorf("syntax error: expected no more tokens but found %v at position %d", p.currentToken(), p.pos)
	}

	return isValid, nil
}

// ParseImplyTerm
func (p *Parser) ParseImplyTerm() (bool, error) {

	// Handles <OT><IT_Tail>
	// Handles <OT>
	isValid, err := p.ParseOrTerm()
	if err != nil {
		return false, err
	}

	// Handles <IT_Tail>
	return p.ParseImplyTermTail(isValid)
}

// ParseImplyTermTail
func (p *Parser) ParseImplyTermTail(leftVal bool) (bool, error) {

	// Handles ->
	if p.expects(_IMPLIES) {
		rightVal, err := p.ParseOrTerm()
		if err != nil {
			return false, err
		}

		return p.ParseImplyTermTail(!leftVal || rightVal) // -> represents
	}

	// Handles epsilon
	return leftVal, nil
}

// ParseOrTerm
func (p *Parser) ParseOrTerm() (bool, error) {

	// Handles <AT> <OT_Tail>
	// Handles <AT>
	isValid, err := p.ParseAndTerm()
	if err != nil {
		return false, err
	}

	// Handles <OT_Tail>
	return p.ParseOrTermTail(isValid)
}

// ParseOrTermTail
func (p *Parser) ParseOrTermTail(leftVal bool) (bool, error) {

	// Handles v
	if p.expects(_OR) {
		rightVal, err := p.ParseAndTerm()
		if err != nil {
			return false, err
		}

		return p.ParseOrTermTail(leftVal || rightVal) // v represents OR logic gate
	}

	// Handles epsilon
	return leftVal, nil
}

// ParseAndTerm
func (p *Parser) ParseAndTerm() (bool, error) {

	// Handles <L> <AT_Tail>
	// Handles <L>
	isValid, err := p.ParseLiteral()
	if err != nil {
		return false, err
	}

	// Handles <AT_Tail>
	return p.ParseAndTermTail(isValid)

}

// ParseAndTermTail
func (p *Parser) ParseAndTermTail(leftVal bool) (bool, error) {

	// Handles ^ <L> <AT_Tail>
	// Handles ^
	if p.expects(_AND) {

		// Handles <L>
		rightVal, err := p.ParseLiteral()
		if err != nil {
			return false, err
		}

		// Handles <AT_TAIL>
		return p.ParseAndTermTail(leftVal && rightVal) // ^ represents AND logic gate

	}

	return leftVal, nil
}

// ParseLiteral
func (p *Parser) ParseLiteral() (bool, error) {

	// Handles ~ <L>
	if p.expects(_NOT) {
		isValid, err := p.ParseLiteral()
		if err != nil {
			return false, err
		}
		return !isValid, nil // ~ represents negation
	}

	// Handles <A>
	return p.ParseAtom()
}

// ParseAtom
func (p *Parser) ParseAtom() (bool, error) {

	// Handles T
	if p.expects(_TRUE) {
		return true, nil
	}

	// Handles F
	if p.expects(_FALSE) {
		return false, nil
	}

	// Handles ( <IT> )
	// Handles (
	if p.expects(_LPAREN) {

		// Handles <IT>
		isValid, err := p.ParseImplyTerm()
		if err != nil {
			return false, err
		}

		// Handles )
		if p.expects(_RPAREN) {
			return isValid, nil
		} else {
			return false, fmt.Errorf("syntax error: expected ')' but found %v at position %d", p.currentToken(), p.pos)
		}

	}

	return false, fmt.Errorf("syntax error: expected T, F, or '(' but found %v at position %d", p.currentToken(), p.pos)
}
