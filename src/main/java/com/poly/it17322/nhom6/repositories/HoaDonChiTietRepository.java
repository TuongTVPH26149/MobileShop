/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LiamTrieu
 */
public class HoaDonChiTietRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<HoaDonChiTiet> selectALLHoaDonChiTiet() {
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            javax.persistence.Query query = session.createQuery("FROM HoaDonChiTiet", HoaDonChiTiet.class);
            listHoaDonChiTiet = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }
    
    public List<HoaDonChiTiet> SelectByHoaDonCTID(UUID Id) {
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            javax.persistence.Query query = session.createQuery("FROM HoaDonChiTiet where IdHoaDon = :Id", HoaDonChiTiet.class);
            query.setParameter("Id", Id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public HoaDonChiTiet SelectHoaDonChiTietById(UUID Id) {
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            javax.persistence.Query query = session.createQuery("FROM HoaDonChiTiet where Id = :Id", HoaDonChiTiet.class);
            query.setParameter("Id", Id);
            hdct = (HoaDonChiTiet) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdct;
    }

    public Boolean InsertHoaDonChiTiet(HoaDonChiTiet hdct) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(hdct);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateHoaDonChiTiet(HoaDonChiTiet hdct) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            hdct.setLastModifiedDate(new Date());
            session.saveOrUpdate(hdct);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
