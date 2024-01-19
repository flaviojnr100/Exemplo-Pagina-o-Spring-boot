package com.ms.paginacao.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ms.paginacao.DTO.FoodDTO;
import com.ms.paginacao.models.Food;
import com.ms.paginacao.services.ServiceFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ControllerFood {

    @Autowired
    private ServiceFood serviceFood;

    @PostMapping
    public ResponseEntity<Food> create(@RequestBody FoodDTO foodDTO){
        var food = new Food();
        food.setName(foodDTO.name());
        food.setPrice(foodDTO.price());
        food.setUrl(foodDTO.url());
        food.setAvailability(true);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.serviceFood.save(food));
    }
    @GetMapping
    public ResponseEntity<List<Food>> getFoods(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.serviceFood.getAll());
    }

    @GetMapping(path = "/foods")
    public ResponseEntity<Page<Food>> getFoodsPage(@RequestParam(name = "name",required = false) String name, Pageable pageable){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.serviceFood.getPageProducts(name,pageable));
    }
}
