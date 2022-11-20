/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.GioHangResponse;
import com.poly.it17322.nhom6.responses.HoaDonBanHangResponse;
import com.poly.it17322.nhom6.responses.ImelBanHangResponse;
import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public interface IBanHangService {

    List<HoaDonBanHangResponse> getHoaDonTreo();

    List<SanPhamBanHangResponse> getAllSpBh();

    boolean createHoaDon(UUID idNV);

    List<GioHangResponse> getGioHang(UUID idHD, UUID idCTSP);

    public List<ImelBanHangResponse> getImelBH(UUID idSP);
}
