package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.enity.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
