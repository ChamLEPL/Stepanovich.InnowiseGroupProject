package pointOfEntry;

import entities.User;
import helpers.HelperForUser;
import services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static void main(String[] args) {
        Create create = new Create();
        Edit edit = new Edit();
        Service service = new Service();
        ConsoleView.showActions();
        char exitCondition = service.acceptAction();
        while (exitCondition != '7') {
            if (exitCondition == '1') {
                create.createUser();
            } else if (exitCondition == '2') {
                edit.editUser();
            } else if (exitCondition == '3') {
                new HelperForUser().view();
            } else if (exitCondition == '4') {
               service.saveAndRewriteFile();
            } else if (exitCondition == '5') {
                service.reloadFile();
            } else if (exitCondition == '6') {
                service.clearFile();
            } else {
                System.out.println("Invalid character. Please enter the character again from 1 to 7");
                exitCondition = service.acceptAction();
                continue;
            }

            ConsoleView.showActions();
            exitCondition = service.acceptAction();
        }

        if (exitCondition == '7') {
            service.saveAndRewriteFile();
        }
    }
}
