package br.com.zupacademy.vinicius.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistingIdValidator implements ConstraintValidator<ExistingID, Object> {

	private String domainAttribute;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void initialize(ExistingID params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = em.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE "
				+ domainAttribute + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		return !list.isEmpty();
	}

}
