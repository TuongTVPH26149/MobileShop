/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.DonHangRespone;
import com.poly.it17322.nhom6.responses.GioHangRespone;
import com.poly.it17322.nhom6.responses.HoaDonBanHangRespone;
import com.poly.it17322.nhom6.responses.ImelBanHangRespone;
import com.poly.it17322.nhom6.responses.ImelDaBanRespone;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import com.poly.it17322.nhom6.responses.khachHangBanHangRespone;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public interface IBanHangService {

    List<HoaDonBanHangRespone> getALLHoaDonBanHang();

    boolean updateHD(UUID idhd, int trangThai);

    khachHangBanHangRespone getkh(UUID ma);

    List<SanPhamBanHangResponse> getAllSpBh();

    List<ImelDaBanRespone> getImelBan(UUID idHDCT);

    boolean deleteImelBan(String ma);

    boolean updateGHXoa(UUID idHDCT);

    List<GioHangRespone> getAllGH(UUID id);

    boolean unGH(UUID idHD);

    boolean thanhToan(DonHangRespone dh);

    List<ImelBanHangRespone> getImel(UUID id);

    boolean addSpSanner(String maImel, UUID idHD);

    DonHangRespone getDonHang(UUID id);

    GioHangRespone getGH(UUID idhd, UUID idsp);

    boolean updateGH(UUID idhd, UUID idsp, int sl);

    boolean createHoaDon(UUID idNV);

    boolean createImelBan(String maImel, UUID hoaDon);

    boolean updateDonHang(DonHangRespone dh);

    boolean huyHoaDon(UUID idHD);

    boolean setGiohang(UUID idImel, UUID idSP, UUID idHD);
}
