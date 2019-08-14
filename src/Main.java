import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static Validator validator = new Validator();
    static String tempString = "";
    static boolean tempBoolean = false;

    public static void main(String[] args){
        showActions();
        char exitCondition = acceptAction();
        while(exitCondition != '4') {
            if (exitCondition == '1') {
                createUser();
            } else if (exitCondition == '2') {
                editUser();
            } else if (exitCondition == '3'){
                viewUsers();
            } else {
                System.out.println("Invalid character. Please enter the character again from 1 to 4");
                exitCondition = acceptAction();
                continue;
            }

            chooseExitCondition();
            showActions();
            exitCondition = acceptAction();
        }
    }

    public static void showActions(){
        System.out.println("Select an action.");
        System.out.println("1. Сreate user.");
        System.out.println("2. Edit user.");
        System.out.println("3. View users.");
        System.out.println("4. Exit.");
    }

    public static void chooseExitCondition(){
        String exitQuestion = "\"Do you want to continue? y/n (Yes/No)";
        System.out.println(exitQuestion);
        char exitCondition = '\u0000';
        do{
            exitCondition = acceptAction();
            if (exitCondition == 'y') {
                return;
            } else if (exitCondition == 'n') {
                System.exit(0);
            } else {
                System.out.println("Repeat input: " + exitQuestion);
            }

        } while (exitCondition != 'y' || exitCondition != 'n');
    }

    public static char acceptAction() {
        String input = in.next();
        if(input.length() > 1) {
            return '\u0000';
        } else {
            return input.charAt(0);
        }
    }

    public static void createUser(){
        List<String> roles = new ArrayList<>();
        List<String> mobilePhones = new ArrayList<>();
        System.out.println("------Start user creation------");
        users.add(new User(enterName(), enterSurname(), enterEmail(), enterRole(roles), enterPhone(mobilePhones)));
        System.out.println("------User created successfully------");
    }

    public static void editUser(){
        if(users.size() == 0){
            System.out.println("There are no users. Create user");
            return;
        }
        System.out.println("Select user to change.");
        viewUsers();
        System.out.println("Print 0 to back");
        char selectUser = acceptAction();
        tempBoolean = false;
        while (!tempBoolean) {
            if (Character.getNumericValue(selectUser) < 0 || Character.getNumericValue(selectUser) > users.size()) {
                System.out.println("Wrong input try again");
                viewUsers();
                System.out.println("Print 0 to back");
                selectUser = acceptAction();
            } else {
                tempBoolean = true;
            }
        }
        if (selectUser == '0'){
            return;
        }
        showChanges();
        char changeCondition = acceptAction();
        User user = users.get(Character.getNumericValue(selectUser) - 1);
        while(changeCondition!= '7') {
            if (changeCondition == '1') {
                user.setName(enterName());
                System.out.println("Name was changed successfully");
            } else if (changeCondition== '2') {
                user.setSurname(enterSurname());
                System.out.println("Surname was changed successfully");
            } else if (changeCondition == '3'){
                user.setEmail(enterEmail());
                System.out.println("Email was changed successfully");
            } else if (changeCondition == '4'){
                showActionForRoles();
                selectUser = acceptAction();
                tempBoolean = false;
                while(!tempBoolean){
                    if(selectUser == '1'){
                        if (user.getRoles().size() < 4){
                            System.out.println("Print other role");
                            user.getRoles().add(in.next());
                        } else {
                            System.out.println("There are already three roles");
                        }
                        tempBoolean = true;
                    } else if (selectUser == '2'){
                        viewRoles(user);
                        System.out.println("Print 0 to back");
                        selectUser = acceptAction();
                        tempBoolean = false;
                        while (!tempBoolean) {
                            if (Character.getNumericValue(selectUser) < 0 || Character.getNumericValue(selectUser) > user.getRoles().size()) {
                                System.out.println("Wrong input try again");
                                viewRoles(user);
                                System.out.println("Print 0 to back");
                                selectUser = acceptAction();
                            } else {
                                tempBoolean = true;
                            }
                        }
                        if (selectUser == '0'){
                            return;
                        }
                        System.out.println("Print new role");
                        user.getRoles().remove(Character.getNumericValue(selectUser) - 1);
                        user.getRoles().add(Character.getNumericValue(selectUser) - 1, in.next());
                        System.out.println("Role was changed successfully");
                        tempBoolean = true;
                    } else {
                        System.out.println("Wrong input try again");
                    }
                }
            } else if (changeCondition == '5'){
                viewPhones(user);
                System.out.println("Print 0 to back");
                selectUser = acceptAction();
                in.nextLine();
                tempBoolean = false;
                while (!tempBoolean) {
                    if (Character.getNumericValue(selectUser) < 0 || Character.getNumericValue(selectUser) > user.getMobilePhones().size()) {
                        System.out.println("Wrong input try again");
                        viewPhones(user);
                        System.out.println("Print 0 to back");
                        selectUser = acceptAction();
                        in.nextLine();
                    } else {
                        tempBoolean = true;
                    }
                }
                if (selectUser == '0'){
                    return;
                }
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
            } else if (changeCondition == '6'){
                users.remove(user);
            } else {
                System.out.println("Invalid character. Please enter the character again from 1 to 6");
                changeCondition = acceptAction();
                continue;
            }
            showChanges();
            changeCondition = acceptAction();
        }
    }

    public static void viewUsers(){
        int count = 0;
        for (User user: users) {
            System.out.println((++count) + ". " + user.toString());
        }
    }

    private static void showChanges(){
        System.out.println("What do you want to change?");
        System.out.println("1. Name");
        System.out.println("2. Surname");
        System.out.println("3. Email");
        System.out.println("4. Roles");
        System.out.println("5. Phones");
        System.out.println("6. Delete user");
        System.out.println("7. Back to actions");
    }

    private static String enterName(){
        System.out.println("Enter username:");
        return in.next();
    }

    private static String enterSurname(){
        System.out.println("Enter surname:");
        return in.next();
    }

    private static String enterEmail(){
        System.out.println("Enter email:");
        do {
            tempString = in.next();
            tempBoolean = validator.isValidEmail(tempString);
            if (tempBoolean) {
                return tempString;
            } else {
                System.out.println("Wrong email. Try again with this template *******@*****.***");
            }

        } while (!tempBoolean);
        return null;
    }

    private static List<String> enterPhone(List<String> mobilePhones){
        System.out.println("Enter mobile phones:");
        do {
            while(mobilePhones.size() < 4) {
                tempString = in.nextLine();
                tempBoolean = validator.isValidMobile(tempString);
                if (tempBoolean) {
                    mobilePhones.add(tempString);
                    System.out.println("Mobile phone was added successfully");
                } else {
                    System.out.println("Wrong mobile. Try again with this template 375** *******");
                }

                if (mobilePhones.size() + 1 < 4 && tempBoolean) {
                    System.out.println("Do you want another phone? Yes/No (y/any)");
                    if (acceptAction() == 'y') {
                        System.out.println("Enter other phone:");
                        in.nextLine();
                        continue;
                    } else {
                        break;
                    }
                }
                else{
                    break;
                }
            }
        } while (!tempBoolean);

        return mobilePhones;
    }

    private static List<String> enterRole(List<String> roles){
        System.out.println("Enter roles:");
        while(roles.size() < 4) {
            roles.add(in.next());
            System.out.println("Role was added successfully");
            if (roles.size() + 1 < 4) {
                System.out.println("Do you want another role? Yes/No (y/any)");
                if (acceptAction() == 'y') {
                    System.out.println("Enter other role:");
                    continue;
                } else {
                    break;
                }
            }else{
                break;
            }
        }
        in.nextLine();
        return roles;
    }

    private static void viewRoles(User user){
        System.out.println("What role do you want to change");
        int count = 0;
        for (String role : user.getRoles()){
            System.out.println((++count) + ". " + role);
        }
    }

    private static void viewPhones(User user){
        System.out.println("What phone do you want to change");
        int count = 0;
        for (String phone : user.getMobilePhones()){
            System.out.println((++count) + ". " + phone);
        }
    }

    private static void showActionForRoles(){
        System.out.println("What do you want to do?");
        System.out.println("1. Add roles");
        System.out.println("2. Edit roles");
    }

    private static void selectUserToChange(){

    }
}
