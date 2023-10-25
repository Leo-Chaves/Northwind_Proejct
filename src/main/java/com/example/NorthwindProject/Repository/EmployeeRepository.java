package com.example.NorthwindProject.Repository;
import com.example.NorthwindProject.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}