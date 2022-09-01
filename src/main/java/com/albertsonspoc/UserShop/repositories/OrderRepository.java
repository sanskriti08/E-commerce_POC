package com.albertsonspoc.UserShop.repositories;

import com.albertsonspoc.UserShop.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findByUserId(Integer userId);
    Orders findFirstByOrderByIdDesc();
}
