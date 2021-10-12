package ex44;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Caitlin Fabian
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

class Product{
    private Object name;
    private Object price;
    private Object quantity;

    public Product(Object name, Object price, Object quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    // Prints the desired Format for the product
    public String toString(){
        String format = "Name: "+ name+ "\nPrice: "+ price+ "\nQuantity: "+ quantity;
        return format;
    }
}
public class App {

    static public void data(String answer)throws Exception{
        // reads the File into an object
        Object object = new JSONParser().parse(new FileReader("c:/users/caitl/desktop/exercise44_input.json"));
        // Casts the object to JSONObject
        JSONObject jsonObject = (JSONObject) object;

        // typecasting product to JSONObject
        JSONArray products = (JSONArray) jsonObject.get("products");

        // Uses an iterator to individually access the product from the JSON array
        Iterator i = products.iterator();
        // While there is more data it gets the desired product and makes it a new Product object
        while(i.hasNext()){
            JSONObject inner = (JSONObject) i.next();
            if(answer.equals(inner.get("name"))) {
                Product product = new Product(inner.get("name"), inner.get("price"), inner.get("quantity"));
                System.out.println(product.toString());
            }
        }

    }
    // Checks if the user input is present in the JSON array. Returns a boolean expression
    public static boolean presentProduct(String answer)throws Exception{

        Object object = new JSONParser().parse(new FileReader("c:/users/caitl/desktop/exercise44_input.json"));
        JSONObject jsonObject = (JSONObject) object;

        // typecasting product to JSONObject
        JSONArray products = (JSONArray) jsonObject.get("products");

        Iterator i = products.iterator();
        boolean flag = true;
        while(i.hasNext()){
            JSONObject inner = (JSONObject) i.next();
            if(answer.equals(inner.get("name"))) {
                flag = false;
            }
        }
        return !flag;
    }

    public static void main(String[]args) throws Exception {

        Scanner input = new Scanner(System.in);
        boolean flag = false;
        // Keep asking what is the name of your product if the product is not found
        while(!flag) {
            System.out.print("What is the name of the product? ");
            String answer = input.nextLine();
            flag = presentProduct(answer);
            if(!flag){
                System.out.println("Sorry, that product was not found in our inventory.");
            }
            else data(answer);
        }
    }
}

