/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
@NoArgsConstructor
public class DonHangRespone {

    private UUID id;
    private UUID idNV;
    private UUID maKH;
    private String tenkhachHang;
    private String maHD;
    private String maNV;
    private String diaChi;
    private BigDecimal tongTien;
    private BigDecimal tienMat;
    private BigDecimal chuyenKhoan;
    private BigDecimal giamGia;
    private int hinhThuc;
    private int nhanHang;
    private int trangThai;

    public DonHangRespone(HoaDon h) {
        this.id = h.getId();
        this.maKH = h.getKhachHang().getId();
        this.idNV = h.getTaiKhoan().getId();
        this.tenkhachHang = h.getKhachHang().getMa() + "-" + h.getKhachHang().getHoTen();
        this.maHD = h.getMa();
        this.maNV = h.getTaiKhoan().getMa() + "-" + h.getTaiKhoan().getHoTen();
        this.diaChi = h.getDiaChi();
        this.tongTien = h.getTongTien();
        this.tienMat = h.getTienMat();
        this.chuyenKhoan = h.getChuyenKhoan();
        this.giamGia = h.getGiamGia();
        this.hinhThuc = h.getLoaiThanhToan();
        this.nhanHang = h.getTrangThai() == 1 ? 1 : (h.getTrangThai() == 2 ? 1 : 0);
        this.trangThai = h.getTrangThai();
    }

}
