package org.libraryproject;

public class Member {
    private String name;
    private int id;
    private String contactInfo;

    public Member(String name, int id, String contactInfo) {
        this.name = name;
        this.id = id;
        this.contactInfo = contactInfo;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
