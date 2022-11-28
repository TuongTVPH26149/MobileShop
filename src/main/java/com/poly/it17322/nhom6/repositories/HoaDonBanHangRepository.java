/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
    public boolean checkHDCT(UUID idhd, UUID idsp) {
        HoaDonChiTiet hd = new HoaDonChiTiet();
        try {
            Query query = session.createQuery("FROM HoaDonChiTiet WHERE IdHoaDon = :idhd and IdChiTietSP = :idsp", HoaDonChiTiet.class);
            query.setParameter("idhd", idhd);
            query.setParameter("idsp", idsp);
            hd = (HoaDonChiTiet) query.getSingleResult();
            return false;
        } catch (NoResultException e) {
            return true;
        }
    }
    
    public List<HoaDonChiTiet> getHDCTbyIdHDIdSP(UUID idhd, UUID idsp) {
        List<HoaDonChiTiet> hds = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HoaDonChiTiet WHERE IdHoaDon = :idhd and IdChiTietSP = :idsp", HoaDonChiTiet.class);
            query.setParameter("idhd", idhd);
            query.setParameter("idsp", idsp);
            hds = query.getResultList();
            return hds;
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }
}
