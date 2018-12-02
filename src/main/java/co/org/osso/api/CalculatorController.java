package co.org.osso.api;

import com.bugsnag.Bugsnag;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final Calculator calculator;
    private final Bugsnag bugsnag;

    public CalculatorController(Calculator calculator, Bugsnag bugsnag) {
        this.calculator = calculator;
        this.bugsnag = bugsnag;
    }

    @GetMapping("/fibonacci/{number}")
    public List<BigInteger> getFibonacci(@PathVariable("number") Integer number){
        bugsnag.notify(new RuntimeException("Test error"));
        return calculator.getFibonacci(number);
    }

    @GetMapping("/factorial/{number}")
    public BigInteger getFactorial(@PathVariable("number") int number){
        return calculator.getFactorial(number);
    }

    @GetMapping("/arithmetic")
    public double getOperationResult(@RequestParam String operation, @RequestParam double n1, @RequestParam double n2 ){
        return calculator.calculate(operation, n1, n2);
    }

}

