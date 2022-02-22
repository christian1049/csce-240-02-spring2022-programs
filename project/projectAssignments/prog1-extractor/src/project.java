
/**
 * Christian Lee
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.FileReader;

public class project {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> information = new ArrayList<String>();
        System.out.println("Hi! Welcome to the District Chatbot!\nWhich district would you like to learn about");
        String district = keyboard.next();
        readFile();
        collectData(information);
        populate(information);
        keyboard.close();

    }

    public static void readFile() {
        String in_file = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\project\\projectAssignments\\prog1-extractor\\data\\info.txt";
        String out_file = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\project\\projectAssignments\\prog1-extractor\\data\\output.txt";
        int lineNumber = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            FileInputStream in = new FileInputStream(in_file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            FileOutputStream out = new FileOutputStream(out_file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            String line = reader.readLine();

            while (line != null) {
                writer.write(line);
                writer.newLine();
                String[] word = line.split("\\s+");
                charCount += line.length();

                wordCount += word.length;

                lineNumber++;

                line = reader.readLine();
            }
            writer.write("There are " + lineNumber + " lines\nThere are " + wordCount + " words\nThere are " + charCount
                    + " characters");

            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }
    }

    public static void collectData(ArrayList<String> information) {

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\project\\projectAssignments\\prog1-extractor\\data\\output.txt"))) {
            while (reader.ready()) {
                information.add(reader.readLine());
            }
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }

    }

    public static void populate(ArrayList<String> information) {
        boolean cont = true;
        String name = information.get(0);
        String region = information.get(2);
        String addressCola = information.get(3);
        String addressHome = information.get(4);
        String phoneNumberBiz = information.get(5);
        String phoneNumberHome = information.get(6);
        String personalInfo = information.get(10);
        for (int i = 0; i < 6; i++) {

            personalInfo += "\n" + information.get(i + 10);
        }
        String committeeAssignments = information.get(17);
        String bills = information.get(7);
        String votingRec = information.get(7);
        String servicePubOffice = information.get(7);

        Scanner keyboard = new Scanner(System.in);
        while (cont) {
            System.out.println("What would you like to know about your representative?");
            String response = keyboard.nextLine();
            if (response.toLowerCase().contains("name")) {
                System.out.println(name);
            } else if (response.toLowerCase().contains("region")) {
                System.out.println(region);
            } else if (response.toLowerCase().contains("work address")
                    || response.toLowerCase().contains("columbia address")) {
                System.out.println(addressCola);
            } else if (response.toLowerCase().contains("home address")) {
                System.out.println(addressHome);
            } else if (response.toLowerCase().contains("work phone number")) {
                System.out.println(phoneNumberBiz);
            } else if (response.toLowerCase().contains("home phone number")) {
                System.out.println(phoneNumberHome);
            } else if (response.toLowerCase().contains("personal information")) {
                System.out.println(personalInfo);
            } else if (response.toLowerCase().contains("committee assignments")) {
                System.out.println(committeeAssignments);
            } else if (response.toLowerCase().contains("bills")) {
                System.out.println("View this link in your browser to see " + bills);
            } else if (response.toLowerCase().contains("voting record")) {
                System.out.println("View this link in your browser to see " + votingRec);
            } else if (response.toLowerCase().contains("service public office")) {
                System.out.println("View this link in your browser to see " + servicePubOffice);
            } else {
                System.out.println("Try rewording phrase");
            }
            System.out.println("Would you like to ask another question?");
            String another = keyboard.next();
            if (another.equals("no")) {
                System.out.println("Goodbye");
                System.exit(0);
            }
        }

    }
}