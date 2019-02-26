package ru.roman.certification.operator;

public class Cast {

    public static void main(String[] args) {

        int r1 = (char) (byte) -1;  // -1 ->  byte ->  -1 -> char -> 65535 -> int -> 65535
                                    //  |               |            |
                                    // 0b...1111111111 0b11111111    0b1111111111111111
        int r2 = (char) (byte) 128; // 128 -> byte ->  -128 -> char -> 65408 -> int -> 65408
                                    //  |               |              |
                                    // 0b...1110000000 0b10000000      0b1111111110000000
        int r = (char) (byte) 64;   // 64 -> byte  -> 64 -> char  -> 64 -> int -> 64
                                    //  |              |              |
                                    // 0b...01000000  0b01000000    0b1111111101000000
        int r3 = (char) (short) -1; // -1(0b1111111111111111) -> 65535(0b1111111111111111)
        int r4 = (char) -1;         // 65535
        int r5 =  (char) -1.0;      // 65535

        //System.out.println(r + "(" + Integer.toBinaryString(r) + ")");


        int s1 = (short) -1;             // -1
        short s2 = (short) 0x7fff_ffff;  // 2147483647 % 65536 = 65535(111111111....) -> -1
        short s3 = (short) 0x8000_0000;  // -2147483648 % 65536 = 0
        short s4 = (short) 0x8000_0001;  // -2147483647 % 65536 = 1 - деление происходит в бинарном виде,
                                         // -2147483647 в бинарном виде это 2147483649
        int s = (short) -32_768;         // -32_768 диапазон допустимый, narrowing потом widening норм
        System.out.println(s + "(" + Integer.toBinaryString(s) + ")");
        System.out.println(0);
    }
}
