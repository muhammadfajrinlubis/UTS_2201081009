/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fajrin.produk.service;

import com.fajrin.produk.entity.Produk;
import com.fajrin.produk.repository.ProdukRepository;
import java.util.List;
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
    
     @Transactional
    public void updateProduk(Long id, Produk produkDetails) {
        Optional<Produk> optionalProduk = produkRepository.findById(id);
        if (optionalProduk.isPresent()) {
            Produk existingProduk = optionalProduk.get();
            existingProduk.setKode(produkDetails.getKode());
            existingProduk.setNama(produkDetails.getNama());
            existingProduk.setSatuan(produkDetails.getSatuan());
            // Update other fields as necessary
            produkRepository.save(existingProduk);
        }
    }

}
