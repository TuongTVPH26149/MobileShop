/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.TrangThaiTaiKhoan;
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
public class TrangThaiTaiKhoanRepository {

    public List<TrangThaiTaiKhoan> SelectALLTrangThaiTaiKhoan() {
        List<TrangThaiTaiKhoan> lstTrangThaiTaiKhoan = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TrangThaiTaiKhoan", TrangThaiTaiKhoan.class);
            lstTrangThaiTaiKhoan = query.getResultList();
        }
        return lstTrangThaiTaiKhoan;
    }
    
    
    public TrangThaiTaiKhoan SelectTrangThaiTaiKhoanById(UUID id) {
        TrangThaiTaiKhoan trangThaiTk = new TrangThaiTaiKhoan();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TrangThaiTaiKhoan WHERE id = :id", TrangThaiTaiKhoan.class);
            query.setParameter("id", id);
            trangThaiTk = (TrangThaiTaiKhoan) query.getSingleResult();
        } catch (Exception e) {
        }
        return trangThaiTk;
    }

    public boolean InsertTrangThaiTaiKhoan(TrangThaiTaiKhoan trangThaiTk) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(trangThaiTk);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateTrangThaiTaiKhoan(TrangThaiTaiKhoan trangThaiTk) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            TrangThaiTaiKhoan tk = trangThaiTk;
            tk.setLastModifiedDate(new Date());
            session.saveOrUpdate(trangThaiTk);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
