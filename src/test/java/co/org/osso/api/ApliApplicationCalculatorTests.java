package co.org.osso.api;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ApliApplicationCalculatorTests {

    CalculatorService CalculatorServiceTarget = new CalculatorService();

    @Test
    public void checkCalculatorServiceFibonacci(){
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        fib.add(2);
        fib.add(3);
        fib.add(5);
        Assert.assertEquals(fib, CalculatorServiceTarget.getFibonacci(5));
    }

    @Test
    public void checkCalculatorServiceFactorial(){
        Assert.assertEquals(3628800, CalculatorServiceTarget.getFactorial(10));
    }

    @Test
    public void checkCalculatorServiceOperationsSum(){
        Assert.assertEquals((double)12.2,CalculatorServiceTarget.getOperationResult("sum", 9.1, 3.1),.0);
    }

    @Test
    public void checkCalculatorServiceOperationsSub(){
        Assert.assertEquals((double)6.0,CalculatorServiceTarget.getOperationResult("sub", 9.1, 3.1),.0);
    }

    @Test
    public void checkCalculatorServiceOperationsMul(){
        Assert.assertEquals((double)28.21,CalculatorServiceTarget.getOperationResult("mul", 9.1, 3.1),.0);
    }

    @Test
    public void checkCalculatorServiceOperationsDiv(){
        Assert.assertEquals((double)3,CalculatorServiceTarget.getOperationResult("div", 9.1, 3.1),.1);
        // is possible to test infinity or is a nonsense
//        Assert.assertEquals((double)3,CalculatorServiceTarget.getOperationResult("div", 9.1, 0),.1);
    }


    /*@Test
    public void checkCalculatorServiceSum(){
        Assert.assertEquals(2, CalculatorServiceTarget.getSum(1,1));
    }
    @Test
    public void checkCalculatorServiceSub(){
        Assert.assertEquals(-1,CalculatorServiceTarget.getSub(1,2));
    }*/
}
