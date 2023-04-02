package mybootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import mybootapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}