package com.Training.Test.demo.Repository;

import com.Training.Test.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
