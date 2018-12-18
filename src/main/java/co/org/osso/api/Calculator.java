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
            return fibonacci.subList(0,number);
        } else {
            if (fibonacci.size() == 0) {
                fibonacci.add(BigInteger.ONE);
                fibonacci.add(BigInteger.ONE);

                for (int i = 2; i < number; i++) {
                    fibonacci.add(i, fibonacci.get(i - 1).add(fibonacci.get(i - 2)));
                }

            }

            for (int i = fibonacci.size(); i < number; i++) {
                fibonacci.add(i, fibonacci.get(i - 1).add(fibonacci.get(i - 2)));
            }

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

        CalculatorCommands command = CalculatorCommands.valueOf(operation.toUpperCase());

        switch (command) {
            case SUM:
                return n1 + n2;
            case SUB:
                return n1 - n2;
            case MUL:
                return n1 * n2;
            case DIV:
                if (n2 == 0) {
                    throw new RuntimeException("Error: Division by 0");
                } else {
                    return n1 / n2;
                }
            default:
                throw new RuntimeException("Error: valid operations are SUM, SUB, MUL and DIV");

        }
    }

}
