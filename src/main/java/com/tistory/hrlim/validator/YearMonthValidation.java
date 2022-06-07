package com.tistory.hrlim.validator;

import com.tistory.hrlim.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidation implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth yearMonth) {
        this.pattern = yearMonth.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try{
            LocalDate localDate = LocalDate.parse(value + "01", DateTimeFormatter.ofPattern(this.pattern));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
