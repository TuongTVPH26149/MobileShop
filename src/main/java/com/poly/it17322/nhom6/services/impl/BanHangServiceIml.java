/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.repositories.HoaDonBanHangRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.responses.HoaDonBanHangRespone;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.services.IBanHangService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public class BanHangServiceIml implements IBanHangService {

    HoaDonBanHangRepository hdbhrepo = new HoaDonBanHangRepository();
    HoaDonRepository hdrepo = new HoaDonRepository();

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

    @Override
    public List<HoaDonBanHangRespone> getAllHdBh() {
        List<HoaDon> hds = hdrepo.selectALLHoaDon();
        List<HoaDonBanHangRespone> lstHd = new ArrayList<>();
        System.out.println("haah");
        try {
            for (HoaDon hd : hds) {
                if (hd.getTrangThai() == 1 || hd.getTrangThai() == 2 || hd.getTrangThai() == 3) {
                    lstHd.add(new HoaDonBanHangRespone(hd));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHd;
    }
}
