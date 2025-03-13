package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    // Pesquisa no banco de dados usando o SQL
    @Query(
            nativeQuery = true,
            value = "SELECT products.name " +
                    "FROM products " +
                    "INNER JOIN providers ON products.id_providers = providers.id " +
                    "WHERE products.amount BETWEEN :min AND :max " +
                    "AND providers.name LIKE CONCAT(:beginName, '%')"
    )
    List<ProductMinProjection> searchSQL(Integer min, Integer max, String beginName);


    // Pesquisa no banco de dados usando o JPQL
    @Query(
            value = "SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) " +
                    "FROM Product obj " +
                    "WHERE obj.amount BETWEEN :min AND :max " +
                    "AND obj.provider.name LIKE CONCAT(:beginName, '%')"
    )
    List<ProductMinDTO> searchJPQL(Integer min, Integer max, String beginName);

}
