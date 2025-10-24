package syntax

type Token uint

const (
	_        Token = iota
	_TRUE          // T
	_FALSE         // F
	_NOT           // ~
	_AND           // ^
	_OR            // v
	_IMPLIES       // ->
	_LPAREN        // (
	_RPAREN        // )
	_PERIOD        // .
	_EOF
	_ERROR
)
