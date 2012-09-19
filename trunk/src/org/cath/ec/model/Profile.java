package org.cath.ec.model;

// Generated Sep 19, 2012 12:31:23 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Profile generated by hbm2java
 */
public class Profile implements java.io.Serializable {

    private Integer id;
    private String uid;
    private String patronSaint;
    private String firstname;
    private String lastname;
    private String lowerCaseName;
    private String email;
    private Date dob;
    private String gender;
    private String address;
    private String picture;

    public Profile() {
    }

    public Profile(String uid, String patronSaint, String firstname, String lastname, String lowerCaseName,
            String email, Date dob, String gender, String address, String picture) {
        this.uid = uid;
        this.patronSaint = patronSaint;
        this.firstname = firstname;
        this.lastname = lastname;
        this.lowerCaseName = lowerCaseName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.picture = picture;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPatronSaint() {
        return this.patronSaint;
    }

    public void setPatronSaint(String patronSaint) {
        this.patronSaint = patronSaint;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLowerCaseName() {
        return this.lowerCaseName;
    }

    public void setLowerCaseName(String lowerCaseName) {
        this.lowerCaseName = lowerCaseName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}