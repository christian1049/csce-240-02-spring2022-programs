
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
import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.nio.file.StandardCopyOption.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.Arrays;

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

    public static void systemChatInfo(String a, String b) {
        try {
            File g = new File("..\\data\\chat_sessions", b);
            FileWriter fileWriter = new FileWriter(g.getName(), true);
            BufferedWriter writer = new BufferedWriter(new FileWriter(g, true));
            writer.write("\nSystem Output: " + a + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.print("ERROR!!@");
            System.exit(0);
        }

    }

    public static void statistics(int i, int j, long k, String b) {
        try {
            File g = new File("..\\data\\chat_sessions", b);
            FileWriter fileWriter = new FileWriter(g.getName(), true);
            BufferedWriter writer = new BufferedWriter(new FileWriter(g, true));
            writer.write("Number of user inputs " + i + ". Number of system outputs " + j + ". Time of session " + k
                    + " seconds");
            writer.close();
        } catch (IOException e) {
            System.out.print("ERROR!#");
            System.exit(0);
        }
    }

    public static void readFile() {
        String in_file = "..\\data\\info.txt";
        String out_file = "..\\data\\output.txt";
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

    public static void csvFile(String i, int j, int k, long l) {
        try {
            String line = null;
            Scanner scanner = new Scanner(new File("chat_statistics.csv"));
            scanner.useDelimiter("\n");
            double counter = 0;
            while(scanner.hasNextLine()){
                counter++;
                
                scanner.nextLine();
            }
            counter = (int)Math.ceil(counter/3);
                FileWriter fw = new FileWriter("chat_statistics.csv", true);
                fw.append(String.valueOf(counter));
                fw.append(",");
                fw.append(i);
                fw.append(",");
                fw.append(String.valueOf(j));
                fw.append(",");
                fw.append(String.valueOf(k));
                fw.append(",");
                String str = l + "";
                fw.append(str);
                fw.append(" seconds\n\n");
                fw.flush();
            
        } catch (Exception e) {
            System.out.println("ERRRRR");
        }
    }

    public static void populate(ArrayList<String> information) {
        Instant start = Instant.now();
        boolean cont = true;
        String name = "\nName: " + information.get(0) + "\n";
        String region = "\nRegion: " + information.get(2) + "\n";
        String addressCola = "\nColumbia Address: " + information.get(3) + "\n";
        String addressHome = "\nHome Address: " + information.get(4) + "\n";
        String phoneNumberBiz = "\nBusiness Phone Number: " + information.get(5) + "\n";
        String phoneNumberHome = "\nHome Phone Number: " + information.get(6) + "\n";
        String personalInfo = "";
        for (int i = 0; i < 6; i++) {
            personalInfo += "\n" + information.get(i + 10);
        }
        String committeeAssignments = "\nCommittee Assignments: " + information.get(17) + "\n";
        String bills = "\nBills: " + information.get(7) + "\n";
        String votingRec = "\nVoting Record: " + information.get(7) + "\n";
        String servicePubOffice = "\nService Public Office: " + information.get(7) + "\n";
        String contact = "\nContact Information: \n";
        contact = contact + name + region + addressCola + addressHome + phoneNumberBiz + phoneNumberHome;
        String all = name + region + addressCola + addressHome + phoneNumberBiz + phoneNumberHome + personalInfo + bills
                + servicePubOffice;
        Scanner keyboard = new Scanner(System.in);
        try {

            File p = new File("..\\data\\chat_statistics.csv");
            
            if (p.length() == 0) {
                FileWriter filer = new FileWriter("chat_statistics.csv", true);
                // BufferedWriter filers = new BufferedWriter(new FileWriter(p, false));

                filer.append("S.NO");
                filer.append(",");
                filer.append("chat_file");
                filer.append(",");
                filer.append("#user_utterance");
                filer.append(",");
                filer.append("#system_utterance");
                filer.append(",");
                filer.append("time_taken");
                filer.append("\n");
                filer.flush();
            }

            LocalDate fileName = LocalDate.now();
            LocalTime fileName2 = LocalTime.now();

            String time = fileName2.toString();
            String newTime = time.replace(":", "-");
            String typicalFile = fileName + "_" + newTime + ".txt";
            File f = new File("..\\data\\chat_sessions", fileName + "_" + newTime + ".txt");
            /*
             * File h = new File(fileName + "_" + newTime + ".txt");
             * 
             * h.delete();
             */
            int systemCount = 1;
            int userCount = 1;
            while (cont) {

                FileWriter fileWriter = new FileWriter(f.getName(), true);
                BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
                System.out.println("What would you like to know about your representative?");
                String response = keyboard.nextLine();

                String[] r = response.split(" ");

                writer.write("User Output: \n" + response + "\n");
                writer.close();

                int countN = 0;
                int countR = 0;
                int countWA = 0;
                int countHA = 0;
                int countBP = 0;
                int countHP = 0;
                int countPI = 0;
                int countCA = 0;
                int countB = 0;
                int countVR = 0;
                int countSP = 0;
                int countC = 0;
                int countE = 0;

                double total = r.length;
                for (String i : r) {
                    if (i.toLowerCase().contains("name")) {
                        countN++;
                    } else if (i.toLowerCase().contains("region")) {
                        contact.concat(name).concat(region).concat(addressCola).concat(addressHome)
                                .concat(phoneNumberBiz)
                                .concat(phoneNumberBiz);
                        countR++;

                    } else if (i.toLowerCase().contains("columbia")) {
                        countWA++;
                    } else if (i.toLowerCase().contains("address")) {
                        countWA++;
                        countHA++;
                    } else if (i.toLowerCase().contains("work")) {
                        countWA++;
                        countBP++;
                    } else if (i.toLowerCase().contains("number")) {
                        countBP++;
                        countHP++;
                    } else if (i.toLowerCase().contains("phone")) {
                        countBP++;
                        countHP++;
                    } else if (i.toLowerCase().contains("home")) {
                        countHA++;
                        countHP++;
                    } else if (i.toLowerCase().contains("business")) {
                        countBP++;
                    } else if (i.toLowerCase().contains("personal") || i.toLowerCase().contains("info")) {
                        countPI++;
                    } else if (i.toLowerCase().contains("personal")) {
                        countHP++;
                    } else if (i.toLowerCase().contains("committee")) {
                        countCA++;
                    } else if (i.toLowerCase().contains("bills")) {
                        countB++;
                    } else if (i.toLowerCase().contains("voting") || i.toLowerCase().contains("vote")
                            || i.toLowerCase().contains("record")) {
                        countVR++;
                    } else if (i.toLowerCase().contains("service")
                            || i.toLowerCase().contains("public") || i.toLowerCase().contains("office")) {
                        countSP++;
                    } else if (i.toLowerCase().contains("contact") || i.toLowerCase().contains("tell")
                            || i.toLowerCase().contains("me") || i.toLowerCase().contains("about")
                            || i.toLowerCase().contains("the") || i.toLowerCase().contains("rep")) {
                        countC++;
                    } else if (i.toLowerCase().contains("everything") || i.toLowerCase().contains("all")) {
                        countE++;
                    } else if (i.toLowerCase().contains("quit") || i.toLowerCase().contains("q")){
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                }
                r = null;
                int[] check = { countN, countR, countWA, countHA, countBP, countHP, countPI, countCA, countB, countVR,
                        countSP, countC, countE };
                double max = 0;
                int location = 0;

                for (int i = 0; i < check.length; i++) {
                    if (check[i] > max) {
                        max = check[i];
                        location = i;
                    }
                }
                if (max / total > 0.7) {
                    if (location == 0) {
                        getName(name);
                        systemChatInfo(name, typicalFile);
                    } else if (location == 1) {
                        getRegion(region);
                        systemChatInfo(region, typicalFile);

                    } else if (location == 2) {
                        getWorkAddress(addressCola);
                        systemChatInfo(addressCola, typicalFile);
                    } else if (location == 3) {
                        getHomeAddress(addressHome);
                        systemChatInfo(addressHome, typicalFile);
                    } else if (location == 4) {
                        getWorkPhone(phoneNumberBiz);
                        systemChatInfo(phoneNumberBiz, typicalFile);
                    } else if (location == 5) {
                        getHomePhone(phoneNumberHome);
                        systemChatInfo(phoneNumberHome, typicalFile);
                    } else if (location == 6) {
                        getPersonalInfo(personalInfo);
                        systemChatInfo(personalInfo, typicalFile);
                    } else if (location == 7) {
                        getCommitteeAssign(committeeAssignments);
                        systemChatInfo(committeeAssignments, typicalFile);
                    } else if (location == 8) {
                        getBills(bills);
                        systemChatInfo(bills, typicalFile);
                    } else if (location == 9) {
                        getRecord(votingRec);
                        systemChatInfo(votingRec, typicalFile);
                    } else if (location == 10) {
                        getServicePublic();
                        systemChatInfo(publicService(), typicalFile);

                    } else if (location == 11) {
                        getContact(contact);
                        systemChatInfo(contact, typicalFile);
                    } else if (location == 12) {
                        getAll(all);
                        systemChatInfo(all, typicalFile);
                    } else {
                        System.out.println("Error");
                    }
                }

                boolean repeat = true;

                while (repeat) {
                    System.out.println("Would you like to ask another question?");

                    String another = keyboard.nextLine();
                    if (another.toLowerCase().contains("no") || another.toLowerCase().contains("quit")
                            || another.toLowerCase().equals("q")
                            || another.toLowerCase().equals("n")) {
                        System.out.println("Goodbye");
                        Instant end = Instant.now();
                        long seconds = ChronoUnit.SECONDS.between(start, end);
                        Integer i = (int) (long) seconds;
                        statistics(userCount, systemCount, seconds, typicalFile);
                        csvFile(typicalFile, userCount, systemCount, seconds);
                        System.exit(0);

                    } else if (another.toLowerCase().contains("yes") || another.toLowerCase().contains("y")
                            || another.toLowerCase().equals("indeed")
                            || another.toLowerCase().equals("continue")) {

                        systemCount += 1;
                        userCount++;
                        cont = true;
                        repeat = false;

                    } else {
                        System.out.println("Please rephrase as \"yes\" or \"no\"");
                    }
                }
            }

        } catch (IOException e) {
            System.out.print("ERROR@$");
            System.exit(0);
        }

    }

    public static void getName(String name) {
        System.out.println(name);
    }

    public static void getRegion(String region) {
        System.out.println(region);
    }

    public static void getWorkAddress(String workAdd) {
        System.out.println(workAdd);
    }

    public static void getHomeAddress(String homeAdd) {
        System.out.println(homeAdd);
    }

    public static void getWorkPhone(String workPhone) {
        System.out.println(workPhone);
    }

    public static void getHomePhone(String homePhone) {
        System.out.println(homePhone);
    }

    public static void getPersonalInfo(String personalInfo) {
        System.out.println(personalInfo);
    }

    public static void getCommitteeAssign(String committeeAssign) {
        System.out.println(committeeAssign);
    }

    public static void getBills(String bills) {
        System.out.println(bills);
    }

    public static void getRecord(String record) {
        System.out.println(record);
    }

    public static void getServicePublic() {
        System.out.println("\nHouse of Representatives, 2017 - Present\n");
    }

    public static String publicService() {
        return "\nHouse of Representatives, 2017 - Present\n";
    }

    public static void getAll(String all) {
        System.out.println(all);
    }

    public static void getContact(String contact) {
        System.out.println(contact);
    }
}