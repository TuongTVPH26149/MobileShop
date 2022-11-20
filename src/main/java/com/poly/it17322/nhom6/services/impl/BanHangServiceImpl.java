/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.HoaDonBanHangRepository;
import com.poly.it17322.nhom6.repositories.HoaDonChiTietRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.repositories.KhachHangRepository;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.GioHangResponse;
import com.poly.it17322.nhom6.responses.HoaDonBanHangResponse;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.services.IBanHangService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author LiamTrieu
 */
public class BanHangServiceImpl {

    private HoaDonBanHangRepository hdbhrepo = new HoaDonBanHangRepository();
    private HoaDonRepository hdrepo = new HoaDonRepository();
    private HoaDonChiTietRepository hdctrepo = new HoaDonChiTietRepository();
    private ChiTietSPRepository ctspbhrepo = new ChiTietSPRepository();
    private TaiKhoanRepository tkbhrepo = new TaiKhoanRepository();
    private KhachHangRepository khbhrepo = new KhachHangRepository();

//    @Override
//    public List<HoaDonBanHangResponse> getHoaDonTreo() {
//        List<HoaDonBanHangResponse> hdt = new ArrayList<>();
//        List<HoaDon> hd = hdrepo.SelectALLHoaDon();
//        for (HoaDonBanHangResponse o : hd.stream().map(HoaDonBanHangResponse::new).collect(Collectors.toList())) {
//            if (o.getTrangThai().equals("TT01")) {
//                hdt.add(o);
//            }
//        }
//        return hdt;
//    }
    public List<SanPhamBanHangResponse> getAllSpBh() {
        List<SanPhamBanHangResponse> lstsp = new ArrayList<>();
        List<ChiTietSP> sp = ctspbhrepo.SelectCTSanPham();
        for (SanPhamBanHangResponse o : sp.stream().map(SanPhamBanHangResponse::new).collect(Collectors.toList())) {
            if (o.getSoLuong() > 0) {
                lstsp.add(o);
            }
        }
        return lstsp;
    }

    public boolean createHoaDon(UUID idNV) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa("HD" + new SimpleDateFormat("yyMMddHHMMssSSS").format(new Date()));
        if (hdbhrepo.checkMa(hoaDon.getMa())) {
            hoaDon.setMa(hoaDon.getMa());
        } else {
            hoaDon.setMa("HD" + new SimpleDateFormat("yyMMddHHMMssSSS").format(new Date()));
        }
        hoaDon.setCreatedDate(new Date());
        hoaDon.setTrangThaiHD(hdbhrepo.SelectTrangThaiHoaDonByMa("TT01"));
        hoaDon.setKhachHang(hdbhrepo.SelectKHByMa("MacDinh"));
        hoaDon.setTaiKhoan(tkbhrepo.SelectTaiKhoanById(idNV));
        return hdrepo.InsertHoaDon(hoaDon);
    }

    public List<GioHangResponse> getGioHang(UUID idHD, UUID idCTSP) {
        List<GioHangResponse> lstsp = new ArrayList<>();
        List<HoaDonChiTiet> hdct = hdctrepo.SelectAllHoaDonById(idHD, idCTSP);
        return hdct.stream().map(GioHangResponse::new).collect(Collectors.toList());
    }

    public List<HoaDonBanHangResponse> getHoaDonTreo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
