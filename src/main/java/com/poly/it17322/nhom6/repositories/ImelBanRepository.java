/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.ImelBan;
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
public class ImelBanRepository {

    private Session session = HibernatUtil.getSession();

    public List<ImelBan> selectALLImelBan() {
        List<ImelBan> listImelBan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImelBan", ImelBan.class);
            listImelBan = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImelBan;
    }

    public ImelBan SelectImelBanById(UUID Id) {
        ImelBan imelBan = new ImelBan();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImelBan where Id = :Id", ImelBan.class);
            query.setParameter("Id", Id);
            imelBan = (ImelBan) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imelBan;
    }

    public ImelBan SelectImelBanByMa(String ma) {
        ImelBan imelBan = new ImelBan();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImelBan where Ma = :ma", ImelBan.class);
            query.setParameter("ma", ma);
            imelBan = (ImelBan) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imelBan;
    }

    public Boolean InsertImelBan(ImelBan imelBan) {
        try(Session session = HibernatUtil.getSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(imelBan);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateImelBan(ImelBan imelBan) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            imelBan.setLastModifiedDate(new Date());
            session.saveOrUpdate(imelBan);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ImelBan imelb) {
        Transaction transaction = null;
        try {
            session = HibernatUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(imelb);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public List<ImelBan> selectALLImelBan(UUID hdct) {
        List<ImelBan> listImelBan = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ImelBan WHERE IdHoaDonChiTiet = :hdct and TrangThai = 1", ImelBan.class);
            query.setParameter("hdct", hdct);
            listImelBan = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImelBan;
    }
}
