package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	@Autowired
	private BookController controller_target;

	@Autowired
	private CustomerService service_target;

	@Test
	public void checkBookServiceGetCustomers(){
		List<Customer> customers = service_target.getCustomers();
        Assert.assertEquals("1111", customers.get(0).getCustomerID().toString());
	}

	@Test
	public void checkBookControllerNotNull() {
        List<Customer> customers = controller_target.getCustomers();
        Assert.assertNotNull(customers);
	}

    @Test
    public void checkBookControllerGetCustomers() {
        List<Customer> customers = controller_target.getCustomers();
        Assert.assertEquals("2222", customers.get(1).getCustomerID().toString());;
	}

}
