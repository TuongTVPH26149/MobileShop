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
                return "Đồng";
            case 1:
                return "Bạc";
            case 2:
                return "Vàng";
            case 3:
                return "Kim cương";
            default:
                return "";
        }
    }

    public int getPhanTramGiam() {
        String cap;
        switch (hang) {
            case 0:
                return 0;
            case 1:
                return 4;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    public Object[] toDataRow() {
        return new Object[]{ma, sdt, ten, getCap()};
    }
}
