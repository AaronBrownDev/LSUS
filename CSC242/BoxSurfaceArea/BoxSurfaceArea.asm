; Updated by Aaron Brown
; Surface Area of a box: 2*(length*width+ length*height + width*height)
; program to find the surface area of a box
; author:  R. Detmer


.586
.MODEL FLAT
INCLUDE io.h
.STACK 4096

.DATA
l        DWORD  ?
w        DWORD  ?
h        DWORD  ?
prompt1 BYTE    "Length of rectangle:", 0
prompt2 BYTE    "Width of rectangle:", 0
prompt3 BYTE    "Height of rectangle:", 0
string  BYTE    30 DUP (?)
areaLbl BYTE    "The area is:", 0
area    BYTE    60 DUP (?), 0

.CODE
_MainProc PROC
        input   prompt1, string, 30    ; get length
        atod    string                 ; convert ascii to integer
        mov     l, eax                 ; assign EAX value to l var

        input   prompt2, string, 40    ; get width
        atod    string                 ; convert ascii to integer
        mov     w, eax                 ; assign EAX value to w var

        input   prompt3, string, 30    ; get height
        atod    string                 ; convert ascii to integer
        mov     h, eax                 ; assign EAX value to w var
        
        ; EAX IS CURRENTLY HEIGHT
        mul     w                      ; EAX(Height) * Width assigned to EAX
        mov     ebx, eax               ; assign EAX to EBX to make EBX hold eventual area value temporarily
        mov     eax, h                 ; assign height to EAX
        mul     l                      ; EAX(Height) * Length assigned to EAX
        add     ebx, eax               ; length * height + width * height
        mov     eax, l                 ; assign length to EAX
        mul     w                      ; EAX(Length) * Width assigned to EAX
        add     eax, ebx               ; length * width + length * height + width * height
        imul    eax, 2                 ; 2(length * width + length * height + width * height)

        dtoa    area, eax              ; convert to ASCII
        output  areaLbl, area          ; output label and area

        mov     eax, 0  ; exit with return code 0
        ret
_MainProc ENDP
END