package com.appmultiempresa.appempresa.controller;

import com.appmultiempresa.appempresa.dto.Mensaje;
import com.appmultiempresa.appempresa.dto.ProductoEmpDto;
import com.appmultiempresa.appempresa.entity.ProductoEmp;
import com.appmultiempresa.appempresa.service.ProductoEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductosEmpresaController
{
    @Autowired
    ProductoEmpService productoEmpService;

    @GetMapping("/lista")
    public ResponseEntity<List<ProductoEmp>> list(){
        List<ProductoEmp> list = productoEmpService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<ProductoEmp> getById(@PathVariable("id")int id){
        if(!productoEmpService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ProductoEmp productoEmp = productoEmpService.getOne(id).get();
        return new ResponseEntity(productoEmp, HttpStatus.OK);
    }
    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<ProductoEmp> getByNombre(@PathVariable("nombre")String nombre){
        if(!productoEmpService.exisByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ProductoEmp productoEmp = productoEmpService.getByNombre(nombre).get();
        return new ResponseEntity(productoEmp, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoEmpDto productoEmpDto){
        if(productoEmpDto.getNombre().equals(""))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoEmpDto.getDetalles().equals("") || productoEmpDto.getServicio().equals(""))
            return new ResponseEntity(new Mensaje("los datos se deben incluir"), HttpStatus.BAD_REQUEST);
        if(productoEmpService.exisByNombre(productoEmpDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        ProductoEmp productoEmp = new ProductoEmp(productoEmpDto.getNombre(), productoEmpDto.getDetalles(),productoEmpDto.getServicio());
        productoEmpService.save(productoEmp);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProductoEmpDto productoEmpDto){
        if(!productoEmpService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(productoEmpService.exisByNombre(productoEmpDto.getNombre()) && productoEmpService.getByNombre(productoEmpDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(productoEmpDto.getNombre().equals(""))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productoEmpDto.getDetalles().equals("") || productoEmpDto.getServicio().equals(""))
            return new ResponseEntity(new Mensaje("los campos son obligatorios"), HttpStatus.BAD_REQUEST);

        ProductoEmp productoEmp = productoEmpService.getOne(id).get();
        productoEmp.setNombre(productoEmpDto.getNombre());
        productoEmp.setDetalles(productoEmpDto.getDetalles());
        productoEmp.setServicio(productoEmp.getServicio());
        productoEmpService.save(productoEmp);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!productoEmpService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoEmpService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

}
