/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LiamTrieu
 */
public class HoaDonRepository {
    public List<HoaDon> SelectHoaDon(){
        List<HoaDon> listHoaDon = new ArrayList<>();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM HoaDon " , HoaDon.class);
            listHoaDon = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    
    public HoaDon SelectAllHoaDonById(UUID Id){
        HoaDon hd = new HoaDon();
        try (Session session = HibernatUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM HoaDon where Id = :Id" , HoaDon.class);
            query.setParameter("Id", Id);
            hd = (HoaDon) query.getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }
    
      public boolean InsertHoaDon(HoaDon hd) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hd);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
       public boolean UpdateHoaDon(HoaDon hd) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            HoaDon tk = new HoaDon();
            tk.setLastModifiedDate(new Date());
            session.saveOrUpdate(hd);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
