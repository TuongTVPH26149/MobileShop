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
    private String ten;
    private String sdt;

    public khachHangBanHangRespone(KhachHang kh) {
        this.id = kh.getId();
        this.ten = kh.getMa()+"-"+kh.getHoTen();
        this.sdt = kh.getSdt();
    }
}
