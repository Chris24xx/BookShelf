package dev.project2.Entities;

import java.util.Objects;

public class ContactUs {
    private int contactId;
    private Boolean status;
    private String email;
    private String fullName;
    private String issueMessage;



    public ContactUs() {
    }

    public ContactUs(int contactId,  Boolean status, String email, String fullName, String issueMessage) {
        this.contactId = contactId;
        this.status = status;
        this.email = email;
        this.fullName = fullName;
        this.issueMessage = issueMessage;

    }


    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIssueMessage() {
        return issueMessage;
    }

    public void setIssueMessage(String issueMessage) {
        this.issueMessage = issueMessage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactUs contactUs = (ContactUs) o;
        return contactId == contactUs.contactId && Objects.equals(email, contactUs.email) && Objects.equals(fullName, contactUs.fullName) && Objects.equals(issueMessage, contactUs.issueMessage) && Objects.equals(status, contactUs.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, email, fullName, issueMessage, status);
    }

    @Override
    public String toString() {
        return "ContactUs{" +
                "contactId=" + contactId +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", issueMessage='" + issueMessage + '\'' +
                ", status=" + status +
                '}';
    }
}
