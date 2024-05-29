/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package com.fajrin.pembayaran.controller;

import com.fajrin.pembayaran.entity.Pembayaran;
import com.fajrin.pembayaran.service.PembayaranService;
import com.fajrin.pembayaran.vo.ResponseTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author HP14s FQ2002AU
 */
@RestController
@RequestMapping("api/v1/pembayaran")
public class PembayaranController {
    @Autowired
    private PembayaranService pembayaranService;
    
   @GetMapping
    public List<Pembayaran> getAll() {
        return pembayaranService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Pembayaran getPembayaran(@PathVariable("id") Long id){
        return pembayaranService.getPembayaran(id);
    }

    @PostMapping
    public void insertPembayaran(@RequestBody Pembayaran pembayaran) {
        pembayaranService.insert(pembayaran);
    } 
     @GetMapping(path = "/order/produk/{id}")
    public List<ResponseTemplate>getPembayaranWithOrderkById(@PathVariable("id") Long id) {
        return pembayaranService.getPembayaranWithOrderkById(id);
    }
    
     @DeleteMapping(path = "{id}")
    public void deletePemabayaran(@PathVariable("id") Long id) {
        pembayaranService.deletePembayaran(id);
    }
     
    
       @PutMapping(path = "{id}")
    public void updatePembayaran(@PathVariable("id") Long id,
                                 @RequestParam(required = false) String mode_pembayaran,
                                 @RequestParam(required = false) Integer ref_number,
                                 @RequestParam(required = false) String tgl_bayar,
                                 @RequestParam(required = false) String status,
                                 @RequestParam(required = false) Double total) {
        pembayaranService.update(id, mode_pembayaran, ref_number, tgl_bayar, status, total);
    }

}