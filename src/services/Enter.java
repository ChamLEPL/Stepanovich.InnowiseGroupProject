package services;

import java.util.List;
import java.util.Scanner;

public class Enter {
    private Scanner in;
    private String tempString;
    private boolean tempBoolean;
    private Validator validator;
    private Service service;

    public Enter(){
        this.in = new Scanner(System.in);
        this.tempString = "";
        this.tempBoolean = false;
        this.validator = new Validator();
        this.service = new Service();
    }

    public String enterName(){
        System.out.println("Enter username:");
        return in.next();
    }

    public String enterSurname(){
        System.out.println("Enter surname:");
        return in.next();
    }

    public String enterEmail(){
        System.out.println("Enter email:");
        do {
            tempString = in.next();
            tempBoolean = validator.isValidEmail(tempString);
            if (tempBoolean) {
                break;
            } else {
                System.out.println("Wrong email. Try again with this template *******@*****.***");
            }

        } while (!tempBoolean);

        return tempString;
    }

    public List<String> enterPhone(List<String> mobilePhones){
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
                    if (service.acceptAction() == 'y') {
                        System.out.println("Enter other phone:");
                        in.nextLine();
                        continue;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        } while (!tempBoolean);

        return mobilePhones;
    }

    public List<String> enterRole(List<String> roles){
        System.out.println("Enter roles:");
        while(roles.size() < 4) {
            roles.add(in.next());
            System.out.println("Role was added successfully");
            if (roles.size() + 1 < 4) {
                System.out.println("Do you want another role? Yes/No (y/any)");
                if (service.acceptAction() == 'y') {
                    System.out.println("Enter other role:");
                    continue;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        in.nextLine();
        return roles;
    }
}
