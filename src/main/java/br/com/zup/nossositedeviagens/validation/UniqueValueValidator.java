package br.com.zup.nossositedeviagens.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

	private Class<?> domainClass;
	private String attribute;

	@Override
	public void initialize(UniqueValue constraintAnnotation) {

		this.domainClass = constraintAnnotation.domaiClass();
		this.attribute = constraintAnnotation.attribute();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return false;
	}

}
