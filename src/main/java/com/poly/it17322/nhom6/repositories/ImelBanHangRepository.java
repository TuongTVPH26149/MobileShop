/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Imel;
import com.poly.it17322.nhom6.domainmodels.ImelBan;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author LiamTrieu
 */
public class ImelBanHangRepository extends ImelRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<Imel> Selectmamel(UUID ctSP) {
        List<Imel> lstImel = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM Imel WHERE IdChiTietSP = :ctsp and TrangThai = 1", Imel.class);
            query.setParameter("ctsp", ctSP);
            lstImel = query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return lstImel;
    }

    public Imel SelectImelBanByMa(String ma) {
        Imel imel = new Imel();
        try(Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imel where ma = :ma", Imel.class);
            query.setParameter("ma", ma);
            imel = (Imel) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imel;
    }
    
    public List<ImelBan> selectALLImelBan(UUID hdct) {
        List<ImelBan> listImelBan = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM ImelBan WHERE IdHoaDonChiTiet = :hdct and TrangThai = 1", ImelBan.class);
            query.setParameter("hdct", hdct);
            listImelBan = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listImelBan;
    }
}
