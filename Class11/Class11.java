package Class11;

import java.util.*;
import java.io.*;

class Main {

    // buffer reader, scanner, try-catch
    // you can also throw an exception here, but you will not be able to catch it
    // throw IOException
    // but if you try to throw DivisionByZeroException, you will not be able to catch it because it is a runtime exception
    public static void main(String[] args) throws IOException {
        try {
            int x = 1 / 0;
        } catch (Exception e) {
        }
        Scanner sc = new Scanner(System.in);
        Scanner fileSc = new Scanner(new File("input.txt"));
        System.out.println(fileSc.nextLine());
        System.out.println(fileSc.nextLine());
        // System.out.print('h');
        // fun2(4321);
        // fun3("abcde");
        // fun4(1234);
        // System.out.println(fun5(20));
        // System.out.println(fun6(24, 12));
        // mystery1("recursion");
        // mystery2(100);
        // mystery3(100);

        // br.readLine();
        // br.read();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = ' ';
        String str;
        try { // you can catch every exception, runtime, division by zero, null pointer, etc
            c = (char) br.read(); // read takes a single char in int
            str = br.readLine(); // readLine takes a whole line in String

            System.out.println(c);
            System.out.println(str);
        } catch (IOException e) { // CS 246E
            e.printStackTrace();
        } catch (ClassCastException e) { // else if
            e.printStackTrace();
        } catch (Exception e) { // like else
            e.printStackTrace();
        }

    }

    public static String mystery1(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String head = s.substring(0, 1);
        String tail = s.substring(1);

        if (s.length() % 2 == 0) {
            System.out.println(head);
            return mystery1(tail) + head;
        } else {
            System.out.println(tail);
            return head + mystery1(tail);
        }
    }

    public static void mystery2(int n) {
        if (n <= 0) {
            return;
        }

        if (n % 2 == 0) {
            System.out.println(n);
            mystery2(n / 2);
        } else {
            mystery2(n - 5);
            System.out.println(n);
        }
    }

    public static void mystery3(int n) {
        if (n <= 0) {
            return;
        }

        if (n % 3 == 0) {
            System.out.println(n);
            mystery3(n / 3);
        } else if (n % 3 == 1) {
            mystery3(n / 2);
            System.out.println(n);
        } else {
            mystery3(n - 2);
            System.out.println(n);
        }
    }

    /*
    4321
    432
    43
    4
    0
    3
    0
    2
    0
    1
    0
     */
    public static void fun2(int k) {
        System.out.println(k); // print 4321
        if (k > 0) {
            fun2(k / 10); // fun2(432), fun2(43), fun2(4), fun2(0)
        }
        if (k > 9) {
            fun2(k % 10); // fun2(3), fun2(2)
        }
    }

    public static void fun3(String str) {
        if (str.length() <= 1) {
            System.out.println(str.toUpperCase());
            return;
        }
        System.out.println(str);
        fun3(str.substring(0, str.length() - 1));
        fun3(str.substring(2));
    }

    /*
    happy1234
    happy12
    sad12
    happy1
     */
    public static void fun4(int n) { // 1234
        System.out.println("happy" + n);
        if (n > 100) {
            fun4(n / 100); // <- executing
        }
        System.out.println("sad" + n);
        if (n > 10) {
            fun4(n / 10);
        }
    }

    public static int fun5(int n) {
        if (n == 1 || n == 0) {
            return n;
        } else if (n <= 0) {
            return fun5(n + 1);
        } else {
            return 2 + 3 * fun5((int) Math.round(n / 2.0));
        }
    }

    public static int fun6(int first, int second) {
        int remainder = first % second;
        if (remainder == 0) {
            return second;
        } else {
            return fun6(second, remainder);
        }
    }
}
