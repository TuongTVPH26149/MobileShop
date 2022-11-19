/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.application;

import com.poly.it17322.nhom6.responses.UserResponse;
import com.poly.it17322.nhom6.views.FrmDangNhap;
import com.poly.it17322.nhom6.views.FrmMainView;


/**
 *
 * @author LiamTrieu
 */
public class application {
    public static void main(String[] args) {
        UserResponse us = new UserResponse();
        us.setTrangThai("TT01");
        us.setChucVu("QL");
        new FrmMainView(us).setVisible(true);
                
    }
}
