/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.ChucVu;
import com.poly.it17322.nhom6.domainmodels.ChucVu;
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
public class ChucVuRepository {

    public List<ChucVu> SelectALLChucVu() {
        List<ChucVu> lstChucVu = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu", ChucVu.class);
            lstChucVu = query.getResultList();
        }
        return lstChucVu;
    }

    public ChucVu SelectChucVuById(UUID id) {
        ChucVu chucVu = new ChucVu();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu WHERE id = :id", ChucVu.class);
            query.setParameter("id", id);
            chucVu = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
        }
        return chucVu;
    }

    public boolean InsertChucVu(ChucVu chucVu) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(chucVu);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean UpdateChucVu(ChucVu chucVu) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            chucVu.setLastModifiedDate(new Date());
            session.saveOrUpdate(chucVu);
            tran.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
