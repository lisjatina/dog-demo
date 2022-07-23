package com.example.dogdemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DogServiceTest {

    @Autowired
    private DogService service;

    @MockBean
    private DogRepository repository;

    @Test
    void findDogByIdTest () {
        long id = 1L;

        Dog dog = new Dog();
        dog.setId(id);
        dog.setAge(12);
        dog.setBreed("sheltie");
        dog.setName("Nera");

        Mockito.when(repository.getDogById(id)).thenReturn(dog);

        Dog foundDog = service.findDogById(id);

        assertNotNull(foundDog);
        assertEquals(foundDog, dog);
    }
    @Test
    void saveDogTest(){
        Dog dog = new Dog();
        dog.setId(1L);
        dog.setAge(12);
        dog.setBreed("sheltie");
        dog.setName("Nera");

        when(repository.save(Mockito.any(Dog.class)))
                .thenAnswer(i -> i.getArguments()[0]);
    }
}
