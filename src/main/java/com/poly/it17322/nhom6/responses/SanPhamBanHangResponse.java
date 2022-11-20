/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Setter
@Getter
public class SanPhamBanHangResponse {
    private UUID id;
    private String tenSanPham;
    private String cpu;
    private int soLuong;
    private BigDecimal giaBan;

    public SanPhamBanHangResponse(ChiTietSP sp) {
        this.id = sp.getId();
        this.tenSanPham = sp.getSanPham().getTen()+ " " + sp.getMauSac().getTen() + " " + sp.getRam().getTen()+"/"+sp.getRom().getTen();
        this.cpu = sp.getCpu().getTen();
        this.soLuong = sp.getSoLuong();
        this.giaBan = sp.getGia();
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.tenSanPham,this.cpu,this.soLuong,this.giaBan};
    }
}
