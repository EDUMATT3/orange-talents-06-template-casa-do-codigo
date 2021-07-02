package com.zupacademy.eduardo.casadocodigo.estado;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Objects;

@Component
public class EstadoUnicoPaisValidator implements Validator {

    @PersistenceContext
    EntityManager entityManager;

    public boolean supports(Class clazz) {
        return NovoEstadoRequest.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors e) {
        if(e.hasErrors()){
            return;
        }

        NovoEstadoRequest request = (NovoEstadoRequest) obj;

        Query query = entityManager.createQuery("select 1 from Estado e where e.nome=?1 and e.pais.id=?2");
        query.setParameter(1, request.getNome());
        query.setParameter(2, request.getPaisId());

        if(query.getFirstResult() == 1)
            e.rejectValue("nome", null, "Já existe um estado com esse nome pertencente a este País");
    }
}
