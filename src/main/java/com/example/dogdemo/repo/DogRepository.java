package com.example.dogdemo.repo;

import com.example.dogdemo.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    Dog getDogById(Long id);

    @Override
    List<Dog> findAll();

    @Override
    void deleteById(Long id);
}
