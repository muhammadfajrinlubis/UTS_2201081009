/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fajrin.order.repository;

import com.fajrin.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP14s FQ2002AU
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
