package com.zb.repository;

import com.zb.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Salary, String> {

    Salary findByBmAndRq(String code, String period);

}
