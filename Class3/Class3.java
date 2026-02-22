package Class3;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
// n-d array
class Main {

    public static void main(String[] args) {
        // rectangular
        int[][] rect = new int[3][4]; // [row][col]
        /*
        1111
        1111
        1111
         */
        int[][] jagged = new int[3][]; // row length may be different
        jagged[0] = new int[]{1, 2, 3};
        jagged[1] = new int[]{4, 5, 6, 7};
        jagged[2] = new int[]{8};
        /*
        jagged
        111
        1111
        1
         */
        // Math.max(4.5, 3) = 4.5, double
        // method overload
        // Math.max(int, int) => int
        // Math.max(double, int) => double

        // CS 145
        // CS 246E, CS 146, CS 241E
        // 14x <- advanced, euclid >= 80, CCC >= 40?, CSMC >= 45?50?
        // passion, 
        // 13x <- normal, CS 136
        // 11x <- not needed, not good at it
        int acc = 0;

        for (int i = 0; i < jagged.length; i++) { // number of rows
            for (int j = 0; j < jagged[i].length; j++) { // loops through the columns in that row
                // jagged[0].length <- rect
                if (i == 1 || j == 1) {
                    continue;
                }
                System.out.print(jagged[i][j] + " "); // breakpoint, local/watch
                acc += jagged[i][j];
            }
            System.out.println();
        } // method overriding

    }
}
