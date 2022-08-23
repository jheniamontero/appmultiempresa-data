package com.appmultiempresa.appempresa.service;

import com.appmultiempresa.appempresa.entity.ProductoEmp;
import com.appmultiempresa.appempresa.repository.ProductoEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoEmpService {

    @Autowired
    ProductoEmpRepository productoEmpRepository;

    public List<ProductoEmp> list(){
        return productoEmpRepository.findAll();
    }
    public Optional<ProductoEmp> getOne(int id){
        return productoEmpRepository.findById(id);
    }
    public Optional<ProductoEmp> getByNombre(String nombre){
        return productoEmpRepository.findByNombre(nombre);
    }
    public void save(ProductoEmp productoEmp){
        productoEmpRepository.save(productoEmp); //guardar
    }
    public void delete(int id){
        productoEmpRepository.deleteById(id);
    }
    //en caso que creen nombres iguales
    public boolean existsById(int id){
        return productoEmpRepository.existsById(id);
    }
    public boolean exisByNombre(String nombre){
        return productoEmpRepository.existsByNombre(nombre);
    }
}
