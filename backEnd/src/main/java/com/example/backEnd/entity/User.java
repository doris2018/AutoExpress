package com.example.backEnd.entity;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 102L;

    @Id
    private String emailId;

    private String password;

    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Customer customer;

    private String getEmailId() { return emailId; }

    private void setEmailId(String emailId) { this.emailId = emailId; }

    private String getPassword() { return password; }

    private void setPassword(String password) { this.password = password; }

    private boolean isEnabled() { return enabled; }

    private void setEnabled(boolean enabled) { this.enabled = enabled; }

    private Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }
}
