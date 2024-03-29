package services;

import helpers.HelperForPhones;
import helpers.HelperForUser;
import interfaces.View;
import pointOfEntry.Main;

import java.util.List;
import java.util.Scanner;

public class Service {
    private Scanner in;
    private Saver saver;
    private boolean tempBoolean;

    public Service(){
        this.saver = new Saver();
        this.in = new Scanner(System.in);
        this.tempBoolean = false;
    }

    public char acceptAction() {
        String input = in.next();
        if(input.length() > 1) {
            return '\u0000';
        } else {
            return input.charAt(0);
        }
    }

    public <T> char helperInput(List<T> list, View viewInt){
        viewInt.view();
        char selectUser = acceptAction();
        if(viewInt instanceof HelperForPhones){
            in.nextLine();
        }

        tempBoolean = false;
        while (!tempBoolean) {
            if (Character.getNumericValue(selectUser) < 0 || Character.getNumericValue(selectUser) > list.size()) {
                System.out.println("Wrong input try again");
                viewInt.view();
                selectUser = acceptAction();
                if(viewInt instanceof HelperForPhones){
                    in.nextLine();
                }
            } else {
                tempBoolean = true;
            }
        }

        return selectUser;
    }

    public char selectUserToChange(){
        System.out.println("Select user to change.");
        tempBoolean = false;
        char selectUser = helperInput(Main.users, new HelperForUser());
        return selectUser;
    }

    public void saveAndRewriteFile(){
        ConsoleView.showSaveFileActions();
        char exitCondition = acceptAction();
        if (exitCondition == '1') {
            ConsoleView.showRewriteFileActions();
            exitCondition = acceptAction();
            if (exitCondition == '1') {
                saver.saveFile(false);
            } else {
                saver.saveFile(true);
            }
        }
    }

    public void reloadFile(){
        if(Main.users.size() == 0){
            saver.loadFile(true);
        } else {
            ConsoleView.showReloadUsersActions();
            char exitCondition = acceptAction();
            if (exitCondition == '1') {
                saver.loadFile(true);
            } else {
                saver.loadFile(false);
            }
        }
    }

    public void clearFile(){
        saver.clearFile();
    }
}
