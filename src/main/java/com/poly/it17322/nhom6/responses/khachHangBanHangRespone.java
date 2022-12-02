/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Setter
@Getter
@NoArgsConstructor
public class khachHangBanHangRespone {

    private UUID id;
    private String ma;
    private String ten;
    private String sdt;
    private int hang;
    private int phanTramGiam;

    public khachHangBanHangRespone(KhachHang kh) {
        this.id = kh.getId();
        this.ma = kh.getMa();
        this.ten = kh.getHoTen();
        this.sdt = kh.getSdt();
        this.hang = kh.getCapDo();
    }

    private String getCap() {
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

    private int giamGia() {
        String cap;
        switch (hang) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
                return 7;
            case 6:
                return 10;
            case 7:
                return 11;
            case 8:
                return 12;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            default:
                return 20;
        }
    }

    public Object[] toDataRow() {
        return new Object[]{ma, sdt, ten, getCap()};
    }
}
