/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.repositories;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import org.hibernate.Session;
import javax.persistence.Query;


/**
 *
 * @author ACER
 */
public class TimKiemKH extends KhachHangRepository{
    private Session session = HibernatUtil.getFACTORY().openSession();
    public KhachHang timkiem(String sdt){
        Query query = session.createQuery("FROM KhacHang where Sdt like N'% := sdt"  );
    }
}
