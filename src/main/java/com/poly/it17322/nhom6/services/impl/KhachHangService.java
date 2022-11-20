/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.repositories.KhachHangRepository;
import com.poly.it17322.nhom6.responses.KhachHangResponse;
import com.poly.it17322.nhom6.services.IKhachHangService;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class KhachHangService implements IKhachHangService{
    
    private KhachHangRepository KHRepo;
    
    public KhachHangService(){
        KHRepo = new KhachHangRepository();
    }

    @Override
    public List<KhachHang> SelectAllKhachHang() {
        return KHRepo.SelectAllKhachHang();
    }

    @Override
    public KhachHang SelectKhachHangById(UUID id) {
        return KHRepo.SelectKhachHangById(id);
    }

    @Override
    public Boolean InsertKhachHang(KhachHang khachHang) {
        
        return KHRepo.InsertKhachHang(khachHang);
    }

    @Override
    public Boolean UpdateKhachHang( KhachHang khachHang  ) {
        return KHRepo.UpdateKhachHang(khachHang);
    }


    
}
