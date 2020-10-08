package com.example.springbootmustacheexample.service;

import com.example.springbootmustacheexample.model.ValueSet;
import com.example.springbootmustacheexample.repository.ValueSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValueSetService {

    @Autowired
    ValueSetRepository valueSetRepository;

    public List<ValueSet> findAllBySystem(String system) {
        return valueSetRepository.findAllBySystem(system);
    }

    public Optional<ValueSet> findById(Long id) {
        return valueSetRepository.findById(id);
    }
}
