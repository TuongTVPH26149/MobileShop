/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
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
public class HoaDonRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<HoaDon> SelectALLHoaDon() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HoaDon", HoaDon.class);
            listHoaDon = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public HoaDon SelectAllHoaDonById(UUID Id) {
        HoaDon hd = new HoaDon();
        try {
            Query query = session.createQuery("FROM HoaDon where Id = :Id", HoaDon.class);
            query.setParameter("Id", Id);
            hd = (HoaDon) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }
     public List<HoaDon> getByCodeAndCreateDate(String ma, Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            if (from != null && to != null) {
                Query query = session.createQuery("FROM HoaDon where ma like :ma and CreatedDate >= :from and CreatedDate <= :to", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                query.setParameter("from", from);
                query.setParameter("to", to);
                list = query.getResultList();
            } else {
                Query query = session.createQuery("FROM HoaDon where ma like :ma", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                list = query.getResultList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        public List<HoaDon> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            if (from != null && to != null) {
                Query query = session.createQuery("FROM HoaDon where ma like :ma and lastModifiedDate >= :from and lastModifiedDate <= :to", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                query.setParameter("from", from);
                query.setParameter("to", to);
                list = query.getResultList();
            } else {
                Query query = session.createQuery("FROM HoaDon where ma like :ma", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                list = query.getResultList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean InsertHoaDon(HoaDon hd) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hd);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateHoaDon(HoaDon hd) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            hd.setLastModifiedDate(new Date());
            session.saveOrUpdate(hd);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
