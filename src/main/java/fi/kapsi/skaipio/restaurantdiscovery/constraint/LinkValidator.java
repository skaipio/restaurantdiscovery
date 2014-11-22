/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class LinkValidator implements ConstraintValidator<Link, String> {
    private final String regex = "http://(www.)?(([a-z0-9\\-_$+!*'\\(\\)])+.)+(com|fi|org|au|co.uk|us)";
    
    @Override
    public void initialize(Link constraintAnnotation) {
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(regex);
    }
}
