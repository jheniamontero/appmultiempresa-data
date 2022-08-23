package com.appmultiempresa.appempresa.repository;

import com.appmultiempresa.appempresa.entity.ProductoEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoEmpRepository extends JpaRepository<ProductoEmp, Integer> {
    Optional<ProductoEmp> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
