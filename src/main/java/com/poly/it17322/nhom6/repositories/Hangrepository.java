/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Hang;
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
public class Hangrepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<Hang> SelestAllHang() {
        List<Hang> lstHang = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM Hang", Hang.class);
            lstHang = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHang;
    }

    public Hang SelectHangById(UUID id) {
        Hang hang = new Hang();
        try {
            Query query = session.createQuery("FROM Hang WHERE id =:id", Hang.class);
            query.setParameter("id", id);
            hang = (Hang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hang;
    }

    public Boolean InsertHang(Hang hang) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateHang(Hang hang) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            hang.setLastModifiedDate(new Date());
            session.saveOrUpdate(hang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
