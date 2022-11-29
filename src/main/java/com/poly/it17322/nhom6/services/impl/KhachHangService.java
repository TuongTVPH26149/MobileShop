/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.repositories.KhachHangRepository;
import com.poly.it17322.nhom6.repositories.ChucNangKHRepository;
import com.poly.it17322.nhom6.responses.KhachHangResponse;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.services.IKhachHangService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class KhachHangService implements IKhachHangService {

    private KhachHangRepository KHRepo;
    private ChucNangKHRepository TKrepo = new ChucNangKHRepository();

    public KhachHangService() {
        KHRepo = new KhachHangRepository();
    }

    @Override
    public List<KhachHangResponse> getlist() {
        try {
            List<KhachHang> khs = KHRepo.selectALLKhachHang();
            return khs.stream().map(KhachHangResponse::new).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public KhachHang SelectKhachHangById(UUID id) {
        return KHRepo.SelectKhachHangById(id);
    }

    @Override
    public boolean Insert(KhachHangResponse khachHang) {
        KhachHang kh = new KhachHang();
        kh.setMa(khachHang.getMa());
        kh.setHoTen(khachHang.getHoten());
        kh.setNgaySinh(khachHang.getNgaysinh());
        kh.setSdt(khachHang.getSdt());
        kh.setDiaChi(khachHang.getDiachi());
        kh.setGioiTinh(khachHang.getGioitinh());
        return KHRepo.InsertKhachHang(kh);
    }

    @Override
    public boolean Update(KhachHangResponse khachHang) {
        KhachHang kh = KHRepo.SelectKhachHangById(khachHang.getId());
        kh.setMa(khachHang.getMa());
        kh.setHoTen(khachHang.getHoten());
        kh.setNgaySinh(khachHang.getNgaysinh());
        kh.setSdt(khachHang.getSdt());
        kh.setDiaChi(khachHang.getDiachi());
        kh.setGioiTinh(khachHang.getGioitinh());

        return KHRepo.UpdateKhachHang(kh);
    }

    @Override
    public List<KhachHangResponse> timkiem(String sdt) {
        List<KhachHang> lstkh = TKrepo.timkiem(sdt);
        return lstkh.stream().map(KhachHangResponse::new).collect(Collectors.toList());

    }

    @Override
    public List<KhachHangResponse> LocKH(int GioiTinh) {
        List<KhachHang> lstkh = TKrepo.LocKH(GioiTinh);
        return lstkh.stream().map(KhachHangResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDon> selectallhoadon(UUID IdKH) {
        return TKrepo.selectallhoadon(IdKH);
    }

}
