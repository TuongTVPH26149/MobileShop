/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.MauSac;
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
public class MauSacRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<MauSac> selectALLMauSac() {
        List<MauSac> listMauSac = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac", MauSac.class);
            listMauSac = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMauSac;
    }

    public MauSac SelectMauSacById(UUID Id) {
        MauSac mauSac = new MauSac();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac where Id = :Id", MauSac.class);
            query.setParameter("Id", Id);
            mauSac = (MauSac) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }

    public Boolean InsertMauSac(MauSac mauSac) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            session.save(mauSac);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean UpdateMauSac(MauSac mauSac) {
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Transaction tran = session.getTransaction();
            tran.begin();
            mauSac.setLastModifiedDate(new Date());
            session.saveOrUpdate(mauSac);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
