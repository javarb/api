package co.org.osso.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public List<Customer> getCustomers() {
        List<Customer> customersList = new ArrayList<>();
        customersList.add(createCustomer(1111, "Test user 1", "test1@mail.com", "01-01-1901"));
        customersList.add(createCustomer(2222, "Test user 2", "test2@mail.com", "02-02-1902"));
        customersList.add(createCustomer(3333, "Test user 3", "test3@mail.com", "03-03-1903"));
        return customersList;
    }


    public Customer createCustomer(Integer ID, String name, String email, String dob){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerID(ID);
        customer.setEmailAddress(email);
        customer.setDateOfBirth(dob);
        return customer;
    }

}

class Customer {
    private String name;
    private Integer customerID;
    private String emailAddress;
    private String dateOfBirth;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCustomerID(Integer customerID){
        this.customerID = customerID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }
}
