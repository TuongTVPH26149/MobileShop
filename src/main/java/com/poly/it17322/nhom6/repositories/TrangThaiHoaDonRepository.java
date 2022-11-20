/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.TrangThaiHoaDon;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LiamTrieu
 */
public class TrangThaiHoaDonRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<TrangThaiHoaDon> SelectALLTrangThaiHoaDon() {
        List<TrangThaiHoaDon> lstTrangThaiHoaDon = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM TrangThaiHoaDon", TrangThaiHoaDon.class);
            lstTrangThaiHoaDon = query.getResultList();
        } catch (Exception e) {
        }
        return lstTrangThaiHoaDon;
    }

    public TrangThaiHoaDon SelectTrangThaiHoaDonById(UUID id) {
        TrangThaiHoaDon trangThaihd = new TrangThaiHoaDon();
        try {
            Query query = session.createQuery("FROM TrangThaiHoaDon WHERE id = :id", TrangThaiHoaDon.class);
            query.setParameter("id", id);
            trangThaihd = (TrangThaiHoaDon) query.getSingleResult();
        } catch (Exception e) {
        }
        return trangThaihd;
    }

    public boolean InsertTrangThaiHoaDon(TrangThaiHoaDon trangThaihd) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(trangThaihd);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateTrangThaiHoaDon(TrangThaiHoaDon trangThaihd) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            trangThaihd.setLastModifiedDate(new Date());
            session.saveOrUpdate(trangThaihd);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
