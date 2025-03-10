; Updated by Aaron Brown
; Example assembly language program -- adds three numbers
; Author:  R. Detmer
; Date:    1/2008

.586
.MODEL FLAT

INCLUDE io.h            ; header file for input/output

.STACK 4096

.DATA
number1 DWORD   ?
number2 DWORD   ?
number3 DWORD   ?
prompt1 BYTE    "Enter first number", 0
prompt2 BYTE    "Enter second number", 0
prompt3 BYTE    "Enter third number", 0
string  BYTE    30 DUP (?)
resultLbl BYTE  "The sum is", 0
sum     BYTE    40 DUP (?), 0

.CODE
_MainProc2 PROC
        input   prompt1, string, 40      ; read ASCII characters
        atod    string          ; convert to integer
        mov     number1, eax    ; store in memory

        input   prompt2, string, 40      ; repeat for second number
        atod    string
        mov     number2, eax

        input   prompt3, string, 40      ; repeat for second number
        atod    string
        mov     number3, eax
        
        mov     eax, number1    ; first number to EAX
        add     eax, number2    ; add second number
        add     eax, number3    ; add third number
        dtoa    sum, eax        ; convert to ASCII characters
        output  resultLbl, sum          ; output label and sum

        mov     eax, 0  ; exit with return code 0
        ret
_MainProc2 ENDP
END                             ; end of source code

