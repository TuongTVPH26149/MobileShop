/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.SanPhamBanHangResponse;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author LiamTrieu
 */
public interface IBanHangService {

    List<SanPhamBanHangResponse> getAllSpBh();

    boolean createHoaDon(UUID idNV);

    boolean huyHoaDon(UUID idHD);

    boolean setGiohang(UUID idImel, UUID idSP, UUID idHD);
}
