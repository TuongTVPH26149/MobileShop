/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Imel;
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
public class ImelRepository {

    private Session session = HibernatUtil.getSession();

    public List<Imel> selectALLImel() {
        List<Imel> listImel = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imel", Imel.class);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listImel = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImel;
    }

    public Imel SelectImelById(UUID Id) {
        Imel imel = new Imel();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imel where Id = :Id", Imel.class);
            query.setParameter("Id", Id);
            imel = (Imel) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imel;
    }

    public Boolean InsertImel(Imel imel) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(imel);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateImel(Imel imel) {
        Transaction tran = null;
        try {
            session = HibernatUtil.getSession();
            tran = session.beginTransaction();
            imel.setLastModifiedDate(new Date());
            session.saveOrUpdate(imel);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Imel> Selectmamel(UUID ctSP) {
        List<Imel> lstImel = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imel WHERE IdChiTietSP = :ctsp and TrangThai = 1", Imel.class);
            query.setParameter("ctsp", ctSP);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                lstImel = query.getResultList();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return lstImel;
    }

    public Imel SelectImelBanByMa(String ma) {
        Imel imel = new Imel();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM Imel where ma = :ma", Imel.class);
            query.setParameter("ma", ma);
            imel = (Imel) query.getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imel;
    }
}
