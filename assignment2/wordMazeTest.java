package assignment2;

import java.io.*;

/*
 * Test harness for wordMazel.
 *
 * How it works:
 * 1) For each test suite (inputFile + expectedFile pair), redirect System.out
 *    to an in-memory buffer so wordMazel's output can be captured as a String.
 * 2) Call wordMazel.main() with the test input file path.
 * 3) Restore System.out.
 * 4) Read the expected output file into a String.
 * 5) Normalize line endings (\r\n -> \n) for cross-platform safety.
 * 6) Compare the two Strings line by line and report each difference.
 * 7) Print [PASS] or [FAIL] for each test, then a final summary.
 *
 * Test suites live in assignment2/testsuites/:
 *   test1 - basic grids (APPLES/ORANGE/LIME)
 *   test2 - straight vs turning path (ABG differs between maze1 and maze2)
 *   test3 - alternating 3x3 grid, words of various lengths
 */
public class wordMazeTest {

    // Running totals updated by each runTest call.
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) throws IOException {
        // Register every test suite here.
        runTest(
                "Test 1: Basic grids (APPLES, ORANGE, LIME)",
                "assignment2/testsuites/test1_input.txt",
                "assignment2/testsuites/test1_expected.txt"
        );

        runTest(
                "Test 2: Straight vs turning path (ABG differs maze1 vs maze2)",
                "assignment2/testsuites/test2_input.txt",
                "assignment2/testsuites/test2_expected.txt"
        );

        runTest(
                "Test 3: Alternating grid, short/long/missing words",
                "assignment2/testsuites/test3_input.txt",
                "assignment2/testsuites/test3_expected.txt"
        );

        runTest(
                "Test 4: wordMaze1Bonus scoring (WORD/MAZE/BEST/GAME grid, score 351)",
                "assignment2/testsuites/test4_input.txt",
                "assignment2/testsuites/test4_expected.txt"
        );

        // Final summary line.
        System.out.println("---");
        System.out.println("Results: " + passed + " passed, " + failed + " failed.");
    }

    /*
     * Runs one test case:
     * - Captures wordMazel's stdout output into a buffer.
     * - Compares it to the expected output file.
     * - Prints [PASS] or [FAIL]; on FAIL shows every differing line.
     *
     * Parameters:
     *   testName     - human-readable label printed with the result
     *   inputFile    - path to the word-maze input file (relative to cwd)
     *   expectedFile - path to the expected output file  (relative to cwd)
     */
    private static void runTest(String testName, String inputFile, String expectedFile)
            throws IOException {

        // Step 1: Redirect System.out so we capture wordMazel's printed output.
        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));

        boolean exceptionOccurred = false;
        String exceptionMessage = "";

        try {
            wordMaze.main(new String[]{inputFile});
        } catch (Exception e) {
            // Catch any unexpected error thrown inside wordMazel.
            exceptionOccurred = true;
            exceptionMessage = e.getMessage();
        } finally {
            // Step 2: Always restore stdout before printing test results.
            System.setOut(originalOut);
        }

        // If wordMazel threw an unexpected exception, report failure and stop this test.
        if (exceptionOccurred) {
            System.out.println("[FAIL] " + testName);
            System.out.println("       Unexpected exception: " + exceptionMessage);
            failed++;
            return;
        }

        // Step 3: Normalize line endings so \r\n (Windows) and \n agree.
        String actual = buffer.toString().replace("\r\n", "\n").replace("\r", "\n");
        String expected = readFile(expectedFile).replace("\r\n", "\n").replace("\r", "\n");

        // Step 4: Compare and report.
        if (actual.equals(expected)) {
            System.out.println("[PASS] " + testName);
            passed++;
        } else {
            System.out.println("[FAIL] " + testName);
            reportDifferences(actual, expected);
            failed++;
        }
    }

    /*
     * Reads an entire text file into a single String.
     * Each line from the file is followed by "\n", including the last line,
     * so the result always has a consistent trailing newline.
     */
    private static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
        } finally {
            // Close the reader even if an exception occurred while reading.
            if (br != null) {
                br.close();
            }
        }

        return sb.toString();
    }

    /*
     * Compares two normalized multi-line strings line by line.
     * Prints only the lines that disagree, with 1-based line numbers
     * and both the expected and actual values enclosed in [ ].
     */
    private static void reportDifferences(String actual, String expected) {
        String[] actualLines = actual.split("\n", -1);
        String[] expectedLines = expected.split("\n", -1);

        int maxLines = actualLines.length;
        if (expectedLines.length > maxLines) {
            maxLines = expectedLines.length;
        }

        for (int i = 0; i < maxLines; i++) {
            String act;
            String exp;

            if (i < actualLines.length) {
                act = actualLines[i];
            } else {
                act = "<missing line>";
            }

            if (i < expectedLines.length) {
                exp = expectedLines[i];
            } else {
                exp = "<missing line>";
            }

            if (!act.equals(exp)) {
                System.out.println("       Line " + (i + 1) + " differs:");
                System.out.println("         Expected: [" + exp + "]");
                System.out.println("         Actual:   [" + act + "]");
            }
        }
    }
}
