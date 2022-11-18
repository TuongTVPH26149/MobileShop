/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.HoaDon;
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
public class ChiTietSPRepository {
    public List<ChiTietSP> SelectCTSanPham(){
        List<ChiTietSP> listCTSanPham = new ArrayList<>();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM ChiTietSP " , HoaDon.class);
            listCTSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSanPham;
    }
    
    public ChiTietSP SelectAllCTSanPhamById(UUID Id){
        ChiTietSP hdct = new ChiTietSP();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM ChiTietSP where Id = :Id" , ChiTietSP.class);
            query.setParameter("Id", Id);
            hdct =  (ChiTietSP) query.getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdct;
    }
    
      public boolean InsertCTSP(ChiTietSP ctsp) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(ctsp);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
       public boolean UpdateChiTietSP(ChiTietSP ctsp) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            ctsp.setLastModifiedDate(new Date());
            session.saveOrUpdate(ctsp);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
               public static void main(String[] args) {
        new ChiTietSPRepository().SelectCTSanPham().forEach(s -> System.out.println(s.toString()));
        
    }
}
