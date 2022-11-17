/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.repositories.TaiKhoanDangNhapRepository;
import com.poly.it17322.nhom6.responses.UserResponse;
import com.poly.it17322.nhom6.services.IDangNhapService;

/**
 *
 * @author LiamTrieu
 */
public class DangNhapServiceImpl implements IDangNhapService {

    private TaiKhoanDangNhapRepository tkdnRepo = new TaiKhoanDangNhapRepository();

    @Override
    public UserResponse checkTK(String tk, String pass) {
        return new UserResponse(tkdnRepo.checkTK(tk, pass));
    }
}
