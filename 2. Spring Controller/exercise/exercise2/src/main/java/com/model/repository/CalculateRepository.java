package com.model.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculateRepository implements ICalculateRepository{
    @Override
    public String calculate(double numberFirst, double numberSecond, String operator) {
        double result = 0;
        String print = "";
        if (operator.equals("+")) {
            result = numberFirst+numberSecond;
        }else if (operator.equals("-")) {
            result = numberFirst-numberSecond;
        }else if (operator.equals("*")) {
            result = numberFirst*numberSecond;
        }else {
            if (numberSecond==0) {
                print="khong the chia hêt cho 0";
                return print;
            }else {
                result = numberFirst/numberSecond;
            }
        }
        return print.valueOf(result);
    }
}
