package com.example.backEnd.entity;


import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

    private static final long serialVersionUID = 101L;

    @Id
    private String emailId;

    private String authorities;

    public String getEmailId() { return emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getAuthorities() { return authorities; };

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
