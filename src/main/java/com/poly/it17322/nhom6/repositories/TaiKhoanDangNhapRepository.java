/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.UUID;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author LiamTrieu
 */
public class TaiKhoanDangNhapRepository extends TaiKhoanRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public TaiKhoan checkTK(String tk, String mk) {
        Query query = session.createQuery("FROM TaiKhoan WHERE email = :tk and matKhau = :mk");
        query.setParameter("tk", tk);
        query.setParameter("mk", mk);
        try {
            return (TaiKhoan) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public UUID checkEmail(String mail) {
        Query query = session.createQuery("FROM TaiKhoan WHERE email = :mail");
        query.setParameter("mail", mail);
        TaiKhoan result = new TaiKhoan();
        try {
            return ((TaiKhoan) query.getSingleResult()).getId();
        } catch (NoResultException e) {
            return null;
        }
    }
}