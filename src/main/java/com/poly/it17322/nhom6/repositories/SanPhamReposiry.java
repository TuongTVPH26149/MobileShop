/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.SanPham;
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
public class SanPhamReposiry {
    
    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<SanPham> selectALLSanPham() {
        List<SanPham> listSanPham = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham", SanPham.class);
            listSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public SanPham SelectSanPhamById(UUID Id) {
        SanPham sanPham = new SanPham();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham where Id = :Id", SanPham.class);
            query.setParameter("Id", Id);
            sanPham = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean InsertSanPham(SanPham sanPham) {
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

    public Boolean UpdateSanPham(SanPham sanPham) {
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
}
