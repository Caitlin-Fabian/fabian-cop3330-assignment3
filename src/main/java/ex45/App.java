package ex45;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Caitlin Fabian
 */
import java.io.*;
import java.util.Scanner;

class Text{
    private String text;
    public Text(String text){
        this.text = text;
    }
    // Replaces the word utilize with the word use and returns the new String
    public String replacement(){
        String replaced = text.replace("utilize", "use");
        return replaced;
    }
}

public class App {

    // Reads in the file and appends all of the lines into one String
    public static String readFile() throws IOException {

        StringBuilder sb = new StringBuilder();

        File myobj = new File("C:/users/caitl/desktop/exercise45_input.txt");
        Scanner reader = new Scanner(myobj);

        while (reader.hasNextLine()) {

            String line = reader.nextLine();
            sb.append(line).append("\n");
        }

        return sb.toString();
    }
// Writes the file into a new File that the user inputs
    public static void writeToFile(String fileName, Text content){
        try {
            File output = new File(fileName);

            output.createNewFile();
            FileWriter right = new FileWriter(fileName);

            BufferedWriter bw = new BufferedWriter(right);
            bw.write(content.replacement());

            bw.close();
            System.out.println("Done");
        }
        // Checks for exceptions/ errors
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {

        String text = readFile();
        Text newString = new Text(text);
        System.out.println(newString.replacement());
        System.out.print("What is the name of the output file? ");
        Scanner input = new Scanner(System.in);
        String file = input.nextLine();

        writeToFile(file, newString);
    }
}
