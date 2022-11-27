/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tuan0
 */
@Getter
@Setter
@NoArgsConstructor

public class NhanVienRespone {
    private UUID id;
    private String ma;
    private String ten;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String chucVu;

    public NhanVienRespone() {
    }

    public NhanVienRespone(TaiKhoan taiKhoan) {
        this.ma = taiKhoan.getMa();
        this.ten = taiKhoan.getHoTen();
        this.gioiTinh = taiKhoan.getGioiTinh();
        this.ngaySinh = taiKhoan.getNgaySinh();
        this.diaChi = taiKhoan.getDiaChi();
        this.sdt = taiKhoan.getSdt();
        this.email = taiKhoan.getEmail();
        this.chucVu = taiKhoan.getChucVu().getTen();
    }

    public Object[] toDataRow(){
        return new Object[]{this.ma, this.ten, this.gioiTinh, this.ngaySinh, this.diaChi, this.sdt, this.email, this.chucVu};
    }
}
