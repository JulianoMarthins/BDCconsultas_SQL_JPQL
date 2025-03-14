package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.entities.Lawyer;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {


    // Consulta ao banco de dados pelo SQL
    @Query(
            nativeQuery = true,
            value = "SELECT name, customers_number AS customersNumber " +
                    "FROM lawyers " +
                    "WHERE customers_number = (SELECT MAX(customers_number) FROM lawyers) " +
                    "UNION ALL " +
                    "SELECT name, customers_number " +
                    "FROM lawyers " +
                    "WHERE customers_number = (SELECT MIN(customers_number) FROM lawyers) " +
                    "UNION ALL " +
                    "SELECT 'Average' AS name, ROUND(AVG(customers_number), 0) " +
                    "FROM lawyers"
    )
    List<LawyerMinProjection> searchSQL();

    // Foi necessário adicionar o "apelido" a coluna customers_number para padronizar ao nome CustomersNumber da
    // interface do LawyerMinProjection, caso não seja feito, a consulta SQL retorna os valores como null

}
