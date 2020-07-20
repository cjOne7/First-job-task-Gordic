package com.work.management.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private Date dateOfBirth;
    private String sex;
    private String education;
    private String about;

    public Person() {
    }

    public Person(String name, String email, Date dateOfBirth, String sex, String education, String about) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.education = education;
        this.about = about;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAboutFieldEmpty() {
        if (about == null) {
            return true;
        }
        return about.trim().isEmpty();
    }
}
