/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.Imel;
import com.poly.it17322.nhom6.domainmodels.SanPham;
import com.poly.it17322.nhom6.responses.ImelSPRespone;
import com.poly.it17322.nhom6.responses.SanPhamSPRespone;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class SpCTSPRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<Imel> SelectCBOImelById(UUID Idctsp) {
        List<Imel> lstimel = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imel where IdChiTietSP = :Idctsp", Imel.class);
            query.setParameter("Idctsp", Idctsp);
            lstimel = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstimel;
    }

    public List<SanPham> timKiem(String ten) {
        List<SanPham> lstsprp = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham where Ten Like :ten", SanPham.class);
            query.setParameter("ten", "%" + ten + "%");
            lstsprp = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstsprp;
    }

    public List<Imel> timKiemImel(String ma) {
        List<Imel> lstimel = new ArrayList<>();
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imel where Ma Like :ma", Imel.class);
            query.setParameter("ma", "%" + ma + "%");
            lstimel = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstimel;
    }
        public List<ChiTietSP> selectALLChiTietSPXoa() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP WHERE Deleted = 1 " , ChiTietSP.class);
            listChiTietSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }
                public List<ChiTietSP> selectALLChiTietSP() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP WHERE Deleted = 0 " , ChiTietSP.class);
            listChiTietSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }
        public ChiTietSP SelectChiTietSPById(UUID Id) {
        ChiTietSP ctsp = new ChiTietSP();
        try( Session session = HibernatUtil.getFACTORY().openSession()){
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP where id = :Id", ChiTietSP.class);
            query.setParameter("Id", Id);
            ctsp = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }
}
