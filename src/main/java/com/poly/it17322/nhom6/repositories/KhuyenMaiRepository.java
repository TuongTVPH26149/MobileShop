/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
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
public class KhuyenMaiRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<KhuyenMai> selectALLKhuyenMai() {
        List<KhuyenMai> listKhuyenMai = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhuyenMai", KhuyenMai.class);
            listKhuyenMai = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhuyenMai;
    }

    public KhuyenMai SelectKhuyenMaiById(UUID Id) {
        KhuyenMai sanPham = new KhuyenMai();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhuyenMai where Id = :Id", KhuyenMai.class);
            query.setParameter("Id", Id);
            sanPham = (KhuyenMai) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean InsertKhuyenMai(KhuyenMai sanPham) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(sanPham);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateKhuyenMai(KhuyenMai sanPham) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            sanPham.setLastModifiedDate(new Date());
            session.saveOrUpdate(sanPham);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        List<KhuyenMai> lists = new KhuyenMaiRepository().selectALLKhuyenMai();
        for (KhuyenMai km : lists) {
            System.out.println(km.toString());
        }
    }

    public List<KhuyenMai> getByCodeAndCreateDate(String ma, Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<KhuyenMai> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
