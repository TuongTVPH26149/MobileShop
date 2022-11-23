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
import com.poly.it17322.nhom6.repositories.ImelBanHangRepository;
import com.poly.it17322.nhom6.repositories.ImelRepository;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.repositories.TrangThaiHoaDonRepository;
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
    private final TrangThaiHoaDonRepository tthdrepo = new TrangThaiHoaDonRepository();
    private final HoaDonChiTietRepository hdctrepo = new HoaDonChiTietRepository();
    private final ChiTietSPRepository ctspbhrepo = new ChiTietSPRepository();
    private final TaiKhoanRepository tkbhrepo = new TaiKhoanRepository();
    private final ImelRepository imelrepo = new ImelRepository();
    private final ImelBanHangRepository imelbhrepo = new ImelBanHangRepository();
    private final TrangThaiHoaDonRepository tthd = new TrangThaiHoaDonRepository();

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

    public GioHangResponse getHDCT(UUID idHD, UUID idCTSP) {
        HoaDonChiTiet hdct = hdctrepo.SelectAllHoaDonById(idHD, idCTSP);
        return new GioHangResponse(hdct);
    }

    @Override
    public List<GioHangResponse> getGH(UUID idHD) {
        List<HoaDonChiTiet> hdct = hdctrepo.SelectGH(idHD);
        List<GioHangResponse> lstsp = hdct.stream().map(GioHangResponse::new).collect(Collectors.toList());
        List<GioHangResponse> lstHT = new ArrayList<>();
        for (GioHangResponse s : lstsp) {
            if (s.getSoLuong() > 0) {
                lstHT.add(s);
            }
        }
        return lstHT;
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

    @Override
    public boolean setGiohang(UUID idImel, UUID idSP, UUID idHD) {
        try {
            Imel imel = imelrepo.SelectImelId(idImel);
            ChiTietSP ctsp = ctspbhrepo.SelectAllCTSanPhamById(idSP);
            HoaDon hd = hdrepo.SelectAllHoaDonById(idHD);
            HoaDonChiTiet hdct = hdctrepo.SelectAllHoaDonById(idHD, idSP);
            if (hdct == null) {
                hdct = new HoaDonChiTiet();
                hdct.setChiTietSP(ctsp);
                hdct.setHoaDon(hd);
                hdct.setSoLuong(1);
                hdct.setTenSP(ctsp.getSanPham().getTen() + " " + ctsp.getMauSac().getTen() + " " + ctsp.getRam().getTen() + "/" + ctsp.getRom().getTen());
                hdct.setGia(ctsp.getGia());
            } else {
                int sl = hdct.getSoLuong();
                hdct.setSoLuong(sl + 1);
            }
            hdctrepo.UpdateChiTietSP(hdct);
            hdct.setChiTietSP(ctsp);
            imel.setHoaDon(hd);
            imel.setTrangThaiImel(imelbhrepo.SelectAllTrangThaiImelById("TT2"));
            imelrepo.UpdateImel(imel);
            int sl2 = ctsp.getSoLuong();
            ctsp.setSoLuong(sl2 - 1);
            ctspbhrepo.UpdateChiTietSP(ctsp);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ImelBanHangResponse> getImelGioHang(UUID idHD, UUID idCTSP) {
        List<ImelBanHangResponse> lstImelBH = new ArrayList<>();
        List<Imel> lstImel = imelrepo.SelectALlImel();
        for (Imel i : lstImel) {
            try {
                if (i.getTrangThaiImel().getMa().equals("TT2")&&i.getChiTietSP().getId().equals(idCTSP) && i.getHoaDon().getId().equals(idHD)) {
                    lstImelBH.add(new ImelBanHangResponse(i));
                }
            } catch (NullPointerException e) {
            }
        }
        return lstImelBH;
    }

    @Override
    public boolean huyHoaDon(UUID idHD) {
        HoaDon hd = hdrepo.SelectAllHoaDonById(idHD);
        hd.setTrangThaiHD(tthdrepo.SelectTrangThaiHoaDonByMa("TT03"));
        List<Imel> lstImel = imelrepo.SelectALlImel();
        for (Imel i : lstImel) {
            try {
                if (i.getHoaDon().getId().equals(idHD)) {
                    i.setTrangThaiImel(imelbhrepo.SelectAllTrangThaiImelById("TT1"));
                    imelrepo.UpdateImel(i);
                    ChiTietSP ctsp = ctspbhrepo.SelectAllCTSanPhamById(i.getChiTietSP().getId());
                    int sl = ctsp.getSoLuong();
                    ctsp.setSoLuong(sl + 1);
                    ctspbhrepo.UpdateChiTietSP(ctsp);
                }
            } catch (NullPointerException e) {
            }
        }
        hd.setTrangThaiHD(tthd.SelectTrangThaiHoaDonByMa("TT03"));
        hdrepo.UpdateHoaDon(hd);
        return false;
    }

    @Override
    public boolean thanhToan(HoaDonBanHangResponse hd) {
        HoaDon hoaDon = hdrepo.SelectAllHoaDonById(hd.getId());
        hoaDon.setTongTien(hd.getTongTien());
        hoaDon.setLoaiThanhToan(hd.isLoaiThanhToan());
        hoaDon.setTrangThaiHD(hdbhrepo.SelectTrangThaiHoaDonByMa("TT02"));
        return hdrepo.UpdateHoaDon(hoaDon);
    }

    @Override
    public List<ImelBanHangResponse> getImelSearch(String ma, UUID idSP) {
        List<ImelBanHangResponse> lstImelBH = new ArrayList<>();
        List<Imel> lstImel = imelbhrepo.Selectmamel(ma, idSP);
        return lstImel.stream().map(ImelBanHangResponse::new).collect(Collectors.toList());
    }

    public boolean removeGiohang(UUID id, UUID idSP, UUID idHD) {
        try {
            HoaDonChiTiet hdct = hdctrepo.SelectAllHoaDonById(idHD, idSP);
            int sl = hdct.getSoLuong();
            hdct.setSoLuong(sl-1);
            hdctrepo.UpdateChiTietSP(hdct);
            ChiTietSP ctsp = ctspbhrepo.SelectAllCTSanPhamById(idSP);
            int sl2 = ctsp.getSoLuong();
            ctsp.setSoLuong(sl2+1);
            ctspbhrepo.UpdateChiTietSP(ctsp);
            Imel imel = imelrepo.SelectImelId(id);
            imel.setTrangThaiImel(imelbhrepo.SelectAllTrangThaiImelById("TT1"));
            return imelrepo.UpdateImel(imel);
        } catch (Exception e) {
            return false;
        }
    }

}
