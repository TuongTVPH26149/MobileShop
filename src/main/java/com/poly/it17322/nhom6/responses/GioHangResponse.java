/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
public class GioHangResponse {
    
    private UUID idSp;
    private String tenSP;
    private int soLuong;
    private BigDecimal giaBan;

    public GioHangResponse(HoaDonChiTiet hdct) {
        this.idSp = hdct.getChiTietSP().getId();
        this.tenSP = hdct.getTenSP();
        this.soLuong = hdct.getSoLuong();
        this.giaBan = hdct.getGia();
    }
    
    public Object[] toDataRow(){
    return new Object[]{this.tenSP, this.soLuong,this.giaBan};
}
}
