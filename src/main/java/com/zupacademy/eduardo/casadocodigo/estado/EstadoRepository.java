package com.zupacademy.eduardo.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    public Boolean existsByPaisId(Long paisId);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Estado c WHERE c.id = :id and c.pais.id=:paisId")
    public Boolean existsByIdAndPaisId(Long id, Long paisId);
}
