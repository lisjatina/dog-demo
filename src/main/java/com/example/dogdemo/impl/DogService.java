package com.example.dogdemo.impl;

import com.example.dogdemo.model.Dog;
import com.example.dogdemo.repo.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public Dog saveDog(Dog dog){
        dog.setId(dog.getId());
        return dogRepository.save(dog);
    }

    public void deleteDogById(Long dogId) {
        Dog dog = dogRepository.getDogById(dogId);
        if (dog != null) {
            dogRepository.delete(dog);
        }
    }

    public Dog findDogById(Long id){
        return dogRepository.getDogById(id);
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }
}
