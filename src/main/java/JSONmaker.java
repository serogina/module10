import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSONmaker {
    private List<User> userList = new ArrayList<>();
    public void read(String fileName, String jsonFile){
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + fileName + " not found.");
        } else {
            try (FileInputStream fIS = new FileInputStream(file);
                 Scanner fileScanner = new Scanner(fIS))
            {
                int counter = 0;
                while (fileScanner.hasNext()) {
                    String line = fileScanner.nextLine();
                    counter++;
                    if(counter == 1){continue;}// перший рядок це шапка
                    createUser(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            createJSON(jsonFile);
        }
    }

    private void createUser(String line){
        String[] mWords = line.split(" ");
        int kol  = mWords.length;
        String name = "";
        int age = 0;
        if (kol > 0){name = mWords[0];}
        if (kol > 1){age = Integer.parseInt(mWords[1]);}
        User user = new User(name, age);
        userList.add(user);
    }

    private void createJSON(String jsonFile){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JSONmaker jsoNmaker = new JSONmaker();
        String userJson = gson.toJson(userList);

        File file = new File(jsonFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {
            writer.write(userJson);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
