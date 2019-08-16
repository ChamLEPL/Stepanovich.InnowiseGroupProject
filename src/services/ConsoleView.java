package services;

public class ConsoleView {
    public static void showActions(){
        System.out.println("Select an action.");
        System.out.println("1. Сreate user.");
        System.out.println("2. Edit user.");
        System.out.println("3. View users.");
        System.out.println("4. Save users.");
        System.out.println("5. Load users.");
        System.out.println("6. Clear file for users.");
        System.out.println("7. Exit.");
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

    public static void showSaveFileActions(){
        System.out.println("Do you want to save users to a file?");
        printYesOrNo();
    }

    public static void showRewriteFileActions(){
        System.out.println("Do you want rewrite a file?");
        System.out.println("If Yes, the users in the file will be deleted and only your users will be added");
        System.out.println("If No, your users will be added to users in the file");
        printYesOrNo();
    }

    public static void showReloadUsersActions(){
        System.out.println("Do you want to add users from the file to your users?");
        printYesOrNo();
    }

    private static void printYesOrNo(){
        System.out.println("1. Yes");
        System.out.println("2. No");
    }
}
