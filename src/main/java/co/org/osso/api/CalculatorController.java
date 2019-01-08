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

    private static final String FIBONACCI_URL = "/fibonacci/";
    private static final String FACTORIAL_URL = "/factorial/";
    private final Calculator calculator;
    private Logger logger;

    public CalculatorController(Calculator calculator, Logger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    @GetMapping(FIBONACCI_URL + "{number}")
    public List<BigInteger> getFibonacci(@PathVariable("number") Integer number){
        logger.log(FIBONACCI_URL + number);
        return calculator.getFibonacci(number);
    }

    @GetMapping(FACTORIAL_URL + "{number}")
    public BigInteger getFactorial(@PathVariable("number") int number){
        logger.log(FACTORIAL_URL + number);
        return calculator.getFactorial(number);
    }

    @GetMapping("/arithmetic")
    public double getOperationResult(@RequestParam String operation, @RequestParam double n1, @RequestParam double n2 ){
        return calculator.calculate(operation, n1, n2);
    }

}

