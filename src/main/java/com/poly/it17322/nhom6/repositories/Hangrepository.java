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
    
    public List<Hang> SelestAllHang(){
        List<Hang> lstHang = new ArrayList<>();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Hang", Hang.class);
            lstHang = query.getResultList();
            return lstHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Hang SelectHangById(UUID id){
        Hang hang = new Hang();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Hang WHERE id =:id", Hang.class);
            query.setParameter("id", id);
            hang = (Hang) query.getSingleResult();
            return hang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Boolean InsertHang(Hang hang){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
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
    
    public Boolean UpdateHang(Hang hang){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Transaction tran = session.getTransaction();
            tran.begin();
            Hang tk = hang;
            tk.setLastModifiedDate(new Date());
            session.saveOrUpdate(hang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
