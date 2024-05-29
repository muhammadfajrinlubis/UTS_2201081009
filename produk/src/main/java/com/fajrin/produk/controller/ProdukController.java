/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fajrin.produk.controller;

import com.fajrin.produk.entity.Produk;
import com.fajrin.produk.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * @author HP14s FQ2002AU
 */
@RestController
@RequestMapping("api/v1/produk")
public class ProdukController {

    @Autowired
    private ProdukService produkService;
   

    @GetMapping
    public List<Produk> getAll() {
        return produkService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Produk getProduk(@PathVariable("id") Long id){
        return produkService.getProduk(id);
    }

    @PostMapping
    public void insertProduk(@RequestBody Produk produk) {
        produkService.insert(produk);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduk(@PathVariable("id") Long id) {
        produkService.deleteProduk(id);
    }
    
     @PutMapping(path = "{id}")
    public void updateProduk(@PathVariable ("id") Long id,
            @RequestParam(required = false) String kode,
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) String satuan
            
            
    ){
        produkService.update(id, kode, nama, satuan);
    }
    
 
    
    
}
