package Class9;
// Use this editor to write, compile and run your Java code online

class Main {

    // pass by reference, in reality pass by pointer, so also pass by value
    // pass by value
    public static void main(String[] args) throws NumberFormatException {
        try {
            throw new NumberFormatException("This is a number format exception"); // unchecked exception
        } catch (NumberFormatException e) {
            System.out.println("Caught a number format exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Caught an arithmetic exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught a general exception: " + e.getMessage());
        }
        StringBuilder d = new StringBuilder("loveandthunder");
        System.out.println(d.capacity());
        d.ensureCapacity(25);
        System.out.println(d.capacity());
        d.insert(0, 'b');
    }

    public static int getNumAt(int[] arr, int index) throws ArrayIndexOutOfBoundsException {
        return arr[index];
    }

}
