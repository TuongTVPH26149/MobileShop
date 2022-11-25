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
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LiamTrieu
 */
public class BaoHanhRepository {
    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<BaoHanh> selectALLBaoHanh() {
        List<BaoHanh> listBaoHanh = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM BaoHanh", BaoHanh.class);
            listBaoHanh = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBaoHanh;
    }

    public BaoHanh SelectBaoHanhById(UUID Id) {
        BaoHanh baoHanh = new BaoHanh();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM BaoHanh where Id = :Id", BaoHanh.class);
            query.setParameter("Id", Id);
            baoHanh = (BaoHanh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baoHanh;
    }

    public Boolean InsertBaoHanh(BaoHanh baoHanh) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(baoHanh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateBaoHanh(BaoHanh baoHanh) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            baoHanh.setLastModifiedDate(new Date());
            session.saveOrUpdate(baoHanh);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
