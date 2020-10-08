package com.example.springbootmustacheexample.repository;

import com.example.springbootmustacheexample.model.User;
import com.example.springbootmustacheexample.model.ValueSet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ValueSetRepository extends PagingAndSortingRepository<ValueSet, Long>, JpaSpecificationExecutor<User> {

    public List<ValueSet> findAllBySystem(String system);
}
