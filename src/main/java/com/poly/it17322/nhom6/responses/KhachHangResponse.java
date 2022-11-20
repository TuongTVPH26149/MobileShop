/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KhachHangResponse {
    private String ma;
    private String hoten;
    private String gioitinh;
    private String sdt;
    private String diachi;
    private Date ngaysinh;

    public KhachHangResponse(String ma, String hoten, String gioitinh, String sdt, String diachi, Date ngaysinh) {
        this.ma = ma;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
    }
    
    
}
