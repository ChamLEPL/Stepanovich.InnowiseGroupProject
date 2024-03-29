package helpers;

import entities.User;
import interfaces.View;

public class HelperForRoles implements View {
    private User user;

    public HelperForRoles(User user) {
        this.user = user;
    }

    @Override
    public void view() {
        System.out.println("What role do you want to change");
        int count = 0;
        for (String role : user.getRoles()) {
            System.out.println((++count) + ". " + role);
        }
    }
}
