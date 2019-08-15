import entities.User;

import java.util.ArrayList;
import java.util.List;

public class Create {
    private Enter enter;

    public Create(){
        this.enter = new Enter();
    }

    public void createUser(){
        List<String> roles = new ArrayList<>();
        List<String> mobilePhones = new ArrayList<>();
        System.out.println("------Start user creation------");
        Main.users.add(new User(enter.enterName(), enter.enterSurname(), enter.enterEmail(), enter.enterRole(roles), enter.enterPhone(mobilePhones)));
        System.out.println("------User created successfully------");
    }
}
