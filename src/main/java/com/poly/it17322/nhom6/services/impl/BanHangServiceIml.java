/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.domainmodels.Imel;
import com.poly.it17322.nhom6.domainmodels.ImelBan;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.HoaDonChiTietRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.repositories.ImelBanRepository;
import com.poly.it17322.nhom6.repositories.ImelRepository;
import com.poly.it17322.nhom6.repositories.KhachHangRepository;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.DonHangRespone;
import com.poly.it17322.nhom6.responses.GioHangRespone;
import com.poly.it17322.nhom6.responses.HoaDonBanHangRespone;
import com.poly.it17322.nhom6.responses.ImelBanHangRespone;
import com.poly.it17322.nhom6.responses.ImelDaBanRespone;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.responses.khachHangBanHangRespone;
import com.poly.it17322.nhom6.services.IBanHangService;
import java.math.BigDecimal;
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
public class BanHangServiceIml implements IBanHangService {

    ChiTietSPRepository ctsprepo = new ChiTietSPRepository();
    HoaDonChiTietRepository hdctrepo = new HoaDonChiTietRepository();
    HoaDonRepository hdrepo = new HoaDonRepository();
    TaiKhoanRepository tkrepo = new TaiKhoanRepository();
    KhachHangRepository khrepo = new KhachHangRepository();
    ImelBanRepository imlbrepo = new ImelBanRepository();
    ImelRepository imelrepo = new ImelRepository();

    @Override
    public List<HoaDonBanHangRespone> getALLHoaDonBanHang() {
        List<HoaDon> hds = hdrepo.getHD();
        List<HoaDonBanHangRespone> lstHd = hds.stream().map(HoaDonBanHangRespone::new).collect(Collectors.toList());
        List<HoaDonBanHangRespone> lstHDBH = new ArrayList<>();
        for (HoaDonBanHangRespone s : lstHd) {
            HoaDonBanHangRespone hd = new HoaDonBanHangRespone();
            try {
                hd = s;
            } catch (Exception e) {
            }
            lstHDBH.add(hd);
        }
        return lstHDBH;
    }

    @Override
    public List<SanPhamBanHangResponse> getAllSpBh() {
        List<ChiTietSP> ctsp = ctsprepo.getSP();
        List<SanPhamBanHangResponse> spbh = ctsp.stream().map(SanPhamBanHangResponse::new).collect(Collectors.toList());
        List<SanPhamBanHangResponse> lstSP = new ArrayList<>();
        for (SanPhamBanHangResponse s : spbh) {
            SanPhamBanHangResponse sp = new SanPhamBanHangResponse();
            try {
                sp = s;
            } catch (Exception e) {
            }
            lstSP.add(sp);
        }
        return lstSP;
    }

    @Override
    public List<GioHangRespone> getAllGH(UUID id) {
        HoaDon hd = hdrepo.SelectHoaDonById(id);
        List<HoaDonChiTiet> hdcts = hdctrepo.SelectByHoaDonCTID(hd.getId());
        List<GioHangRespone> gh = hdcts.stream().map(GioHangRespone::new).collect(Collectors.toList());
        return gh;
    }

    @Override
    public boolean createHoaDon(UUID idNV) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        HoaDon hd = new HoaDon();
        try {
            String maHD = "HD" + sdf.format(new Date());
            hd.setMa(maHD);
            hd.setTaiKhoan(tkrepo.SelectTaiKhoanById(idNV));
            hd.setKhachHang(khrepo.SelectKHByMa("MacDinh"));
            hd.setTrangThai(1);
            hd.setNgayTao(new Date());
            hd.setDiaChi("Tại cửa hàng");
            hd.setTongTien(new BigDecimal(0));
            hd.setTienMat(new BigDecimal(0));
            hd.setChuyenKhoan(new BigDecimal(0));
            hd.setGiamGia(new BigDecimal(0));
            hd.setLoaiThanhToan(0);
            hdrepo.InsertHoaDon(hd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean huyHoaDon(UUID idHD) {
        HoaDon hd = hdrepo.SelectHoaDonById(idHD);
        hd.setTrangThai(0);
        return hdrepo.UpdateHoaDon(hd);
    }

    @Override
    public boolean unGH(UUID idHD) {
        try {
            List<HoaDonChiTiet> hdcts = hdctrepo.SelectByHoaDonCTID(idHD);
            for (HoaDonChiTiet s : hdcts) {
                for (ImelBan i : imlbrepo.selectALLImelBan(s.getId())) {
                    Imel imel = imelrepo.SelectImelBanByMa(i.getMa());
                    imel.setTrangThai(1);
                    imelrepo.UpdateImel(imel);
                }
                UUID idSP = s.getChiTietSP().getId();
                int sl = s.getSoLuong();
                ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(idSP);
                int slSP = ctsp.getSoLuong();
                ctsp.setSoLuong(slSP + sl);
                ctsprepo.UpdateChiTietSP(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean setGiohang(UUID idImel, UUID idSP, UUID idHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DonHangRespone getDonHang(UUID id) {
        HoaDon hd = hdrepo.SelectHoaDonById(id);
        DonHangRespone dh = new DonHangRespone(hd);
        return dh;
    }

    @Override
    public boolean updateDonHang(DonHangRespone dh) {
        try {
            HoaDon hd = hdrepo.SelectHoaDonById(dh.getId());
            hd.setKhachHang(khrepo.SelectKhachHangById(dh.getMaKH()));
            hd.setTaiKhoan(tkrepo.SelectTaiKhoanById(dh.getIdNV()));
            hd.setTongTien(dh.getTongTien());
            hd.setGiamGia(dh.getGiamGia());
            hd.setTrangThai(dh.getTrangThai());
            hd.setLoaiThanhToan(dh.getHinhThuc());
            hd.setTienMat(dh.getTienMat());
            hd.setChuyenKhoan(dh.getChuyenKhoan());
            hd.setTrangThai(dh.getTrangThai());
            return hdrepo.UpdateHoaDon(hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public GioHangRespone getGH(UUID idhd, UUID idsp) {
        List<HoaDonChiTiet> hdcts = hdctrepo.getGH(idhd, idsp);
        List<GioHangRespone> gh = hdcts.stream().map(GioHangRespone::new).collect(Collectors.toList());
        for (GioHangRespone s : gh) {
            if (s.getTrangThai() == 1) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean updateGH(UUID idhd, UUID idsp, int sl) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        GioHangRespone gh = getGH(idhd, idsp);
        HoaDon hd = hdrepo.SelectHoaDonById(idhd);
        ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(idsp);
        try {
            if (gh == null) {
                String tensp = ctsp.getSanPham().getTen() + " " + ctsp.getMauSac().getTen() + " " + ctsp.getRam().getTen() + "/" + ctsp.getRom().getTen() + " " + (ctsp.getLoaiHang() == 1 ? "mới" : "cũ");
                hdct.setChiTietSP(ctsp);
                hdct.setCreatedDate(new Date());
                hdct.setDonGia(ctsp.getGia());
                hdct.setHoaDon(hd);
                hdct.setSoLuong(sl);
                hdct.setTenSP(tensp);
                hdct.setTrangThai(1);
            } else {
                hdct = hdctrepo.SelectHoaDonChiTietById(gh.getId());
                int soLuong = hdct.getSoLuong();
                hdct.setSoLuong(soLuong + sl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hdctrepo.UpdateHoaDonChiTiet(hdct)) {
            int solg = ctsp.getSoLuong();
            ctsp.setSoLuong(solg - sl);
        }
        return ctsprepo.UpdateChiTietSP(ctsp);
    }

    @Override
    public boolean updateGHXoa(UUID idHDCT) {
        HoaDonChiTiet hdct = hdctrepo.SelectHoaDonChiTietById(idHDCT);
        ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(hdct.getChiTietSP().getId());
        int solg = ctsp.getSoLuong();
        ctsp.setSoLuong(solg + 1);
        ctsprepo.UpdateChiTietSP(ctsp);
        int soLuong = hdct.getSoLuong();
        hdct.setSoLuong(soLuong - 1);
        soLuong = hdct.getSoLuong();
        if (soLuong <= 0) {
            hdctrepo.delete(hdct);
            return true;
        }
        return hdctrepo.UpdateHoaDonChiTiet(hdct);
    }

    @Override
    public List<ImelBanHangRespone> getImel(UUID id) {
        List<Imel> imels = imelrepo.Selectmamel(id);
        return imels.stream().map(ImelBanHangRespone::new).collect(Collectors.toList());
    }

    @Override
    public List<ImelDaBanRespone> getImelBan(UUID idHDCT) {
        List<ImelBan> imels = imlbrepo.selectALLImelBan(idHDCT);
        return imels.stream().map(ImelDaBanRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean createImelBan(String maImel, UUID hoaDon) {
        try {
            ImelBan imelb = new ImelBan();
            imelb.setMa(maImel);
            imelb.setTrangThai(1);
            imelb.setHoaDonChiTiet(hdctrepo.SelectHoaDonChiTietById(hoaDon));
            if (imlbrepo.InsertImelBan(imelb)) {
                Imel imel = imelrepo.SelectImelBanByMa(maImel);
                imel.setTrangThai(0);
                return imelrepo.UpdateImel(imel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean thanhToan(DonHangRespone dh) {
        try {
            HoaDon hd = hdrepo.SelectHoaDonById(dh.getId());
            hd.setKhachHang(khrepo.SelectKhachHangById(dh.getMaKH()));
            hd.setTaiKhoan(tkrepo.SelectTaiKhoanById(dh.getIdNV()));
            hd.setMa(dh.getMaHD());
            hd.setNgayThanhToan(new Date());
            hd.setTienMat(dh.getTienMat());
            hd.setChuyenKhoan(dh.getChuyenKhoan());
            hd.setNgayNhan(new Date());
            hd.setTenKH(dh.getTenkhachHang());
            hd.setDiaChi(dh.getDiaChi());
            hd.setTongTien(dh.getTongTien());
            hd.setTrangThai(4);
            hd.setLoaiThanhToan(dh.getHinhThuc());
            hd.setGiamGia(dh.getGiamGia());
            return hdrepo.UpdateHoaDon(hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public khachHangBanHangRespone getkh(UUID id) {
        return new khachHangBanHangRespone(khrepo.SelectKhachHangById(id));
    }

    @Override
    public boolean addSpSanner(String maImel, UUID idHD) {
        try {
            Imel imel = imelrepo.SelectImelBanByMa(maImel);
            if (imel.getId() == null) {
                return false;
            } else if (imel.getTrangThai() == 0) {
                return false;
            }
            if (updateGH(idHD, imel.getChiTietSP().getId(), 1)) {
                if (createImelBan(maImel, getGH(idHD, imel.getChiTietSP().getId()).getId())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteImelBan(String ma) {
        ImelBan iml = imlbrepo.SelectImelBanByMa(ma);
        Imel im = imelrepo.SelectImelBanByMa(ma);
        if (imlbrepo.delete(iml)) {
            im.setTrangThai(1);
        }
        return imelrepo.UpdateImel(im);
    }
    @Override
    public boolean updateHD(UUID idhd, int trangThai) {
        HoaDon hd = hdrepo.SelectHoaDonById(idhd);
        hd.setTrangThai(trangThai);
        return hdrepo.UpdateHoaDon(hd);
    }
    
    

}
