package com.ms.paginacao.services;

import com.ms.paginacao.models.Food;
import com.ms.paginacao.repositories.RepositoryFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFood {


    @Autowired
    private RepositoryFood repositoryFood;

    public Food save(Food food){
        return this.repositoryFood.save(food);
    }
    public Page<Food> getPageProducts(String nome, Pageable pageable){
        return this.repositoryFood.findByNameContaining(nome,pageable);
    }

    public List<Food> getAll(){
        return this.repositoryFood.findAll();
    }
}
