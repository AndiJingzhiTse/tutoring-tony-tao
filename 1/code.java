// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {

    // pass by reference, in reality pass by pointer, so also pass by value
    // pass by value
    public static void main(String[] args) {
        // pass by value
        int num = 2;
        addOne(num);
        System.out.println(num);

        // pass by reference
        int[] arr = {1, 2, 3};
        arrAddOne(arr);
        printArr(arr);

        int[] arr1 = {2, 1, 3, 5, -10};
        printArr(bubbleSort(arr1));

        String[] strArr = new String[20]; // declaration + initialzation
        String[] strArr1; // declaration
        strArr1 = new String[20]; //initialization

        int total = 0;
        int number = 3;
        while (number < 8) {
            total += number;
            number++;
        }
        System.out.println(total);

        String str = "String";
        System.out.println(str.substring(3));
        System.out.println(str.substring(3, str.length()));

        System.out.println(one("String", 'i'));
    }

    public static int one(String str, char ch) {
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == ch) {
                return index;
            }
        }
        return -1;
    }

    public static int addOne(int num) {
        num++;
        return num;
    }

    public static int[] arrAddOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 1) {
                continue;
            }
            arr[i]++;
        }
        return arr;
    }

    public static void hi() {
        System.out.println("hi");
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] bubbleSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    // swap
                    int tmp = num[j]; // = is an assignment, not comparison
                    num[j] = num[j + 1];
                    num[j + 1] = tmp;
                }
            }
        }
        return num;
    }
    // floor vs ceiling
    // random: [0,1)
    // 11*random-5: [-5,+6)
    // floor(11*random-5): [-5,+5] 
    // -5: [-5,-4)
    // +5: [+5,+6]

}
