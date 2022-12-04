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

    private Session session = HibernatUtil.getSession();

    public List<Imel> SelectCBOImelById(UUID Idctsp) {
        List<Imel> lstimel = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imel where IdChiTietSP = :Idctsp", Imel.class);
            query.setParameter("Idctsp", Idctsp);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            }
            lstimel = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstimel;
    }

    public List<SanPham> timKiem(String ten) {
        List<SanPham> lstsprp = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM SanPham where Ten Like :ten", SanPham.class);
            query.setParameter("ten", "%" + ten + "%");
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            lstsprp = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstsprp;
    }

    public List<Imel> timKiemImel(String ma) {
        List<Imel> lstimel = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            Query query = session.createQuery("FROM Imel where Ma Like :ma", Imel.class);
            query.setParameter("ma", ma + "%");
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            lstimel = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstimel;
    }

    public List<ChiTietSP> selectALLChiTietSPXoa() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP WHERE Deleted = 1 ", ChiTietSP.class);
            
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listChiTietSP = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public List<ChiTietSP> selectALLChiTietSP() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP WHERE Deleted = 0 ", ChiTietSP.class);
            
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listChiTietSP = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public ChiTietSP SelectChiTietSPById(UUID Id) {
        ChiTietSP ctsp = new ChiTietSP();
        try {
            session = HibernatUtil.getSession();
            javax.persistence.Query query = session.createQuery("FROM ChiTietSP where id = :Id", ChiTietSP.class);
            query.setParameter("Id", Id);
            ctsp = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }
    public List<SanPhamSPRespone> TimKiemSP(String input) {
        List<SanPhamSPRespone> list = new ArrayList<>();
        try {
            Session session = HibernatUtil.getSession();
            String hql = "select new com.poly.it17322.nhom6.responses.SanPhamSPRespone "
                    + "(a.Id, a.sanPham.ten,a.pin.ten,a.manHinh.ten,a.cpu.ten,a.ram.ten,a.rom.ten,a.gia,a.soLuong,a.loaiHang) from ChiTietSP a where  a.sanPham.ten like CONCAT('%',:input,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("input", input);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        List<SanPhamSPRespone> lstsp = new SpCTSPRepository().TimKiemSP("aaa");
        System.out.println(lstsp);
    }
}
