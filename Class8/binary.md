0.7 to binary

0.7-0.5 = 0.2
can't subtract 0.25
0.2-0.125 = 0.075
0.075-0.0625 = 0.0125
0.0125-0.03125 can't subtract
0.0125-0.015625 can't subtract
0.0125-0.0078125 = 
....
0.1011001100110...

0.7 x 2 = 1.4 <- take 1 for first decimal

repeat start
0.4 x 2 = 0.8 // take 0 for second decimal
0.8 x 2 = 1.6 // take 1 for third decimal
0.6 x 2 = 1.2 // take 1
0.2 x 2 = 0.4 // take 0
repeat end

0.4 x 2 

1 bit 2's complement, rest is magnitude

0.1011001100110... in float
# memory representation #

0.00101 to float
= 1.01 x 2^3

float has 32 bits
double has 64 bits

1 bit: positive (0) or negative (1)
2~9 (8 bits float), 2~12 (11 bits double): exponent
rest (23 bits float), (52 bits double): mantissa

11.11 = 1.111 x 2^1
1.111 = 1.111 x 2^0
0.1111 = 1.111 x 2^-1
0.000000000000000000000000000000001111 = 1.111 x 2^-something

0.324 = 3.24 * 10^-1
0.000324 = 3.24 * 10^-4

bias = 127 for float
     = 1024 for double

sign bit: 0 
exponent bit: 
3 + 127 = 130
130 to binary is 10000010

mantissa: 
0.01 to binary
0.01 x 2 = 0.02
0.02 x 2 = 0.04
0.04 x 2 = 0.08
0.08 x 2 = 0.16
0.16 x 2 = 0.32
0.32 x 2 = 0.64
0.64 x 2 = 1.28
0.28 x 2 = 0.54

0 10000010 00000010.....(23 mantissa bits)
positive
10000010 to decimal is 130
exponent = 130-127 = 3
3 in binary 11

mantissa to decimal
connect into a scientific notation
sign 1.mantissa x 2^exponent

# Review #
-30 in byte

-13.53125 to float

sign bit: 1
13 to binary: 1101

0.53125 x 2 = 1.0625
0.0625 x 2 = 0.125
0.125 x 2 = 0.25
0.25 x 2 = 0.5
0.5 x 2 = 1

-13.53125 in binary is 1101.10001 = 1.10110001 x 2^3

3 + 127 = 130
130 in binary = 10000010

1 10000010 10110001000000000000000

11.15625

