

public class Main {
    public static void main(String[] args) {
        System.out.println("===========   task 1   ===========" );
        CheckPhoneNumber checkPhoneNumber = new CheckPhoneNumber();
        checkPhoneNumber.checkFile("src\\main\\resources\\file.txt");

        System.out.println("===========   task 2   ===========" );
        JSONmaker jsoNmaker = new JSONmaker();
        jsoNmaker.read("src\\main\\resources\\file2.txt","src/main/resources/users.json");

        System.out.println("===========   task 3   ===========" );
        WordCounter wordCounter = new WordCounter();
        wordCounter.countWord("src\\main\\resources\\words.txt");


    }
}