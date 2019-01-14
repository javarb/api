package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CalculatorControllerTests {

    TestLogger logger = new TestLogger();
    CalculatorController target = new CalculatorController(new Calculator(logger), logger);

    @Test
    public void logFibonacciNumber(){
        target.getFibonacci(10);
        Assert.assertEquals(1, logger.logs.size());
        Assert.assertEquals("/fibonacci/10", logger.logs.get(0));
    }

    @Test
    public void logFactorialNumber(){
        target.getFactorial(4);
        Assert.assertEquals(1, logger.logs.size());
        Assert.assertEquals("/factorial/4", logger.logs.get(0));
    }
}
class TestLogger implements Logger {

    List<String> logs = new ArrayList<>();

    @Override
    public void log(String message) {
        logs.add(message);
    }
}