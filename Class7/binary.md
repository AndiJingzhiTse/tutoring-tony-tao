# non-negative int

25 -> binary

the largest 2's exponent is 16
16 -> 10000
9 <- 8 -> 1000
1 -> 1

11001
1*2^0+1*2^3+1\*2^4=1+8+16=25

(2102)\_3 -> dec
2*3^0+1*3^2+2\*3^3=2+9+54=65

# an alternate intuition convention

1 for positive
0 for negative

1001 = 9
11001 = +9
01001 = -9

how to present 0?
10 (+0) and 00 (-0) both represent 0 under this convention
hence we abandoned this convention

# 2's complement

2s-complement convention
11001
1+8=9
1 for negative, need to subtract
9-2^4=-7

00110 -> dec 2+4=6
6+1=7
since 11001 top digit is 1, hence negative
so 11001 represents -7

10111 -> 01000 -> 8
8+1 = 9
so 10111 is -9

01111 -> 15 max
10000 -> -16 min
range: -16~15

under 2's complement with n digits
max = 2^(n-1) - 1
min = -2^(n-1)

## negation

1. revert all digit
2. add 1

loop hole: range

10100 = -12

1. revert: 01011
2. add 1: 01100 -> 12

01011 = 11

1. revert: 10100
2. add 1: 10101 -> -11

10000 = -16

1. revert: 01111
2. add 1: 10000 = -16 <- overflow 溢位, kinda like index out of bound, except in binary
   more precisely, the most significant digit is different then what it should be

何意味，和溢位

01011 = 11
+00101 = 5
=10000 = -16

# hexanary

0123456789ABCDEF
