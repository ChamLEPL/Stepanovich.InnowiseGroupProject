package services;

public class ConsoleView {
    public static void showActions(){
        System.out.println("Select an action.");
        System.out.println("1. Сreate user.");
        System.out.println("2. Edit user.");
        System.out.println("3. View users.");
        System.out.println("4. Exit.");
    }

    public static void showChanges(){
        System.out.println("What do you want to change?");
        System.out.println("1. Name");
        System.out.println("2. Surname");
        System.out.println("3. Email");
        System.out.println("4. Roles");
        System.out.println("5. Phones");
        System.out.println("6. Delete user");
        System.out.println("7. Back to actions");
    }

    public static void showActionForRoles(){
        System.out.println("What do you want to do?");
        System.out.println("1. Add role");
        System.out.println("2. Edit role");
    }

    public static void showActionForPhones(){
        System.out.println("What do you want to do?");
        System.out.println("1. Add phone");
        System.out.println("2. Edit phone");
    }
}
