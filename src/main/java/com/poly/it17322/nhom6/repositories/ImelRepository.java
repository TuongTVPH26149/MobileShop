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

    public List<Imel> selectALLImel() {
        List<Imel> listImel = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imel", Imel.class);
            listImel = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImel;
    }

    public Imel SelectImelById(UUID Id) {
        Imel imel = new Imel();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imel where Id = :Id", Imel.class);
            query.setParameter("Id", Id);
            imel = (Imel) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imel;
    }

    public Boolean InsertImel(Imel imel) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
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
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            imel.setLastModifiedDate(new Date());
            session.saveOrUpdate(imel);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
