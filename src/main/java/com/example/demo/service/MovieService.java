package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.dto.MovieDto;
import com.example.demo.enity.Movie;
import com.example.demo.respository.MovieRepository;
import jakarta.transaction.Transactional;

@Service
public class MovieService {

  private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Transactional
  public List<MovieDto> execute() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://playground.mockoon.com/movies";
    ResponseEntity<List<MovieDto>> res = restTemplate.exchange(url, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<MovieDto>>() {});

    List<Movie> result = movieRepository.findAll();

    // clear db
    if (res.getBody() != null && !result.isEmpty()) {
      movieRepository.deleteAll();
    }

    List<Movie> et = new ArrayList<>();

    for (MovieDto dto : res.getBody()) {
      Movie mv = new Movie();
      BeanUtils.copyProperties(dto, mv);
      if (dto.isPopular()) {
        mv.setIsPopular(true);
      } else {
        mv.setIsPopular(false);
      }
      et.add(mv);
    }
    movieRepository.saveAll(et);

    LOG.info("Response for Movie : {}", res.getBody().toString());

    return res.getBody();
  }

}
