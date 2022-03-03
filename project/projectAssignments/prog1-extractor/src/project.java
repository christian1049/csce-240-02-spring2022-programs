
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

        try (BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\project\\projectAssignments\\prog1-extractor\\data\\output.txt"))) {
            while (reader.ready()) {
                information.add(reader.readLine());
            }
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }

    }

    public static void populate(ArrayList<String> information) {
        boolean cont = true;
        String name = information.get(0) + "\n";
        String region = information.get(2) + "\n";
        String addressCola = information.get(3) + "\n";
        String addressHome = information.get(4) + "\n";
        String phoneNumberBiz = information.get(5) + "\n";
        String phoneNumberHome = information.get(6) + "\n";
        String personalInfo = "";
        for (int i = 0; i < 6; i++) {
            personalInfo += "\n" + information.get(i + 10);
        }
        String committeeAssignments = information.get(17) + "\n";
        String bills = information.get(7) + "\n";
        String votingRec = information.get(7) + "\n";
        String servicePubOffice = information.get(7) + "\n";
        String contact = "\nContact Information: \n";
        contact = contact + name + region + addressCola + addressHome + phoneNumberBiz + phoneNumberHome;
        String all = name+region+addressCola+addressHome+phoneNumberBiz+phoneNumberHome+personalInfo+bills+servicePubOffice;
        Scanner keyboard = new Scanner(System.in);
        
        while (cont) {
            System.out.println("What would you like to know about your representative?");
            String response = keyboard.nextLine();
            if (response.toLowerCase().contains("name") || response.toLowerCase().contains("live")) {
                getName(name);
            } else if (response.toLowerCase().contains("region")) {
                getRegion(region);
                contact.concat(name).concat(region).concat(addressCola).concat(addressHome).concat(phoneNumberBiz)
                        .concat(phoneNumberBiz);
            } else if (response.toLowerCase().contains("columbia")
                    || response.toLowerCase().contains("work") && response.toLowerCase().contains("address")) {
                getWorkAddress(addressCola);
            } else if (response.toLowerCase().contains("home") && response.toLowerCase().contains("address")) {
                getHomeAddress(addressHome);
            } else if (response.toLowerCase().contains("work") && (response.toLowerCase().contains("phone")
                    || response.toLowerCase().contains("number")) || response.toLowerCase().contains("work phone number")) {
                getWorkPhone(phoneNumberBiz);
            } else if (response.toLowerCase().contains("home") && response.toLowerCase().contains("phone")
                    || response.toLowerCase().contains("number") || response.toLowerCase().contains("home phone number")) {
                getHomePhone(phoneNumberHome);
            } else if (response.toLowerCase().contains("personal") || response.toLowerCase().contains("information")) {
                getPersonalInfo(personalInfo);
            } else if (response.toLowerCase().contains("committee")) {
                getCommitteeAssign(committeeAssignments);
            } else if (response.toLowerCase().contains("bills")) {
                getBills(bills);
            } else if (response.toLowerCase().contains("voting record") || response.toLowerCase().contains("vote")
                    || response.toLowerCase().contains("record")) {
                getRecord(votingRec);
            } else if (response.toLowerCase().contains("service")
                    || response.toLowerCase().contains("public") && response.toLowerCase().contains("office")) {
                getServicePublic();
            } else if (response.toLowerCase().contains("tell me about the rep")
                    || response.toLowerCase().contains("contact")) {
                getContact(contact);
            } else if (response.toLowerCase().contains("everything") || response.toLowerCase().contains("all")) {
                getAll(all);
            } else {
                System.out.println("Try rewording phrase");
            }
            System.out.println("Would you like to ask another question?");
            String another = keyboard.nextLine();
            if (another.contains("no") || another.toLowerCase().contains("quit") || another.toLowerCase().equals("q")
                    || another.toLowerCase().equals("n")) {
                System.out.println("Goodbye");
                System.exit(0);
            }
        }
    }

    public static void getName(String name) {
        System.out.println("\n" + name);
    }

    public static void getRegion(String region) {
        System.out.println("\nRegion: " + region);
    }

    public static void getWorkAddress(String workAdd) {
        System.out.println("\nWork Address: " + workAdd);
    }

    public static void getHomeAddress(String homeAdd) {
        System.out.println("\nHome Address: " + homeAdd);
    }

    public static void getWorkPhone(String workPhone) {
        System.out.println("\nWork Phone Number: " + workPhone);
    }

    public static void getHomePhone(String homePhone) {
        System.out.println("\nHome Phone Number: " + homePhone);
    }

    public static void getPersonalInfo(String personalInfo) {
        System.out.println("\nPersonal Information:\n" + personalInfo + "\n");
    }

    public static void getCommitteeAssign(String committeeAssign) {
        System.out.println("\nCommittee Assignments: " + committeeAssign);
    }

    public static void getBills(String bills) {
        System.out.println("\nView this link in your browser to see bills " + bills);
    }

    public static void getRecord(String record) {
        System.out.println("\nView this link in your browser to see voting record " + record);
    }

    public static void getServicePublic() {
        System.out.println("\nHouse of Representatives, 2017 - Present\n");
    }

    public static void getAll(String all) {
        System.out.println(all);
    }

    public static void getContact(String contact) {
        System.out.println(contact);
    }
}