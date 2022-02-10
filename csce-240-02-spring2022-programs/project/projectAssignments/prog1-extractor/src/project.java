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

public class project {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        

        System.out.println("Hi! Welcome to the District Chatbot!\nWhich district would you like to learn about");
        String district = keyboard.next();
        System.out.println("What would you like to learn about district "+district);
        readFile();
        keyboard.close();
        
    }

    public static void readFile(){
        String in_file = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\prog1-extractor\\data\\info.txt";
        String out_file = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\prog1-extractor\\data\\output.txt";
        int lineNumber = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            FileInputStream in = new FileInputStream(in_file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
            FileOutputStream out = new FileOutputStream(out_file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            
            String line = reader.readLine();
            
            while (line != null){
                writer.write(line);
                writer.newLine();
                String[] word = line.split("\\s+");
                charCount += line.length();
                
                wordCount += word.length;

                lineNumber ++;

                line = reader.readLine();
            }
            reader.close();
            writer.close();
            System.out.println("There are "+lineNumber+ " lines");
            System.out.println("There are "+wordCount+ " words");
            System.out.println("There are "+charCount+ " characters");
        }
        catch(Exception e){
            System.out.println("Exception = " +e);
        }
    }
}