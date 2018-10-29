package co.org.osso.api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {


    public List getFibonacci(Integer number) {

        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(1);

        for ( int i = 2; i < number; i++ ){
            fibonacci.add(i, fibonacci.get(i-1) + fibonacci.get(i-2));
        }

        return fibonacci;

    }

    public int getFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++)
            factorial = factorial * i;

        return factorial;
    }


    public double getOperationResult(String operation, double n1, double n2) {

        double result=0;

        switch (operation) {
            case "sum": result = n1 + n2;
                        break;
            case "sub": result = n1 - n2;
                        break;
            case "mul": result = n1 * n2;
                        break;
            case "div": result = n1 / n2;
                        break;
        }

        return result;
    }

    /*
    public int getSum(int n1, int n2) {
        return n1 + n2;
    }
    public int getSub(int n1, int n2) {
        return  n1 - n2;
    }*/
}
