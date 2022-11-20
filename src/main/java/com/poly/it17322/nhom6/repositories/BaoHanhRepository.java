/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.BaoHanh;
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
public class BaoHanhRepository {
    public List<BaoHanh> SelectAllBaoHanh(){
        List<BaoHanh> listbh = new ArrayList<>();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM BaoHanh" , BaoHanh.class);
            listbh = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listbh;
    }
    public BaoHanh SelectBaoHanhById(UUID Id){
        BaoHanh bh = new BaoHanh();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM BaoHanh where Id = :Id" , BaoHanh.class);
            query.setParameter("Id", Id);
            bh = (BaoHanh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bh;
    }
    
    public Boolean InsertBaoHanh(BaoHanh bh){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(bh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean UpdateBaoHang(BaoHanh bh){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Transaction tran = session.getTransaction();
            tran.begin();
            bh.setLastModifiedDate(new Date());
            session.save(bh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
