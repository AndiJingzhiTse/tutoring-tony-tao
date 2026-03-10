package Class10;
// Use this editor to write, compile and run your Java code online

class Main {

    // pass by reference, in reality pass by pointer, so also pass by value
    // pass by value
    public static void main(String[] args) throws NumberFormatException {
        System.out.println("11".substring(2));
        System.out.println(rev("gobble;til you;wobble"));
        System.out.println(revCharAt("gobble;til you;wobble", ""));
        System.out.println(count11("11x11"));

        System.out.println(strDist("catcowcatcat", "cat"));
    }

    public static int strDist(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }
        // if str start and end with sub, then return length of str
        if (str.substring(0, sub.length()).equals(sub) && str.substring(str.length() - sub.length()).equals(sub)) {
            return str.length();
        }
        // if we reach here, then str doesn't start and end with sub
        // if str start with sub, truncate the end of str and check again
        if (str.substring(0, sub.length()).equals(sub)) {
            return strDist(str.substring(0, str.length() - 1), sub);
        }
        // if str end with sub, truncate the start of str and check again
        if (str.substring(str.length() - sub.length()).equals(sub)) {
            return strDist(str.substring(1), sub);
        }
        // if str doesn't start nor end with sub, truncate both ends and check again
        return strDist(str.substring(1, str.length() - 1), sub);
    }

    public static int count11(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.substring(0, 2).equals("11")) {
            return 1 + count11(str.substring(2));
        } else {
            return count11(str.substring(2));
        }
    }

    public static String rev(String str) {
        if (str.length() == 0) {
            return "";
        }
        int semicolonIndex = str.indexOf(';');
        int spaceIndex = str.indexOf(' ');

        int firstWordEndIndex;
        if (semicolonIndex == -1 && spaceIndex == -1) {
            return str;
        }
        if (semicolonIndex == -1) {
            firstWordEndIndex = spaceIndex;
        } else if (spaceIndex == -1) {
            firstWordEndIndex = semicolonIndex;
        } else {
            firstWordEndIndex = Math.min(semicolonIndex, spaceIndex);
        }
        return rev(str.substring(firstWordEndIndex + 1)) + ", " + str.substring(0, firstWordEndIndex);
    }

    public static String revCharAt(String str, String word) {
        if (str.length() == 0) {
            return word;
        }
        char firstChar = str.charAt(0);
        if (firstChar == ';' || firstChar == ' ') {
            return revCharAt(str.substring(1), "") + ", " + word;
        }
        return revCharAt(str.substring(1), word + firstChar);
    }

    public static String revCharAtCaller(String str) {
        return revCharAt(str, "");
    }

}
