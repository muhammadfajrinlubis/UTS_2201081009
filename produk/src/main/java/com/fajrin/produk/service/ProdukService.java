/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fajrin.produk.service;

import com.fajrin.produk.entity.Produk;
import com.fajrin.produk.repository.ProdukRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP14s FQ2002AU
 */

@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;
    
    public List<Produk>getAll(){
        return produkRepository.findAll();
    }
    
    public Produk getProduk(Long id){
        return produkRepository.findById(id).get();
    }
    
    @Transactional
    public void insert(Produk produk){
        produkRepository.save(produk);
    }
   
    public void deleteProduk(Long id) {
        produkRepository.deleteById(id);
    }
    
     @jakarta.transaction.Transactional
    public void update(Long produkId, String kode, String nama, String satuan) {
        // TODO Auto-generated method stub
        Produk produk = produkRepository.findById(produkId).orElseThrow(() 
                -> new IllegalStateException("produk tidak ada"));
        if (kode != null) {
            produk.setKode(kode);
        }
        if (nama != null && nama.length() > 0 
                && !Objects.equals(produk.getNama(), nama)) {
            produk.setNama(nama);
        }
        if (satuan != null && satuan.length() > 0 
                && !Objects.equals(produk.getSatuan(), satuan)) {
            produk.setSatuan(satuan);
        }

    }
   

}
