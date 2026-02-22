package Class7;

import java.util.*;
import java.io.*;

public class Class7 {

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
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        try {
            // if something bad happens....
            /// array index out of bounds
            /// division by zero
            /// 
            System.out.println(1 / 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Something bad happened: " + e.getMessage());
        } finally {
            System.out.println("This will always run");
            sc.close();
        }
        excep(arr);
    }
    public static void excep(int[] arr){
        try {
            System.out.println(arr[10]);
        }catch(ArrayIndexOutOfBoundsException e){
            // throw new ArrayIndexOutOfBoundsException("This is an array index out of bounds exception");
            throw e;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    

}
