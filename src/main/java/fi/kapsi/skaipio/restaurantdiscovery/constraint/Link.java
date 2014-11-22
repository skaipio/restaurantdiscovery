/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author skaipio
 */
@Documented
@Constraint(validatedBy = LinkValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Link {

    String message() default "{fi.kapsi.skaipio.restaurantdiscovery.constraint.Link}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
