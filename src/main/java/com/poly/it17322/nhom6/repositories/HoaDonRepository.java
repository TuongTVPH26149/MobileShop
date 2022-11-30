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

    private Session session = HibernatUtil.getSession();

    public List<HoaDon> selectALLHoaDon() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDon", HoaDon.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listHoaDon = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public HoaDon SelectHoaDonById(UUID Id) {
        HoaDon hd = new HoaDon();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM HoaDon where Id = :Id", HoaDon.class);
            query.setParameter("Id", Id);
            hd = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    public Boolean InsertHoaDon(HoaDon hd) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hd);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateHoaDon(HoaDon hd) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            hd.setLastModifiedDate(new Date());
            session.saveOrUpdate(hd);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<HoaDon> getByCodeAndCreateDate(String ma, Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try {
            if (from != null && to != null) {
                Query query = session.createQuery("FROM HoaDon where ma like :ma and NgayTao >= :from and NgayTao <= :to", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                query.setParameter("from", from);
                query.setParameter("to", to);
                if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                    list = query.getResultList();
                }
            } else {
                Query query = session.createQuery("FROM HoaDon where ma like :ma", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                    list = query.getResultList();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDon> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try {
            if (from != null && to != null) {
                Query query = session.createQuery("FROM HoaDon where ma like :ma and lastModifiedDate >= :from and lastModifiedDate <= :to", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                query.setParameter("from", from);
                query.setParameter("to", to);
                if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                    list = query.getResultList();
                }
            } else {
                Query query = session.createQuery("FROM HoaDon where ma like :ma", HoaDon.class);
                query.setParameter("ma", "%" + ma + "%");
                if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                    list = query.getResultList();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDon> getHD() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HoaDon where trangThai in (0,1,2) order by ma desc", HoaDon.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listHoaDon = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public List<HoaDon> getHDByDate(Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HoaDon where ngayThanhToan >= :from and ngayThanhToan <= :to and TrangThai = 4", HoaDon.class);
            query.setParameter("from", from);
            query.setParameter("to", to);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                list = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
