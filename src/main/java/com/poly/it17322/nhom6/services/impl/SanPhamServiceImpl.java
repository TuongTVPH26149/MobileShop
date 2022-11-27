/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.SanPhamReposiry;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.responses.SanPhamSPRespone;
import com.poly.it17322.nhom6.services.ISanPhamSPService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class SanPhamServiceImpl implements ISanPhamSPService{
private ChiTietSPRepository ctsprepo = new ChiTietSPRepository();
private SanPhamReposiry sprepo = new SanPhamReposiry();
    @Override
    public List<SanPhamSPRespone> getlist() {
        List<SanPhamSPRespone> lstsp = new ArrayList<>();
        List<ChiTietSP> ctsp = ctsprepo.selectALLChiTietSP();
        for (SanPhamSPRespone o : ctsp.stream().map(SanPhamSPRespone::new).collect(Collectors.toList())) {
            if (o.getSoluong() > 0) {
                lstsp.add(o);
            }
        }
        return lstsp;
    }

    @Override
    public boolean insert(SanPhamSPRespone sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(SanPhamSPRespone sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
