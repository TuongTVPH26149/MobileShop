/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.services.IBanHangService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public class BanHangServiceIml implements IBanHangService{

    @Override
    public List<SanPhamBanHangResponse> getAllSpBh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean createHoaDon(UUID idNV) {
        
        return false;
    }

    @Override
    public boolean huyHoaDon(UUID idHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean setGiohang(UUID idImel, UUID idSP, UUID idHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
