// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Scanner;

class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(linearInt(new int[]{1, 2, 4, 6}, new int[]{2, 4}));
        System.out.println(linearInt(new int[]{1, 2, 4, 6}, new int[]{2, 3, 4}));
        System.out.println(linearInt(new int[]{1, 2, 4, 4, 6}, new int[]{2, 4}));
        System.out.println(linearInt(new int[]{1, 2, 3}, new int[]{3, 4}));

        // Question1();
        // Question2();
    }

    public static void Question3() {
        int startingIndex;

        if () {

        } else {

        }

        for ( ) {

        }
    }

    public static void Question2() {
        double sum = 0;
        int n = 10;

        double min = Double.MAX_VALUE; // 10^308
        double max = Double.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + "th number: ");
            double num = sc.nextDouble();
            sum += num;

            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // System.out.printf("The average is: %0.2f\n", sum/n);
        System.out.println("The average is: " + Math.round(sum * 100.0 / n) / 100.0);
        System.out.println("The minimum is: " + min);
        System.out.println("The maximum is: " + max);
    }

    public static void Question1() {

        double a, b;
        do {
            System.out.print("Enter the first length: ");
            a = sc.nextDouble();
            System.out.print("Enter the second length: ");
            b = sc.nextDouble();
        } while (a <= 0 || b <= 0);
        System.out.println("The length of the hypotenuse: " + Math.sqrt(a * a + b * b));
    }

    public static boolean linearInt(int[] outer, int[] inner) {
        // {1,2,3}, {3,4}
        int index = 0; // the index on the inner array that we are checking

        for (int i = 0; i < outer.length; i++) {
            // keep incrementing inner index as long as it's within bound, while we can't find a match
            if (inner[index] == outer[i] && index + 1 < inner.length) {
                index++; // this is looping over inner
            }
            // if the last inner element matches the out[i], then we return true
            if (index == inner.length - 1 && inner[index] == outer[i]) {
                return true;
            }

            /*
            better
            if(inner[index] == outer[i]){
                if(index + 1 < inner.length) index++;
                else if(index == inner.length - 1) return true;
            }
             */
        }
        return false;
    }
}
git