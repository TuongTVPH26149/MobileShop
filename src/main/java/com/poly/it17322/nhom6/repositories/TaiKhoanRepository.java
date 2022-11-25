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

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<TaiKhoan> selectALLTaiKhoan() {
        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TaiKhoan", TaiKhoan.class);
            listTaiKhoan = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }

    public TaiKhoan SelectTaiKhoanById(UUID Id) {
        TaiKhoan tk = new TaiKhoan();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TaiKhoan where Id = :Id", TaiKhoan.class);
            query.setParameter("Id", Id);
            tk = (TaiKhoan) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    public Boolean InsertTaiKhoan(TaiKhoan tk) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(tk);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateTaiKhoan(TaiKhoan tk) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            tk.setLastModifiedDate(new Date());
            session.saveOrUpdate(tk);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
