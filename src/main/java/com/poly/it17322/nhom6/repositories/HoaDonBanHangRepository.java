/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author LiamTrieu
 */
public class HoaDonBanHangRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public KhachHang SelectKHByMa(String ma) {
        KhachHang kh = new KhachHang();
        try {
            Query query = session.createQuery("FROM KhachHang WHERE ma = :ma", KhachHang.class);
            query.setParameter("ma", ma);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
        }
        return kh;
    }
    public boolean checkMa(String ma) {
        HoaDon hd = new HoaDon();
        try {
            Query query = session.createQuery("FROM HoaDon WHERE ma = :ma", HoaDon.class);
            query.setParameter("ma", ma);
            hd = (HoaDon) query.getSingleResult();
            return false;
        } catch (NoResultException e) {
            return true;
        }
    }
}
