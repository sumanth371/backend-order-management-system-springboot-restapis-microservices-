package com.arjun.orderser.repository;

import com.arjun.orderser.model.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<order,Long> {
}
