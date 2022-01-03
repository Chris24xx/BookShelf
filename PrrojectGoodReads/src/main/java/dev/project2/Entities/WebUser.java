package dev.project2.Entities;

import java.util.Objects;

public class WebUser {
    private int userId;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String password;
    private Boolean moderator;

    public WebUser(){}

    public WebUser(int userId, String firstName, String lastName, String userEmail, String password, Boolean moderator) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.password = password;
        this.moderator = moderator;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isModerator() {
        return moderator;
    }

    public void setModerator(Boolean moderator) {
        this.moderator = moderator;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", moderator=" + moderator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebUser user = (WebUser) o;
        return userId == user.userId && moderator == user.moderator && firstName.equals(user.firstName) && lastName.equals(user.lastName) && userEmail.equals(user.userEmail) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, userEmail, password, moderator);
    }
}
