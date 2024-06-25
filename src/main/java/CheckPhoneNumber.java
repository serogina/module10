import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPhoneNumber {
    static Pattern pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
    static Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

    public void checkFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + fileName + " not found.");
        }

        try (FileInputStream fIS = new FileInputStream(file);
            Scanner fileScanner = new Scanner(fIS))
            {
                while(fileScanner.hasNext()) {
                      String line = fileScanner.nextLine();
                        if (isValidPhoneNumber(line)) {
                            System.out.println(line);
                        }
                }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return pattern1.matcher(phoneNumber).matches() || pattern2.matcher(phoneNumber).matches();
    }

}
