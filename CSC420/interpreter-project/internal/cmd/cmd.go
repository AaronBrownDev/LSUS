package cmd

import (
	"log"
)

func Execute() int {

	if err := InterpreterCmd(); err != nil {
		log.Printf("%v", err)
		return 1
	}

	return 0
}
