/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChucVu;
import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.NhanVienRespone;
import com.poly.it17322.nhom6.services.INhanVienService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tuan0
 */
public class NhanVienServiceImpl implements INhanVienService{
    TaiKhoanRepository repo = new TaiKhoanRepository();

    @Override
    public List<NhanVienRespone> getList() {
        List<TaiKhoan> taiKhoan = repo.SelectALLTaiKhoan();
        return taiKhoan.stream().map(NhanVienRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insert(NhanVienRespone nv) {
        TaiKhoan tk = new TaiKhoan();
        tk.setMa(nv.getMa());
        tk.setHoTen(nv.getTen());
        tk.setGioiTinh(nv.getGioiTinh());
        tk.setNgaySinh(nv.getNgaySinh());
        tk.setDiaChi(nv.getDiaChi());
        tk.setSdt(nv.getSdt());
        tk.setEmail(nv.getEmail());
        return repo.InsertTaiKhoan(tk);
    }

    @Override
    public boolean update(NhanVienRespone nv) {
        TaiKhoan tk = repo.SelectTaiKhoanById(nv.getId());
        tk.setMa(nv.getMa());
        tk.setHoTen(nv.getTen());
        tk.setGioiTinh(nv.getGioiTinh());
        tk.setNgaySinh(nv.getNgaySinh());
        tk.setDiaChi(nv.getDiaChi());
        tk.setSdt(nv.getSdt());
        tk.setEmail(nv.getEmail());
        return repo.UpdateTaiKhoan(tk);
    }
    
    
}
