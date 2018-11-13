package co.org.osso.api;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static co.org.osso.api.CalculatorCommands.SUM;
import static java.lang.Enum.valueOf;

@Service
public class Calculator {

    List<BigInteger> fibonacci = new ArrayList<>();

    public List<BigInteger> getFibonacci(Integer number) {

        if (fibonacci.size() >= number){
            System.out.println("CACHE number = " + number);
            return fibonacci.subList(0,number-1);
        }

        if (fibonacci.size() == 0) {
            fibonacci.add(BigInteger.ONE);
            fibonacci.add(BigInteger.ONE);
        }

        for (int i = 2; i < number; i++) {
           fibonacci.add(i, fibonacci.get(i - 1).add(fibonacci.get(i - 2)));
        }

        return fibonacci;

    }

    public BigInteger getFactorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));

        return factorial;

    }


    public double calculate(String operation, double n1, double n2) {

        switch (operation) {
//            case CalculatorCommands.SUM.toString():
            case "sum":
                return n1 + n2;
            case "sub":
                return n1 - n2;
            case "mul":
                return n1 * n2;
            case "div":
                if (n2 == 0) {
                    throw new RuntimeException("Error: Division by 0");
                } else {
                    return n1 / n2;
                }
            default:
                throw new RuntimeException("Error: valid operations are sum, sub, mil and div");

        }
    }

}
