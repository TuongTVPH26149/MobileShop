/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.SanPham;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author admin
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SanPhamSPRespone {
    private UUID id;
    private String ten;
    private String hang;
    private String hdh;
    private String cpu;
    private String ram;
    private String rom;
    private BigDecimal gia;
    private int soluong;

    public SanPhamSPRespone(ChiTietSP sp) {
        this.id = sp.getId();
        this.ten = sp.getSanPham().getTen();
        this.cpu = sp.getCpu().getTen();
        this.ram = sp.getRam().getTen();
        this.rom = sp.getRom().getTen();
        this.gia = sp.getGia();
        this.soluong = sp.getSoLuong();
    }
    
    public Object[] toDataRow(){
        return new Object[]{ten,hang,hdh,cpu,ram,rom,gia,soluong};
    }
}
