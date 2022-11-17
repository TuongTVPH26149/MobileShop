/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.application;

import com.poly.it17322.nhom6.utilities.HibernatUtil;
import com.poly.it17322.nhom6.views.FrmDangNhap;
import org.hibernate.Session;


/**
 *
 * @author LiamTrieu
 */
public class application {
    public static void main(String[] args) {
        Session session = HibernatUtil.getFACTORY().openSession();
        session.close();
        new FrmDangNhap().setVisible(true);
    }
}
