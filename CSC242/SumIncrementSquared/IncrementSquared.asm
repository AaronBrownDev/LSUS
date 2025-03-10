; Coded by Aaron Brown
; Program will sum 1^2 + 2^2 + . . . + n^2


.586
.MODEL FLAT
INCLUDE io.h
.STACK 4096
.DATA


num     DWORD  ?
prompt1 BYTE    "Enter Number to Increment to:", 0
string  BYTE    30 DUP (?)
resultLbl  BYTE    "The sum of the increment squared:", 0
t       BYTE    60 DUP (?), 0

.CODE
_MainProc PROC
        input   prompt1, string, 30    ; get num
        atod    string                 ; convert ascii to integer
        mov     num, eax               ; assign EAX value to num var
        
        mov     ebx, 0                 ; Resets EAX

body:   
        mov     eax, ebx               ; assigns ebx to eax
        cmp     ebx, num               ; Compares ebx and num
        jg      escape                 ; Checks if ebx > num, escapes if so
        mul     ebx                    ; eax * ebx (ebx^2)
        add     ecx, eax               ; adds ebx^2 to ecx 
        inc     ebx                    ; adds 1 to ebx
        jmp     body

        ; AFTER LOOP BREAKS
escape:
        dtoa    t, ecx                 ; convert to ASCII
        output  resultLbl, t           ; output label and area
 

        mov     eax, 0  ; exit with return code 0
        ret
_MainProc ENDP
END 