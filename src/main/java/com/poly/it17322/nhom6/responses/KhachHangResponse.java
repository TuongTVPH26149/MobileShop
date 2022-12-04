/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KhachHangResponse {

    private UUID id;
    private String ma;
    private String hoten;
    private int gioitinh;
    private String sdt;
    private String diachi;
    private Date ngaysinh;
    private int hang;

    public KhachHangResponse(KhachHang khachhang) {
        this.id = khachhang.getId();
        this.ma = khachhang.getMa();
        this.hoten = khachhang.getHoTen();
        this.gioitinh = khachhang.getGioiTinh();
        this.sdt = khachhang.getSdt();
        this.diachi = khachhang.getDiaChi();
        this.ngaysinh = khachhang.getNgaySinh();
    }

    public String getHang() {
        String cap;
        switch (hang) {
            case 0:
                return "Đồng I";
            case 1:
                return "Đồng II";
            case 2:
                return "Đồng III";
            case 3:
                return "Bạc I";
            case 4:
                return "Bạc II";
            case 5:
                return "Bạc III";
            case 6:
                return "Vàng I";
            case 7:
                return "Vàng II";
            case 8:
                return "Vàng III";
            case 9:
                return "Bạch kim I";
            case 10:
                return "Bạch kim II";
            case 11:
                return "Bạch kim III";
            default:
                return "Kim cương";
        }
    }
}
