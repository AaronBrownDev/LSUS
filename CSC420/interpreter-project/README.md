# Boolean Expression Interpreter

A recursive descent interpreter for Boolean expressions written in Go, implementing formal grammar and semantic evaluation rules.

## Operators

| Operator | Symbol | Description |
|----------|--------|-------------|
| `T` | True | Boolean true value |
| `F` | False | Boolean false value |
| `~` | NOT | Logical negation |
| `^` | AND | Logical conjunction |
| `v` | OR | Logical disjunction |
| `->` | IMPLIES | Logical implication |
| `( )` | Parentheses | Grouping |
| `.` | Period | Statement terminator (required) |

## Building the Project

```bash
# Build the executable
go build -o interpreter cmd/interpreter/main.go

# Or run directly without building
go run cmd/interpreter/main.go
```

## Usage

### Method 1: String Input (Recommended)

```bash
# Using -s or --string flag
go run cmd/interpreter/main.go -s "T ^ F."
go run cmd/interpreter/main.go --string "~T v F."
go run cmd/interpreter/main.go -s "(T -> F) ^ T."
```

### Method 2: File Input

```bash
# Create a file with your expression
echo "T ^ F -> T v ~F." > input.txt

# Run with -f or --file flag
go run cmd/interpreter/main.go -f input.txt
go run cmd/interpreter/main.go --file input.txt
```

### Method 3: Hardcoded

```bash
# Runs with default expression: ~T^(F->T)vF.
# Change default expression in internal/cmd/cli.go
go run cmd/interpreter/main.go
```

### Help Flag

```bash
# Display usage information
go run cmd/interpreter/main.go -h
go run cmd/interpreter/main.go --help
```

## Error Handling

The interpreter provides detailed error messages:

```bash
# Missing period
$ go run cmd/interpreter/main.go -s "T"
syntax error: expected '.' but found EOF at position 1

# Invalid character
$ go run cmd/interpreter/main.go -s "T & F."
# Tokenization error (& is not a valid operator)

# Unmatched parenthesis
$ go run cmd/interpreter/main.go -s "(T ^ F."
syntax error: expected ')' but found '.' at position 6

# Incomplete implication
$ go run cmd/interpreter/main.go -s "T - F."
# Tokenization error (- without > is invalid)
```

## Implementation Details

### Grammar

The interpreter implements this formal grammar:

```
<B>  ::= <IT> .
<IT> ::= <OT> <ITTail>
<ITTail> ::= -> <OT> <ITTail> | ε
<OT> ::= <AT> <OTTail>
<OTTail> ::= v <AT> <OTTail> | ε
<AT> ::= <L> <ATTail>
<ATTail> ::= ^ <L> <ATTail> | ε
<L>  ::= <A> | ~ <L>
<A>  ::= T | F | ( <IT> )
```

## Testing Quick Reference

```bash
# Test basic atoms
go run cmd/interpreter/main.go -s "T."      # true
go run cmd/interpreter/main.go -s "F."      # false

# Test negation
go run cmd/interpreter/main.go -s "~T."     # false
go run cmd/interpreter/main.go -s "~~T."    # true

# Test AND
go run cmd/interpreter/main.go -s "T^T."    # true
go run cmd/interpreter/main.go -s "T^F."    # false

# Test OR
go run cmd/interpreter/main.go -s "T v F."  # true
go run cmd/interpreter/main.go -s "F v F."  # false

# Test implication
go run cmd/interpreter/main.go -s "T->T."   # true
go run cmd/interpreter/main.go -s "T->F."   # false
go run cmd/interpreter/main.go -s "F->T."   # true
go run cmd/interpreter/main.go -s "F->F."   # true

# Test parentheses
go run cmd/interpreter/main.go -s "(T)."    # true
go run cmd/interpreter/main.go -s "(T^F)."  # false

# Test precedence
go run cmd/interpreter/main.go -s "~T v F."      # false (~T) v F
go run cmd/interpreter/main.go -s "T ^ F v T."   # true (T^F) v T
```

## Requirements

- Go 1.24.5 or higher (as specified in `go.mod`)