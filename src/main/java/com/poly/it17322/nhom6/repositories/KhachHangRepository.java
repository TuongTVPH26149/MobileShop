/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
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
public class KhachHangRepository {
    
    public List<KhachHang> SelectAllKhachHang(){
        List<KhachHang> lstKhachHang = new ArrayList<>();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM KhachHang", KhachHang.class);
            lstKhachHang = query.getResultList();
            return lstKhachHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public KhachHang SelectKhachHangById(UUID id){
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM KhachHang WHERE id =:id", KhachHang.class);
            query.setParameter("id", id);
            khachHang = (KhachHang) query.getSingleResult();
            return khachHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Boolean InsertKhachHang(KhachHang khachHang){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(khachHang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean UpdateKhachHang(KhachHang khachHang){
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Transaction tran = session.getTransaction();
            tran.begin();
            KhachHang tk = khachHang;
            tk.setLastModifiedDate(new Date());
            session.saveOrUpdate(khachHang);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
