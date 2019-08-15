package services;

import helpers.HelperForPhones;
import helpers.HelperForRoles;
import entities.User;
import pointOfEntry.Main;

import java.util.Scanner;

public class Edit {
    private Scanner in;
    private String tempString;
    private boolean tempBoolean;
    private Validator validator;
    private Service service;
    private Enter enter;

    public Edit(){
        this.service = new Service();
        this.in = new Scanner(System.in);
        this.tempString = "";
        this.tempBoolean = false;
        this.validator = new Validator();
        this.enter = new Enter();
    }

    public void editUser(){
        if(Main.users.size() == 0){
            System.out.println("There are no users. services.Create user");
            return;
        }

        char selectUser = service.selectUserToChange();
        ConsoleView.showChanges();
        char changeCondition = service.acceptAction();
        User user = Main.users.get(Character.getNumericValue(selectUser) - 1);
        while(changeCondition!= '7') {
            if (changeCondition == '1') {
                editName(user);
            } else if (changeCondition== '2') {
                editSurname(user);
            } else if (changeCondition == '3'){
                editEmail(user);
            } else if (changeCondition == '4'){
                editRoles(user);
            } else if (changeCondition == '5'){
                editPhones(user);
            } else if (changeCondition == '6'){
                Main.users.remove(user);
            } else {
                System.out.println("Invalid character. Please enter the character again from 1 to 6");
                changeCondition = service.acceptAction();
                continue;
            }

            ConsoleView.showChanges();
            changeCondition = service.acceptAction();
        }
    }

    public void editName(User user){
        user.setName(enter.enterName());
        System.out.println("Name was changed successfully");
    }

    public void editSurname(User user){
        user.setSurname(enter.enterSurname());
        System.out.println("Surname was changed successfully");
    }

    public void editEmail(User user){
        user.setSurname(enter.enterEmail());
        System.out.println("Email was changed successfully");
    }

    public void editRoles(User user){
        ConsoleView.showActionForRoles();
        char selectUser = service.acceptAction();
        tempBoolean = false;
        while(!tempBoolean){
            if(selectUser == '1'){
                addRole(user);
                tempBoolean = true;
            } else if (selectUser == '2'){
                editRole(user);
                tempBoolean = true;
            } else {
                System.out.println("Wrong input try again");
                ConsoleView.showActionForRoles();
                selectUser = service.acceptAction();
            }
        }
    }

    public void editPhones(User user){
        ConsoleView.showActionForPhones();
        char selectUser = service.acceptAction();
        tempBoolean = false;
        while(!tempBoolean) {
            if (selectUser == '1') {
                addPhone(user);
                tempBoolean = true;
            } else if (selectUser == '2') {
                editPhone(user);
                tempBoolean = true;
            } else {
                System.out.println("Wrong input try again");
                ConsoleView.showActionForPhones();
                selectUser = service.acceptAction();
            }
        }
    }

    public void addRole(User user){
        if (user.getRoles().size() < 3){
            System.out.println("Print other role");
            user.getRoles().add(in.next());
        } else {
            System.out.println("There are already three roles");
        }
    }

    public void editRole(User user){
        char selectUser = service.helperInput(user.getRoles(), new HelperForRoles(user));
        System.out.println("Print new role");
        user.getRoles().remove(Character.getNumericValue(selectUser) - 1);
        user.getRoles().add(Character.getNumericValue(selectUser) - 1, in.next());
        System.out.println("Role was changed successfully");
    }

    public void addPhone(User user){
        if (user.getMobilePhones().size() < 3){
            System.out.println("Print other phone");
            do {
                tempString = in.nextLine();
                tempBoolean = validator.isValidMobile(tempString);
                if (tempBoolean) {
                    user.getMobilePhones().add(tempString);
                    System.out.println("Mobile phone was added successfully");
                } else {
                    System.out.println("Wrong mobile. Try again with this template 375** *******");
                }
            } while(!tempBoolean);
        }
    }

    public void editPhone(User user){
        char selectUser = service.helperInput(user.getMobilePhones(), new HelperForPhones(user));
        user.getMobilePhones().remove(Character.getNumericValue(selectUser) - 1);
        System.out.println("Print new phone");
        do {
            tempString = in.nextLine();
            tempBoolean = validator.isValidMobile(tempString);
            if (tempBoolean) {
                user.getMobilePhones().add(Character.getNumericValue(selectUser) - 1, tempString);
                System.out.println("Mobile phone was changed successfully");
            } else {
                System.out.println("Wrong mobile. Try again with this template 375** *******");
            }
        } while(!tempBoolean);
    }
}
