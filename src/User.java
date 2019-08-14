import java.util.List;

public class User {
    private String name;
    private String surname;
    private String email;
    private List<String> roles;
    private List<String> mobilePhones;
    private Validator validator = new Validator();


    public User(String name, String surname, String email, List<String> roles, List<String> mobilePhones) {
        this.name = name;
        this.surname = surname;
        this.roles = roles;
        setEmail(email);
        setMobilePhones(mobilePhones);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(validator.isValidEmail(email)){
            this.email = email;
        }
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getMobilePhones() {
        return mobilePhones;
    }

    private void setMobilePhones(List<String> mobilePhones) {
        this.mobilePhones = validator.generateValidList(mobilePhones);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Surname: %s, Email: %s, Roles: %s, Mobile Telephones %s",
                name, surname, email, roles, mobilePhones);
    }
}
