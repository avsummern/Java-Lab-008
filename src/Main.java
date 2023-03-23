import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner s = new Scanner(System.in);
        String quit = "q";
        boolean skipWs = false;
        File newPath= null;
        Path enteredFile = null;

        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        while(true){
            System.out.println("Please enter file name \nOr enter Q to quit");
            String pathName = s.nextLine();
            if (pathName.equalsIgnoreCase(quit)){
                break;
            }
            enteredFile = Paths.get("resources", pathName);
            Path absPath = enteredFile.toAbsolutePath();
            newPath = absPath.toFile();

            // Ask the user if they would like to skip whitespace
            System.out.println("Would you like to skip whitespace? (y/n)");
            String wsAnswer = s.nextLine();
            if (wsAnswer.equalsIgnoreCase("y")){
                skipWs = true;
                break;
            }
            else {
                skipWs = false;
                break;
            }
        }
            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File

            // Ask the user if they would like to skip whitespace

            // Create a variable called skipWs that stores the user's response as a boolean

            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats ourFile = new FileStats(newPath, skipWs);
                // You will need to call the fs.read method, which you need to implement!
                ourFile.read();

                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
                System.out.printf("Stats: lines - %d, words - %d, chars - %d %s", ourFile.getNumLines(), ourFile.getNumWords(),ourFile.getNumChars(), ourFile.getFileName());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

    }
}
