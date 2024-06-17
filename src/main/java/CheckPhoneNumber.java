import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CheckPhoneNumber {

    public void checkFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + fileName + " not found.");
        }

        try (FileInputStream fIO = new FileInputStream(file);
            Scanner fileScanner = new Scanner(fIO))
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
        String pattern1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        String pattern2 = "\\d{3}-\\d{3}-\\d{4}";
        return phoneNumber.matches(pattern1) || phoneNumber.matches(pattern2);
    }
}
