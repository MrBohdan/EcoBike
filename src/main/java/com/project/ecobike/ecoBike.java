package com.project.ecobike;

/**
 *
 * @author Bohdan Skrypnyk
 */
public class ecoBike {

    public static void main (String [] args){
        FileReader fileReader = new FileReader();
        fileReader.readFile();
        UserInput userInput = new UserInput();
        userInput.dispalyMenu();
    }
}
