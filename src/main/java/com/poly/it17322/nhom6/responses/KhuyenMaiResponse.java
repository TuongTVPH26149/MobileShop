/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author TUYEN
 */
@Getter
@Setter
public class KhuyenMaiResponse {

    private UUID id;
    private String ma;
    private String ten;
    private Date ngayBD;
    private Date ngayKT;
    private int giaTri;
    private int trangThai;

    public KhuyenMaiResponse() {
    }

    public KhuyenMaiResponse(KhuyenMai km) {
        this.id = km.getId();
        this.ma = km.getMa();
        this.ten = km.getTen();
        this.ngayBD = km.getNgayBD();
        this.ngayKT = km.getNgayKT();
        this.giaTri = km.getGiaTri();
        this.trangThai = km.getTrangThai();
    }

    public Object[] toDataRow() {
        return new Object[]{id, ma, ten, ngayBD, ngayKT, giaTri, trangThai};
    }

}
