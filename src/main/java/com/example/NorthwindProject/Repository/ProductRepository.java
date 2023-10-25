package com.example.NorthwindProject.Repository;
import com.example.NorthwindProject.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}