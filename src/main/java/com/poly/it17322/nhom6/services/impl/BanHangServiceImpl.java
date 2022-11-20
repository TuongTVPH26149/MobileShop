/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.domainmodels.Imel;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.HoaDonBanHangRepository;
import com.poly.it17322.nhom6.repositories.HoaDonChiTietRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.repositories.ImelRepository;
import com.poly.it17322.nhom6.repositories.KhachHangRepository;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.GioHangResponse;
import com.poly.it17322.nhom6.responses.HoaDonBanHangResponse;
import com.poly.it17322.nhom6.responses.ImelBanHangResponse;
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
public class BanHangServiceImpl implements IBanHangService {

    private final HoaDonBanHangRepository hdbhrepo = new HoaDonBanHangRepository();
    private final HoaDonRepository hdrepo = new HoaDonRepository();
    private final HoaDonChiTietRepository hdctrepo = new HoaDonChiTietRepository();
    private final ChiTietSPRepository ctspbhrepo = new ChiTietSPRepository();
    private final TaiKhoanRepository tkbhrepo = new TaiKhoanRepository();
    private final ImelRepository imelrepo = new ImelRepository();

    @Override
    public List<HoaDonBanHangResponse> getHoaDonTreo() {
        List<HoaDonBanHangResponse> hdt = new ArrayList<>();
        List<HoaDon> hd = hdrepo.SelectALLHoaDon();
        for (HoaDonBanHangResponse o : hd.stream().map(HoaDonBanHangResponse::new).collect(Collectors.toList())) {
            if (o.getTrangThai().equals("TT01")) {
                hdt.add(o);
            }
        }
        return hdt;
    }

    @Override
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

    @Override
    public boolean createHoaDon(UUID idNV) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa("HD" + new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
        if (hdbhrepo.checkMa(hoaDon.getMa())) {
            hoaDon.setMa(hoaDon.getMa());
        } else {
            hoaDon.setMa("HD" + new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
        }
        hoaDon.setCreatedDate(new Date());
        hoaDon.setTrangThaiHD(hdbhrepo.SelectTrangThaiHoaDonByMa("TT01"));
        hoaDon.setKhachHang(hdbhrepo.SelectKHByMa("MacDinh"));
        hoaDon.setTaiKhoan(tkbhrepo.SelectTaiKhoanById(idNV));
        return hdrepo.InsertHoaDon(hoaDon);
    }

    @Override
    public List<GioHangResponse> getGioHang(UUID idHD, UUID idCTSP) {
        List<GioHangResponse> lstsp = new ArrayList<>();
        List<HoaDonChiTiet> hdct = hdctrepo.SelectAllHoaDonById(idHD, idCTSP);
        return hdct.stream().map(GioHangResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<ImelBanHangResponse> getImelBH(UUID idSP) {
        List<ImelBanHangResponse> lstImelBH = new ArrayList<>();
        List<Imel> lstImel = imelrepo.SelectALlImel();
        for (Imel i : lstImel) {
            if (i.getTrangThaiImel().getMa().equals("TT1") && i.getChiTietSP().getId().equals(idSP)) {
                lstImelBH.add(new ImelBanHangResponse(i));
            }
        }
        return lstImelBH;
    }

}
