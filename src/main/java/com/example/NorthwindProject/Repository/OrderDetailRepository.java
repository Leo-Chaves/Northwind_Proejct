package com.example.NorthwindProject.Repository;
import com.example.NorthwindProject.Entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}