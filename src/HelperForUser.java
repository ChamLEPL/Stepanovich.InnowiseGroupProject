import entities.User;
import interfaces.View;

public class HelperForUser implements View {
    @Override
    public void view() {
        int count = 0;
        for (User user: Main.users) {
            System.out.println((++count) + ". " + user.toString());
        }
    }
}
