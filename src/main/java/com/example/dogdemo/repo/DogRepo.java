package com.example.dogdemo.repo;

import com.example.dogdemo.model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends CrudRepository <Dog, Long> {

    Dog getDogById (Long id);

    Iterable <Dog> findAll ();

    Dog saveDog (Dog dog);

    void deleteById (Long id);
}
