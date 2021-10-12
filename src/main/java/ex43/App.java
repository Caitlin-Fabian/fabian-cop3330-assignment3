package ex43;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Caitlin Fabian
 */
import java.util.Scanner;
import java.io.*;

public class App {
    // Creates the website that holds the other files
    public static void websiteFolder(String siteName){
        // Path for the folder
        String siteFile = "src/main/java/ex43/website";
        File siteFolder = new File(siteFile);
        // Directory to the file
        boolean siteFolderCreated = siteFolder.mkdir();
        // creates the file with the user's input name
        String userSiteFile = siteFile + "//"+ siteName;
        // File created
        File userSiteFolder = new File(userSiteFile);

        boolean userSiteFolderCreated = userSiteFolder.mkdir();
        // Prints out to notify when the folders are created
        System.out.println("Created:  ./website/" + siteName);

    }
    // Creates the html file
    public static void htmlFile(String siteName, String author) throws IOException{

        // Creates the html file with the siteName and the index.html ending
        File htmlFile = new File( "src/main/java/ex43/website/"+ siteName+ "/index.html");
        boolean htmlFileCreated = htmlFile.createNewFile();

        // Using FileWriter to print to the file
        FileWriter output = new FileWriter(htmlFile);

        output.write("<!DOCTYPE html>\n<html>\n<head>\n<title> " +siteName+ "<title>\n</head>\n");
        output.write("<meta> "+ author+ "<meta/>\n</html>");

        // Prints when successfully created
        System.out.println("Created: ./website/"+ siteName+"/index.html");

        // Closing the writer
        output.close();

    }
    //Creates the JavaScript Folder
    public static void JSFile(String siteName){
        String siteFile = "src/main/java/ex43/website/";

        String userJSFile = siteFile + "//" + siteName + "/js/";
        File userJSFolder = new File(userJSFile);

        boolean userJSFolderCreated = userJSFolder.mkdir();

        System.out.println("Created:  ./website"+ siteName + "/js");
    }
    // Creates the CSS Folder
    public static void CSSFile(String siteName){

        String siteFile = "src/main/java/ex43/website/";

        String userCSSFile = siteFile + "//" + siteName + "/css/";
        File userCSSFolder = new File(userCSSFile);

        boolean userJSFolderCreated = userCSSFolder.mkdir();

        System.out.println("Created:  ./website"+ siteName + "/css");
    }

    public static void main(String[] args) throws IOException {

        // Prompts for the user input of the site Name and the author
        Scanner input = new Scanner(System.in);
        System.out.print("SiteName: ");
        String name = input.nextLine();
        System.out.print("Author Name: ");
        String author = input.nextLine();

        // Prompts if the user wants a folder for JavaScript and CSS
        System.out.print("Do you want a folder for JavaScript? (y/n) ");
        String JSanswer = input.nextLine();
        System.out.print("Do you want a folder for CSS? (y/n) ");
        String CSSanswer = input.nextLine();

        // Calls all of the respected methods
        websiteFolder(name);
        htmlFile(name, author);
        if(JSanswer.equals("y")){
            JSFile(name);
        }
        if(CSSanswer.equals("y")) {
            CSSFile(name);
        }
    }

}
