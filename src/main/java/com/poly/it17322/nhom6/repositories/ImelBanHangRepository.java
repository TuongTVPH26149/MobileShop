/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.Imel;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author LiamTrieu
 */
public class ImelBanHangRepository extends ImelRepository {

    public List<Imel> Selectmamel(String ma, UUID ctSP) {
        List<Imel> lstImel = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imel WHERE Ma = :ma and IdChiTietSP = :ctsp", Imel.class);
            query.setParameter("ma", ma);
            query.setParameter("ctsp", ctSP);
            lstImel = query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return lstImel;
    }
}
