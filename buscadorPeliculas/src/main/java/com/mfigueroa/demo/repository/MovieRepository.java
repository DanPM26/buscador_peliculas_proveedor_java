package com.mfigueroa.demo.repository;

import com.mfigueroa.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    //List<Movie> findByProveedor(String nombreProveedor);

    //List<Movie> findByProveedorIgnoreCase(String nombreProveedor);
    @Query("SELECT m FROM Movie m WHERE UPPER(m.proveedor) LIKE UPPER(CONCAT('%', :proveedor, '%'))")
    List<Movie> findByProveedor(String proveedor);
}

