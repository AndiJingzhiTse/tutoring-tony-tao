// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {

    public static void main(String[] args) {
        String phrase = "love the World the";
        String word = "the";

        int count = 0;
        String lowerPhrase = phrase.toLowerCase();
        int index = lowerPhrase.indexOf(word); // 0
        while (index > -1) {
            count++; // count = 2
            index = lowerPhrase.indexOf(word, index + word.length()); // phrase.indexOf(word, 7)
            // index = -1;

        }
        System.out.println(count);
        System.out.println(removeWord(phrase, word));

        int[] a = {1, 2, 3};
        change(a);
        System.out.println(a[0]);
    }

    // substring(start, end), indexOf
    public static String removeWord(String phrase, String word) {
        String lowerPhrase = phrase.toLowerCase();
        while (lowerPhrase.indexOf(word) > -1) {
            phrase = phrase.substring(0, lowerPhrase.indexOf(word))
                    + phrase.substring(lowerPhrase.indexOf(word) + word.length());
            lowerPhrase = phrase.toLowerCase();
        }
        return phrase;
    }

    public static void change(int[] arr) {
        arr = new int[]{9, 9, 9}; // pointer & reference 
    }

    public static String replaceWord(String phrase, String word, String replace) {
        String lowerPhrase = phrase.toLowerCase();
        while (lowerPhrase.indexOf(word) > -1) {
            phrase = phrase.substring(0, lowerPhrase.indexOf(word)) + replace
                    + phrase.substring(lowerPhrase.indexOf(word) + word.length());
            lowerPhrase = phrase.toLowerCase();
        }
        return phrase;
    }

    // method, function
    // doer, they do stuff
    // data strucutre / classes, memory, data holder
    // return type: the data type of the returned value
    // caller vs callee
    public static char findGPA(int grade) {
        if (grade > 85) {
            return 'A';
        }
        if (grade > 70) {
            return 'B';
        }
        if (grade > 60) {
            return 'C';
        }
        return 'D';
    }

}
