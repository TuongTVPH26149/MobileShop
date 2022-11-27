/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.responses.DonHangRespone;
import com.poly.it17322.nhom6.responses.GioHangInRespone;
import com.poly.it17322.nhom6.responses.GioHangRespone;
import com.poly.it17322.nhom6.responses.HoaDonBanHangRespone;
import com.poly.it17322.nhom6.responses.ImelBanHangRespone;
import com.poly.it17322.nhom6.responses.KhachHangResponse;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.responses.khachHangBanHangRespone;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public interface IBanHangService {

    List<SanPhamBanHangResponse> getAllSpBh();

    List<HoaDonBanHangRespone> getAllHdBh();

    List<GioHangRespone> getAllGH(UUID id);

    boolean unGH(UUID idHD);
    boolean thanhToan(DonHangRespone dh);

    List<ImelBanHangRespone> getImel(UUID id);

    DonHangRespone getDonHang(UUID id);

    khachHangBanHangRespone getKHDefault();

    GioHangRespone getGH(UUID idhd, UUID idsp);

    boolean updateGH(UUID idhd, UUID idsp, int sl);

    boolean createHoaDon(UUID idNV);

    boolean createImelBan(String maImel, UUID hoaDon);

    boolean updateDonHang(DonHangRespone dh);

    boolean checkGH(UUID idhd, UUID idsp);

    boolean huyHoaDon(UUID idHD);

    boolean setGiohang(UUID idImel, UUID idSP, UUID idHD);
}
