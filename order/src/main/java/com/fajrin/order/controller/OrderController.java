package com.fajrin.order.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.fajrin.order.entity.Order;
import com.fajrin.order.service.OrderService;
import com.fajrin.order.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 *
 * @author HP14s FQ2002AU
 */

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping(path = "{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }
    
    @GetMapping(path = "/produk/{id}")
    public List<ResponseTemplate> getOrderWithProdukById(@PathVariable("id") Long id) {
        return orderService.getOrderWithProdukById(id);
    }
    
    @PutMapping(path = "{id}")
    public void updateOrder(@PathVariable ("id") Long id,
            @RequestParam(required = false) int jumlah,
            @RequestParam(required = false) String tangggal,
            @RequestParam(required = false) String status
            
            
    ){
        orderService.update(id, jumlah, tangggal, status);
    }
            
}