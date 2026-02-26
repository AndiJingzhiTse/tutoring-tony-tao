package Class8;

import java.io.*;
import java.util.*;

public class Class8 {

    /// try-catch
    /// data type
    /// binary number
    /// 
    
    /// runtime error: 1/0, array index out of bounds
    /// compile time error
    /// 
    
    /// exception is under runtime error
    /// runtime exception is about computation (cpu)
    /// IOException is about input and output (disk, network, etc)
    /// i.e. write to a file that doesn't exist, read from a file that doesn't exist, etc
    /// if the file is in use by another program, etc
    /// 
    
    /// byte: 8 bits, 2^8 combination, we could have represented 0-255
    /// -128 to 127, because we want negative
    /// for a int data type with n bits, we can represent -2^(n-1) to 2^(n-1)-1
    /// for a long data type with 64 bits, we can represent -2^63 to 2^63-1
    public static void main(String[] args) throws IOException {
        String str = "Hello World"; // O(n)
        str = str + "!"; // what actually happens is that a new string is created with the value "Hello World!" and str now points to that new string
        // Hello World, then delete this
        // Hello World! have str point to this new string
        // 

        int num = 3;
        num = num + 1; // what actually happens is that a new int is created with the value 4 and num now points to that new int
        // 00000011 in binary is 3, 00000100 in binary is 4

        // String vs StringBuilder
        // SB has more reserve space, so it doesn't have to create a new string every time we concatenate
        // reserves 16 bytes
        StringBuilder sb = new StringBuilder();
        // if sb grows larger than 16 bytes, it will reserve more space such as 32 bytes, 64 bytes, etc
        // Amortization: O(1)
        // ArrayList also uses this strategy, it reserves more space when it grows larger than its current capacity

        example2();

        StringTokenizer st = new StringTokenizer("Hello World! This is a     string tokenizer example.", " ", true);

        for (int i = st.countTokens(); i > 0; i--) {
            System.out.print(st.nextToken());
        }
        System.out.println();
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Buffered Reader:");
        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // read from disk
        String line = br.readLine();

        int numInput = Integer.parseInt(line);

        System.out.println(line);
        System.out.println(numInput + 10);
        br.close();

        System.out.println("Scanner:");
        Scanner sc = new Scanner(new File("input.txt"));
        sc.nextLine(); // read line
        System.out.println(sc.next());

    }

    public static void example2() {
        StringBuilder sb = new StringBuilder(10);
        System.out.println("1: " + sb.length() + " " + sb.capacity());
        sb.append("Do you");
        System.out.println("2: " + sb.length() + " " + sb.capacity());
        sb.append(" get this?");
        System.out.println("3: " + sb.length() + " " + sb.capacity());
    }

    public static int nextInt() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            return Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // or some default value
        }
    }
    public static void println(){
        System.out.println();
    }

    public static void print(String s){
        System.out.print(s);
    }

}
