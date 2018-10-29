package co.org.osso.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/fibonacci/{number}")
    public List getFibonacci(@PathVariable("number") Integer number){
        return calculatorService.getFibonacci(number);
    }

    @GetMapping("/factorial/{number}")
    public int getFactorial(@PathVariable("number") int number){
        return calculatorService.getFactorial(number);
    }

    /* http://localhost:8080/api/arithmetic?operation=div&n1=2&n2=0 */
    @GetMapping("/arithmetic")
    public double getOperationResult(@RequestParam String operation, @RequestParam double n1, @RequestParam double n2 ){
        return calculatorService.getOperationResult(operation, n1, n2);
    }

    /*@GetMapping("/sum")
    public int getSum(@RequestParam int n1, @RequestParam int n2){
        return calculatorService.getSum(n1, n2);
    }
    @GetMapping("/sub")
    public int getSub(@RequestParam int n1, @RequestParam int n2){
        return calculatorService.getSub(n1, n2);
    }*/

}

