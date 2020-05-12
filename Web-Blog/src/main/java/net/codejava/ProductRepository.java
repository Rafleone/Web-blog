package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product e where e.title like %:keyword% or e.anons like %:keyword% or e.madein like %:keyword%", nativeQuery = true)
    List<Product> findbyKeyword(@Param("keyword") String keyword);
}
