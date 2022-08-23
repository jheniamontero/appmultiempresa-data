package com.appmultiempresa.appempresa.security.repository;

import com.appmultiempresa.appempresa.security.entity.Rol;
import com.appmultiempresa.appempresa.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
