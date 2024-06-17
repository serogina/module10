import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    private Map<String, Integer> mapWorlds = new HashMap();

    public void countWord(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + fileName + " not found.");
        } else {
            try(FileInputStream fIO = new FileInputStream(file);
                Scanner fileScanner = new Scanner(fIO)){
                        while(fileScanner.hasNext()) {
                            String world = fileScanner.next();
                            Integer value = (Integer)this.mapWorlds.getOrDefault(world, 0);
                            this.mapWorlds.put(world, value + 1);
                        }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            for (Map.Entry<String, Integer> entry : mapWorlds.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        }
    }
}
