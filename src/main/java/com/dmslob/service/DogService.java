package com.dmslob.service;

import com.dmslob.model.DogDto;
import com.dmslob.repo.Dog;
import com.dmslob.repo.MockDogProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogService {

    @Autowired
    private MockDogProvider mockDogProvider;

    public DogService(MockDogProvider mockDogProvider) {
        this.mockDogProvider = mockDogProvider;
    }

    public MockDogProvider getMockDogProvider() {
        return mockDogProvider;
    }

    public void add(DogDto dto) {
        mockDogProvider.add(dto);
    }

    public void delete(long id) {
        mockDogProvider.delete(id);
    }

    public List<Dog> getDogs() {
        return mockDogProvider.getDogs();
    }

    public Dog getDogById(long id) {
        return mockDogProvider.findDogById(id);
    }
}