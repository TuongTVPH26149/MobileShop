/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
import com.poly.it17322.nhom6.responses.KhuyenMaiRespone;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LiamTrieu
 */
public class KhuyenMaiRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<KhuyenMai> SelectALlKhuyenMai() {
        List<KhuyenMai> lstKhuyenMai = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM KhuyenMai", KhuyenMai.class);
            lstKhuyenMai = query.getResultList();
        } catch (Exception e) {
        }
        return lstKhuyenMai;
    }

    public KhuyenMai SelectKhuyenMaiId(UUID id) {
        KhuyenMai khuyenmai = new KhuyenMai();
        try {
            Query query = session.createQuery("FROM KhuyenMai WHERE id = :id", KhuyenMai.class);
            query.setParameter("id", id);
            khuyenmai = (KhuyenMai) query.getSingleResult();

        } catch (Exception e) {
        }
        return khuyenmai;
    }

    public boolean InsertKhuyeMai(KhuyenMai khuyenmai) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(khuyenmai);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateKhuyenMai(KhuyenMai khuyenmai) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            khuyenmai.setLastModifiedDate(new Date());
            session.saveOrUpdate(khuyenmai);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public static void main(String[] args) {
        List<KhuyenMai> lists = new KhuyenMaiRepository().SelectALlKhuyenMai();
        for (KhuyenMai km : lists) {
            System.out.println(km.toString());
        }
    }

    public List<KhuyenMai> getByCodeAndCreateDate(String ma, Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<KhuyenMai> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
