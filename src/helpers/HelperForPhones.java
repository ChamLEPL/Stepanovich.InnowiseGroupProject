package helpers;

import entities.User;
import interfaces.View;

public class HelperForPhones implements View {
    private User user;

    public HelperForPhones(User user) {
        this.user = user;
    }

    @Override
    public void view() {
        System.out.println("What phone do you want to change");
        int count = 0;
        for (String phone : user.getMobilePhones()) {
            System.out.println((++count) + ". " + phone);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
