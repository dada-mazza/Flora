package ua.itea.entity;

/**
 * Created by dada.mazza on 30.06.2017.
 */
public class User {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private String region;
    private Gender gender;
    private boolean subscription;

    public User() {
    }

    public User(String email, String password, String firstName, String secondName, String region, String comment, Gender gender, boolean subscription) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.region = region;
        this.gender = gender;
        this.subscription = subscription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", region='" + region + '\'' +
                ", gender=" + gender +
                ", subscription=" + subscription +
                '}';
    }
}
