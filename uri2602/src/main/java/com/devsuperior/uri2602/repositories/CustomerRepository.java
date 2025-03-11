package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerNameDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    // Consulta usando o SQL
    @Query(
            nativeQuery = true,
            value = "SELECT name, city " +
                    "FROM customers " +
                    "WHERE UPPER(state) = UPPER(:state)"
    )
    List<CustomerNameProjection> searchByNameSQL(String state);


    // Consulta usando o JPQL
    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerNameDTO(obj.name) " +
            "FROM Customer obj " +
            "WHERE UPPER(obj.state) = UPPER(:state)"
    )
    List<CustomerNameDTO> searchByNameJPQL(String state);

}
