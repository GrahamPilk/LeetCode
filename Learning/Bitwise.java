package Learning;

import java.util.Scanner;

public class Bitwise {
    public static void main (String[] args) {
        /*
         * & - Bitwise AND (1)
         * | - Bitwise OR (2)
         * ^ - Bitwise XOR (3) 
         * ~ - Bitwise complement (4)
         * << - Left Shift (5)
         * >> - Signed Right Shift (6)
         * >>> Unsigned Right Shift. (7)
         */


         /* 1 AND
          * This operater is a binary operatoer, denoted by '&'. It returns a bit by bit AND of input valies, i.e., if both bits are 1, it gives 1, else it shows 0.
          * Ex: a = 5 = 0101, b = 7 = 0111.
          * Bitwise AND operation of 5 and 7 = 0101 = 5.
          */

        /* 2 OR
         * This operater is a binary operator, denoted by '|'. It returns bit by bit OR of input values, i.e., if either of the bits is 1, it gives 1, else it shows 0
         * Ex: a = 5= 0101, b = 7 = 0111
         * Bitwise OR operation of 5 and 7 = 0111 = 7.
         */

        /* 3 XOR
         * This operator is a binary operator, denoted by '^'. It returns bit by bit XOR of input values, i.e., if corresponding bits are different, it gives 1, else it shows 0.
         * Ex: Same initilization
         * Bitwise XOR operation of 5 & 7 = 0010 = 2.
         */

        /* 4 ~
         * This operator is a unary operator, denoted by '~'. It returns the one's complement representation of the input value, i.e., with all bits inverted, which means it makes every 0 to 1, and every 1 to 0.
         * Ex: a = 5 = 0101. 
         * Bitwise complement operation of 5 in java (8 bits) ~ 00000101
         * = 11111010 = -6 in decimal
         */

        /* 5 <<
         * This operator moves all bits of a number to the left by number specified. 
         * Ex: 00010100 (x= 20) x << 3
         * turns into 10100000
         */

        /* 6 >>
         * A bitwise operation that shifts the bits of a binary number ot the right by a specified number of positions while preserving the sign of the original number. 
         * Ex: x = 8 (000010000) x >> 1 = 000001000
         */

        /* 7 >>>
         * Performs a right shift operation on the bits of a number, filling the vacated leftmost position with zeros. 
         * 
         */


         Scanner input = new Scanner(System.in);
         System.out.println("Enter first number: ");
         int num1 = input.nextInt();
         System.out.println("Enter second number: ");
         int num2 = input.nextInt();

        System.out.println("Bitwise AND: " + (num1 & num2));
        System.out.println("Bitwise OR: " + (num1 | num2));
        System.out.println("Bitwise XOR: " + (num1 ^ num2));
        System.out.println("Bitwise NOT: " + (~num1));
        System.out.println("Bitwise Left Shift: " + (num1 << 2));
        System.out.println("Bitwise Right Shift: " + (num1 >> 2));
        System.out.println("Bitwise Unsigned Right Shift: " + (num1 >>> 2));

        input.close();
    }
}
