package com.mfigueroa.demo.services;

import com.mfigueroa.demo.model.Movie;
import com.mfigueroa.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie>obtenerPeliculasPorProveedor(String nombreProveedor) {
        return movieRepository.findByProveedor(nombreProveedor);
    }
}
