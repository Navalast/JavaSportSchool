package sample;

public class User {

    private String firstName;
    private String surName;
    private String userName;
    private String password;
    private String location;
    private String gender;

    public User(String firstName, String surName, String userName, String password, String location, String gender) {
        this.firstName = firstName;
        this.surName = surName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
