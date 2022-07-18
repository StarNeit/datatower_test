package com.dev.datatower.validation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DateFormateValidator implements ConstraintValidator<DateFormate, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if ( value == null ) {
      return true;
  }
    try {
        Integer year = LocalDate.now().getYear();
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(value);
        Calendar myCal = new GregorianCalendar();
        myCal.setTime(birthday);
        if(year - myCal.get(Calendar.YEAR) <= 18) {
          return false;
        }
        return true;
    } catch (Exception e) {     
        return false;
    }
  }
}
