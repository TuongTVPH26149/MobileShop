/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;

/**
 *
 * @author LiamTrieu
 */
public class ChiTietSPRepository {

    private Session session = HibernatUtil.getSession();

    public List<ChiTietSP> selectALLChiTietSP() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ChiTietSP", ChiTietSP.class);
            if (query.getResultList() != null) {
                listChiTietSP = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public ChiTietSP SelectChiTietSPById(UUID Id) {
        ChiTietSP ctsp = new ChiTietSP();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ChiTietSP where Id = :Id", ChiTietSP.class);
            query.setParameter("Id", Id);
            if (query.getSingleResult() != null) {
                ctsp = (ChiTietSP) query.getSingleResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }

    public Boolean InsertChiTietSP(ChiTietSP ctsp) {
        try {
            session = HibernatUtil.getSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(ctsp);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateChiTietSP(ChiTietSP ctsp) {
        Transaction transaction = null;
        try {
            session = HibernatUtil.getSession();
            transaction = session.beginTransaction();
            ctsp.setLastModifiedDate(new Date());
            session.saveOrUpdate(ctsp);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ChiTietSP> getSP() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM ChiTietSP Where deleted = 0 and soLuong > 0", ChiTietSP.class);
            if (query.getResultList() != null) {
                listChiTietSP = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }
}
