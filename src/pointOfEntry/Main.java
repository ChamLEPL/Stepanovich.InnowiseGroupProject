package pointOfEntry;

import entities.User;
import helpers.HelperForUser;
import services.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static void main(String[] args){
        Create create = new Create();
        Edit edit = new Edit();
        Service service = new Service();
        ConsoleView.showActions();
        char exitCondition = service.acceptAction();
        while(exitCondition != '4') {
            if (exitCondition == '1') {
                create.createUser();
            } else if (exitCondition == '2') {
                edit.editUser();
            } else if (exitCondition == '3'){
                new HelperForUser().view();
            } else {
                System.out.println("Invalid character. Please enter the character again from 1 to 4");
                exitCondition = service.acceptAction();
                continue;
            }

            ConsoleView.showActions();
            exitCondition = service.acceptAction();
        }
    }
}
