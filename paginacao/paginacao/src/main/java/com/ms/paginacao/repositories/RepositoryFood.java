package com.ms.paginacao.repositories;

import com.ms.paginacao.models.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryFood extends JpaRepository<Food,Long> {
    Page<Food> findByNameContaining(String nome, Pageable pageable);
}
