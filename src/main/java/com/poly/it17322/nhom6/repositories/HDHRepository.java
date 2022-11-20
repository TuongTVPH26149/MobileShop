/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HDH;
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
public class HDHRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<HDH> SelestAllHDH() {
        List<HDH> lstHDH = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HDH", HDH.class);
            lstHDH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHDH;
    }

    public HDH SelectHDHById(UUID id) {
        HDH hdh = new HDH();
        try {
            Query query = session.createQuery("FROM HDH WHERE id =:id", HDH.class);
            query.setParameter("id", id);
            hdh = (HDH) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdh;
    }

    public Boolean InsertHDH(HDH hdh) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hdh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateHDH(HDH hdh) {
        try {
            Transaction tran = session.getTransaction();
            tran.begin();
            hdh.setLastModifiedDate(new Date());
            session.saveOrUpdate(hdh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
