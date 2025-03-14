package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {


    @Query(
            nativeQuery = true,
            value = "SELECT empregados.cpf, empregados.enome, departamentos.dnome " +
                    "FROM empregados " +
                    "INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero " +
                    "WHERE empregados.cpf NOT IN ( " +
                    "SELECT empregados.cpf " +
                    "FROM empregados " +
                    "INNER JOIN trabalha ON trabalha.cpf_emp = empregados.cpf " +
                    ")" +
                    "ORDER BY empregados.cpf"
    )
    List<EmpregadoDeptProjection> searchSQL();

}
