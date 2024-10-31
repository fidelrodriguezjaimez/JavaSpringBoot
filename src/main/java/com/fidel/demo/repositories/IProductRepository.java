package com.fidel.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import com.fidel.demo.entities.Product;


public interface IProductRepository extends CrudRepository<Product, Long> {

}
