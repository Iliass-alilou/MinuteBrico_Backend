package com.pi.MinuteBrico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.MinuteBrico.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
