package com.example.demo.service;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.dto.MovieDto;

@Service
public class MovieService {


  public List<MovieDto> execute() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://playground.mockoon.com/movies";
    ResponseEntity<List<MovieDto>> res = restTemplate.exchange(url, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<MovieDto>>() {});
    return res.getBody();
  }

}
