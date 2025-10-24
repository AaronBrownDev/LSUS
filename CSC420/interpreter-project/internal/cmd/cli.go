package cmd

import (
	"fmt"
	"os"
)

func getInput() (input string, err error) {
	// CLI argument
	if len(os.Args) > 1 {
		switch os.Args[1] {

		// Help flag
		case "-h":
			fallthrough

		case "--help":
			fmt.Println("flags:\n-h // help flag\n--help // help flag\n-f // file flag\n--flag // file flag\n-s // string flag\n--string // string flag")
			fmt.Println()
			fmt.Println("usage:\ngo run cmd/interpreter/main.go -f '[fileName]'\nor\ngo run cmd/interpreter/main.go -s '[inputString]'\nor\ngo run cmd/interpreter/main.go // hardcoded")
			os.Exit(0)

		// File flag
		case "-f":
			fallthrough

		case "--file":
			if len(os.Args) <= 2 {
				return "", fmt.Errorf("missing file name")
			}
			return getFileContents(os.Args[2])

		// String flag
		case "-s":
			fallthrough

		case "--string":
			if len(os.Args) <= 2 {
				return "", fmt.Errorf("missing input string")
			}
			return os.Args[2], nil

		default:
			return "", fmt.Errorf("invalid flag %s\ntry: go run main.go -h", os.Args[1])
		}
	}

	// hardcode
	input = "~T^(F->T)vF."

	return input, nil
}

func getFileContents(fileName string) (string, error) {

	fileContents, err := os.ReadFile(fileName)
	return string(fileContents), err
}
