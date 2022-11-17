/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
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
public class TaiKhoanRepository {

    public List<TaiKhoan> SelectALLTaiKhoan() {
        List<TaiKhoan> lstTaiKhoan = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TaiKhoan", TaiKhoan.class);
            lstTaiKhoan = query.getResultList();
        } catch (Exception e) {
        }
        return lstTaiKhoan;
    }

    public TaiKhoan SelectTaiKhoanById(UUID id) {
        TaiKhoan taiKhoan = new TaiKhoan();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TaiKhoan WHERE id = :id", TaiKhoan.class);
            query.setParameter("id", id);
            taiKhoan = (TaiKhoan) query.getSingleResult();
        } catch (Exception e) {
        }
        return taiKhoan;
    }

    public boolean InsertTaiKhoan(TaiKhoan taiKhoan) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(taiKhoan);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateTaiKhoan(TaiKhoan taiKhoan) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            TaiKhoan tk = taiKhoan;
            tk.setLastModifiedDate(new Date());
            session.saveOrUpdate(taiKhoan);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
