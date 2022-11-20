/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private UUID id;
    private String ma;
    private String hoTen;
    private String matKhau;
    private String chucVu;
    private String trangThai;

    public UserResponse(TaiKhoan tk) {
        this.id = tk.getId();
        this.ma = tk.getMa();
        this.hoTen = tk.getHoTen();
        this.matKhau = tk.getMatKhau();
        this.chucVu = tk.getChucVu().getMa();
        this.trangThai = tk.getTrangThaiTK().getMa();
    }
}