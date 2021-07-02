package com.zupacademy.eduardo.casadocodigo.cliente;

import com.zupacademy.eduardo.casadocodigo.estado.EstadoRepository;
import com.zupacademy.eduardo.casadocodigo.pais.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Objects;

@Component
public class EstadoPertencePaisValidator implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) return;

        NovoClienteRequest request = (NovoClienteRequest) o;

        Boolean paisTemEstados = estadoRepository.existsByPaisId(request.getPaisId());

        if(!paisTemEstados) return;

        if(paisTemEstados && Objects.isNull(request.getEstadoId()))
            errors.rejectValue("estadoId",null, "É necessário informar um estado");

        if(!estadoRepository.existsByIdAndPaisId(request.getEstadoId(), request.getPaisId()))
            errors.rejectValue("estadoId", null, "Estado não pertence ao País");
    }
}
