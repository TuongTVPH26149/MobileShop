/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.repositories.ChucNangNhanVienRepository;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.NhanVienRespone;
import com.poly.it17322.nhom6.services.INhanVienService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author tuan0
 */
public class NhanVienServiceImpl implements INhanVienService {

    TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();
    ChucNangNhanVienRepository chucNangNhanVienRepository = new ChucNangNhanVienRepository();

    @Override
    public List<NhanVienRespone> getlist() {
        try {
            List<TaiKhoan> lst = taiKhoanRepository.selectALLTaiKhoan();
            return lst.stream().map(NhanVienRespone::new).collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public TaiKhoan SelectNhanVienById(UUID id) {
        return taiKhoanRepository.SelectTaiKhoanById(id);
    }

    @Override
    public boolean Insert(NhanVienRespone nhanVien) {
        TaiKhoan tk = new TaiKhoan();
        tk.setMa(nhanVien.getMa());
        tk.setHoTen(nhanVien.getTen());
        tk.setGioiTinh(nhanVien.getGioiTinh());
        tk.setNgaySinh(nhanVien.getNgaySinh());
        tk.setDiaChi(nhanVien.getDiaChi());
        tk.setEmail(nhanVien.getEmail());
        tk.setSdt(nhanVien.getSdt());
        tk.setMatKhau(nhanVien.getMatKhau());
        tk.setChucVu(nhanVien.getChucVu());
        return taiKhoanRepository.InsertTaiKhoan(tk);
    }

    @Override
    public boolean Update(NhanVienRespone nhanVien) {
        TaiKhoan tk = new TaiKhoan();
        tk.setMa(nhanVien.getMa());
        tk.setHoTen(nhanVien.getTen());
        tk.setGioiTinh(nhanVien.getGioiTinh());
        tk.setNgaySinh(nhanVien.getNgaySinh());
        tk.setDiaChi(nhanVien.getDiaChi());
        tk.setEmail(nhanVien.getEmail());
        tk.setSdt(nhanVien.getSdt());
        tk.setChucVu(nhanVien.getChucVu());
        return taiKhoanRepository.UpdateTaiKhoan(tk);
    }

    @Override
    public List<TaiKhoan> timKiem(String ten) {
        try {
            List<TaiKhoan> lst = chucNangNhanVienRepository.timKiem(ten);
            return lst;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<TaiKhoan> selectTaiKhoan(int trangThai) {
        try {
            List<TaiKhoan> lst = chucNangNhanVienRepository.selectTaiKhoan(trangThai);
            return lst;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    

}
