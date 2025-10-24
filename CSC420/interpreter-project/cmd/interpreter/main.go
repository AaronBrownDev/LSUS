package main

import (
	"interpreter/internal/cmd"
	"os"
)

func main() {

	exitCode := cmd.Execute()

	os.Exit(exitCode)
}
