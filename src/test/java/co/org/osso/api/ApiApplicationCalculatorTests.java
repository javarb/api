package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ApiApplicationCalculatorTests {

    Calculator target = new Calculator();

    @Test
    public void checkCalculatorFibonacci(){
        List<Integer> expected = Arrays.asList(1,1,2,3,5);
        List<BigInteger> actual = target.getFibonacci(5);

        for (int i = 0 ; i < expected.size() ; i++) {
            Assert.assertEquals(BigInteger.valueOf(expected.get(i)), actual.get(i));
        }

        for (int i = 0 ; i < actual.size() ; i ++) {
            Assert.assertEquals(BigInteger.valueOf(expected.get(i)), actual.get(i));
        }
    }

    @Test
    public void checkCalculatorFactorial(){
        Assert.assertEquals(BigInteger.valueOf(3_628_800), target.getFactorial(10));
    }

    @Test
    public void checkCalculatorOperationsSum(){
        Assert.assertEquals((double)12.2, target.calculate("sum", 9.1, 3.1),.001);
    }

    @Test
    public void checkCalculatorOperationsSub(){
        Assert.assertEquals((double)6.0, target.calculate("sub", 9.1, 3.1),.001);
    }

    @Test
    public void checkCalculatorOperationsMul(){
        Assert.assertEquals((double)28.21, target.calculate("mul", 9.1, 3.1),.001);
    }

    @Test
    public void checkCalculatorOperationsDiv(){
        Assert.assertEquals((double)3, target.calculate("div", 9.1, 3.1),.1);
    }

    @Test
    public void checkCalculatorOperationsDivByZero(){
        try {
            target.calculate("div", 1, 0);
            Assert.fail();
        } catch (RuntimeException re){
            Assert.assertTrue(re.getMessage().contains("Error:"));
        }
    }
}