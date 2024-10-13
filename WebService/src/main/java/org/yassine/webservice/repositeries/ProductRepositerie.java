package org.yassine.webservice.repositeries;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.yassine.webservice.entities.Product;

import java.util.Optional;

@Repository
public interface ProductRepositerie extends JpaRepository<Product, Integer> {

    Optional<Product> findByCode(Integer code);

    @Transactional
    @Modifying
    void deleteByCode(Integer code);
}
