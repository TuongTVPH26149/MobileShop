/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LiamTrieu
 */
public class HoaDonChiTietRepository {
    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<HoaDonChiTiet> SelectHoaDonChiTiet() {
        List<HoaDonChiTiet> listCTHoaDon = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HoaDonChiTiet ", HoaDonChiTiet.class);
            listCTHoaDon = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTHoaDon;
    }

    public List<HoaDonChiTiet> SelectAllHoaDonById(UUID IdHoaDon, UUID IdChiTietSP) {
        List<HoaDonChiTiet> lsthdct = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HoaDonChiTiet where IdHoaDon = :IdHoaDon and IdChiTietSP = :IdChiTietSP", HoaDonChiTiet.class);
            query.setParameter("IdHoaDon", IdHoaDon);
            query.setParameter("IdChiTietSP", IdChiTietSP);
            lsthdct = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return lsthdct;
    }

    public boolean InsertHoaDon(HoaDonChiTiet hdct) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hdct);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateChiTietSP(HoaDonChiTiet hdct) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            hdct.setLastModifiedDate(new Date());
            session.saveOrUpdate(hdct);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
}
