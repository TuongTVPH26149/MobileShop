/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

<<<<<<< HEAD
import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

=======
>>>>>>> 74db302df430c4384d56ea96e03bc6c015da1722
/**
 *
 * @author LiamTrieu
 */
public class ChiTietSPRepository {
<<<<<<< HEAD

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<ChiTietSP> SelectCTSanPham() {
        List<ChiTietSP> listCTSanPham = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM ChiTietSP ", ChiTietSP.class);
            listCTSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSanPham;
    }

    public ChiTietSP SelectAllCTSanPhamById(UUID id) {
        ChiTietSP hdct = new ChiTietSP();
        try {
            Query query = session.createQuery("FROM ChiTietSP where id = :id", ChiTietSP.class);
            query.setParameter("id", id);
            hdct = (ChiTietSP) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdct;
    }

    public boolean InsertCTSP(ChiTietSP ctsp) {
        try {
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
        try {
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
=======
    
>>>>>>> 74db302df430c4384d56ea96e03bc6c015da1722
}
