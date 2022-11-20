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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LiamTrieu
 */
public class ImelRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<Imel> SelectALlImel() {
        List<Imel> lstImel = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM Imel", Imel.class);
            lstImel = query.getResultList();
        } catch (Exception e) {
        }
        return lstImel;
    }

    public Imel SelectImelId(UUID id) {
        Imel imel = new Imel();
        try  {
            Query query = session.createQuery("FROM Imel WHERE id = :id", Imel.class);
            query.setParameter("id", id);
            imel = (Imel) query.getSingleResult();

        } catch (Exception e) {
        }
        return imel;
    }

    public boolean InsertImel(Imel imel) {
        try  {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(imel);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateImel(Imel imel) {
        try  {
            Transaction tran = session.getTransaction();
            tran.begin();
            imel.setLastModifiedDate(new Date());
            session.saveOrUpdate(imel);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
