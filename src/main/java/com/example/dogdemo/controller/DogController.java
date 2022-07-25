package com.example.dogdemo.controller;

import com.example.dogdemo.impl.DogService;
import com.example.dogdemo.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("")
    public ResponseEntity<?> createNewDog(@RequestBody Dog dog){

        Dog newDog = dogService.saveDog(dog);
        return new ResponseEntity<>(newDog, HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Dog> deleteDogById(@PathVariable long id){

        Dog dog = dogService.findDogById(id);
        if(dog!=null) {
            dogService.deleteDogById(id);
            return ResponseEntity.ok(dog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> DogById(@PathVariable long id){

        Dog dog = dogService.findDogById(id);
        if(dog!=null) {
            return ResponseEntity.ok(dog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<Dog>> getAllDogs(){
        Iterable<Dog> dogsList = dogService.findAllDogs();
        if (dogsList!=null) {
            return ResponseEntity.ok(dogsList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDog(@PathVariable long id) {
        dogService.deleteDogById(id);
        return new ResponseEntity<>("Dog with ID: " + id + "was deleted", HttpStatus.OK);
    }
}
