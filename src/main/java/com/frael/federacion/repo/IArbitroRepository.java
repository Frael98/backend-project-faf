package com.frael.federacion.repo;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frael.federacion.model.Arbitro;

public interface IArbitroRepository extends JpaRepository<Arbitro, Integer>{
    
    public Optional<Arbitro> findByUsuario(String usuario);

    @Query( value = "SELECT * FROM ARBITRO A WHERE A.ESTADO <> 'E'", nativeQuery = true)
    public List<Arbitro> findOnlyActive();

  /*   @Query( " exec test;")
    public List<Arbitro> findByEstado(@Param) */
}
