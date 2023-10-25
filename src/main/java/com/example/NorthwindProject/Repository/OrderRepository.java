package com.example.NorthwindProject.Repository;
import com.example.NorthwindProject.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}