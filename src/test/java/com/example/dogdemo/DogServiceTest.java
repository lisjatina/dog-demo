package com.example.dogdemo;

import com.example.dogdemo.impl.DogService;
import com.example.dogdemo.model.Dog;
import com.example.dogdemo.repo.DogRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DogServiceTest {

    @Autowired
    private DogService service;

    @MockBean
    private DogRepository repository;

    @Test
    void findAll(){
        List <Dog> allDogs = new ArrayList<>();

        Dog dog =mock(Dog.class);
        dog.setId(1L);

        Dog dog3 = mock(Dog.class);
        dog3.setId(3L);

        Dog dog2 = mock(Dog.class);
        dog.setId(2L);

        allDogs.add( dog);
        allDogs.add(dog2);
        allDogs.add(dog3);

        when(repository.findAll()).thenReturn(allDogs);
        Assertions.assertThat(allDogs.size()).isGreaterThan(0);
    }

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
