package com.project.ecobike;

/**
 *
 * @author Bohdan Skrypnyk
 */
class SearchThread extends Thread {

    private static Search search = new Search();

    @Override
    public void run() {
        search.fndItem();
    }
}

class UserInputThread extends Thread {

    UserInput userInput = new UserInput();

    @Override
    public void run() {
        userInput.dispalyMenu();
    }
}

public class Multithreading {

    public static boolean searchActivity;
    private static Validation validate = new Validation();

    public void run() {
        SearchThread searchThread = new SearchThread();
        UserInput userInput = new UserInput();
        synchronized (searchThread) {
            searchThread.start();
            searchActivity = searchThread.isAlive();
            validate.searchStatus();
            userInput.dispalyMenu();

        }
    }

}
