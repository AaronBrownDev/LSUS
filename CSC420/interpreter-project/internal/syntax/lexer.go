package syntax

import (
	"fmt"
	"strings"
	"unicode"
)

type Lexer struct {
	input string
	pos   uint32
}

func NewLexer(input string) *Lexer {
	return &Lexer{
		input: strings.TrimSpace(input), // To get rid of extra whitespaces
		pos:   0,
	}
}

func (l *Lexer) peek() byte {
	if l.pos >= uint32(len(l.input)) {
		return '0'
	}
	return l.input[l.pos]
}

func (l *Lexer) peekNext() byte {
	if l.pos+1 >= uint32(len(l.input)) {
		return '0'
	}
	return l.input[l.pos+1]
}

func (l *Lexer) advance() byte {
	if l.pos >= uint32(len(l.input)) {
		return '0'
	}
	l.pos++
	return l.input[l.pos-1]
}

func (l *Lexer) Tokenize() ([]Token, error) {
	tokens := make([]Token, 0, len(l.input))
	for l.pos < uint32(len(l.input)) {

		for unicode.IsSpace(rune(l.peek())) {
			l.advance()
		}

		char := l.peek()

		switch char {
		case 'T':
			tokens = append(tokens, _TRUE)
			l.advance()
		case 'F':
			tokens = append(tokens, _FALSE)
			l.advance()
		case '~':
			tokens = append(tokens, _NOT)
			l.advance()
		case '^':
			tokens = append(tokens, _AND)
			l.advance()
		case 'v':
			tokens = append(tokens, _OR)
			l.advance()
		case '-':
			if l.peekNext() == '>' {
				tokens = append(tokens, _IMPLIES)
				l.advance()
				l.advance()
			} else {
				return nil, fmt.Errorf("syntax error: expected '->' but found '-%c' at position %d", l.peekNext(), l.pos)
			}
		case '(':
			tokens = append(tokens, _LPAREN)
			l.advance()
		case ')':
			tokens = append(tokens, _RPAREN)
			l.advance()
		case '.':
			tokens = append(tokens, _PERIOD)
			l.advance()
		default:
			return nil, fmt.Errorf("invalid character %s", string(char))
		}

	}

	return tokens, nil
}
