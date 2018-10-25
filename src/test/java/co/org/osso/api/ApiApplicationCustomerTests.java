package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ApiApplicationCustomerTests {

    private CustomerService CustomerServiceTarget = new CustomerService();

    @Test
    public void checkCustomersServiceGetCustomers() {
        List<Customer> customers = CustomerServiceTarget.getCustomers();
        Assert.assertEquals("2222", customers.get(1).getCustomerID().toString());
    }
}
