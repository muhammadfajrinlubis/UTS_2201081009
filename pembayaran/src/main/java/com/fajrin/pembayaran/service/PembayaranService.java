/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fajrin.pembayaran.service;

import com.fajrin.pembayaran.entity.Pembayaran;
import com.fajrin.pembayaran.repository.PembayaranRepository;
import com.fajrin.pembayaran.vo.Order;
import com.fajrin.pembayaran.vo.Produk;
import com.fajrin.pembayaran.vo.ResponseTemplate;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author HP14s FQ2002AU
 */
@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;
     @Autowired
    private RestTemplate restTemplate;
    
    public List<Pembayaran> getAll() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getPembayaran(Long id){
        return pembayaranRepository.findById(id).get();
    }
    
    @Transactional
    public void insert(Pembayaran pembayaran){
        pembayaranRepository.save(pembayaran);
    }
    public Pembayaran getPembayaranById(Long id) {
        return pembayaranRepository.findById(id).get();
    }
    
     public List<ResponseTemplate> getPembayaranWithOrderkById(Long id){
        List<ResponseTemplate> responseList = new ArrayList<>();
        Pembayaran pembayaran = getPembayaranById(id);
         Order order = restTemplate.getForObject("http://localhost:9002/api/v1/order/" 
                + pembayaran.getOrder_Id(), Order.class);  
        Produk produk = restTemplate.getForObject("http://localhost:9001/api/v1/produk/"
                + pembayaran.getOrder_Id(),Produk.class);
        ResponseTemplate vo = new ResponseTemplate();
        vo.setOrder(order);
        vo.setProduk(produk);
        vo.setPembayaran(pembayaran);
        responseList.add(vo);
        return responseList;
    }
   
}