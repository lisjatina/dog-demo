package com.example.dogdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
    Dog getDogById(Long id);

    @Override
    Iterable<Dog> findAll();

    @Override
    void deleteById(Long id);
}
