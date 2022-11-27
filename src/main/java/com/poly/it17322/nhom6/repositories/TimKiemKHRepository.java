/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.responses.KhachHangResponse;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import javax.persistence.Query;


/**
 *
 * @author ACER
 */
public class TimKiemKHRepository extends KhachHangRepository{
    private Session session = HibernatUtil.getFACTORY().openSession();
    public List<KhachHang> timkiem(String Sdt){
        List<KhachHang> lstKH = new ArrayList<>();
        try {
             Query query = session.createQuery("FROM KhachHang where Sdt LIKE '%:Sdt%'", KhachHang.class );
             query.setParameter("Sdt", Sdt);
             lstKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return lstKH;
    }
    
    public List<KhachHang> LocKH(int GioiTinh){
        List<KhachHang> lstKH = new ArrayList<>();
        try {
             Query query = session.createQuery("FROM KhachHang where GioiTinh = :GioiTinh'", KhachHang.class );
             query.setParameter("GioiTinh", GioiTinh);
             lstKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return lstKH;
    }
}
