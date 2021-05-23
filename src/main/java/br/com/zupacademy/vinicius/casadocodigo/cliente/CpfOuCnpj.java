package br.com.zupacademy.vinicius.casadocodigo.cliente;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

//GIST DE RAFA PONTE
@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR) // especifica OR como operador booleano ao invés de AND
@ReportAsSingleViolation // O relatório de erro individual de cada constraint é ignorado.
@Constraint(validatedBy = { }) // Nós não precisamos de um validador :-)
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOuCnpj {
	
	String message() default "it's not a valid CPF or CNPJ";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
