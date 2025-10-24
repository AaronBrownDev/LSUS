package cmd

import (
	"fmt"
	"interpreter/internal/syntax"
)

func InterpreterCmd() error {

	input, err := getInput()
	if err != nil {
		return err
	}

	lexer := syntax.NewLexer(input)

	tokens, err := lexer.Tokenize()
	if err != nil {
		return err
	}

	parser := syntax.NewParser(tokens)

	result, err := parser.ParseBoolStmt()
	if err != nil {
		return err
	}

	fmt.Printf("%s is %t\n", input, result)

	return nil
}
