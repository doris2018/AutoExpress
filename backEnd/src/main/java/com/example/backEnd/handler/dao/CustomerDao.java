package com.example.backEnd.handler.dao;
import com.example.backEnd.entity.Authorities;
import com.example.backEnd.entity.Customer;
import com.example.backEnd.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Respository
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public int addCustomer(RegisterRequestBody request) { 
        User user = new User(); // build a user from request
        user.setEnabled(true);
        user.setEmailId(request.getEmail());
        user.setPassword(request.getPassword());

        Customer customer = new Customer(); // build a customer from request
        customer.setBillingAddress(request.getBillingAddress());
        customer.setShippingAddress(request.getShippingAddress());
        customer.setFirstName(request.getFristName());
        customer.setLastName(request.getLastName());
        customer.setUser(user);

        Authorities authorities = new Authorities(); // build authorities from request
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(request.getEmail());
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return -1; 
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return 0; 
    }

    public Customer getCurrentCustomer() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String emailId = loggedInUser.getName();

        User user = null;
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            user = (User) criteria.add(Restrictions.eq("emailId", emailId)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
            return user.getCustomer();
        }
        return null;
    }
}
