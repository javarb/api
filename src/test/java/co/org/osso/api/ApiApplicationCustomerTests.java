package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationCustomerTests {

    private CustomerService CustomerServiceTarget = new CustomerService();

    @Autowired
    CustomerController CustomerControllerTarget;

    @Test
    public void checkCustomersServiceGetCustomers() {
        List<Customer> customers = CustomerServiceTarget.getCustomers();
        Assert.assertEquals("2222", customers.get(1).getCustomerID().toString());
    }

    @Test
    public void checkCustomerControllerGetBookEqualsTo(){
        List<Customer> customers = new ArrayList<>();
        customers = CustomerControllerTarget.getCustomers();
        Assert.assertEquals("1111", customers.get(0).getCustomerID().toString());
    }
}
