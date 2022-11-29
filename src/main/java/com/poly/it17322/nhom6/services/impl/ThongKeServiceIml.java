/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.HoaDonChiTietRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.responses.HoaDonThongKeRespone;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LiamTrieu
 */
public class ThongKeServiceIml {

    private HoaDonRepository hd = new HoaDonRepository();
    private HoaDonChiTietRepository hdct = new HoaDonChiTietRepository();
    private ChiTietSPRepository ctspr = new ChiTietSPRepository();

    public List<HoaDonThongKeRespone> getHDByDate(Date from, Date to) {
        List<HoaDon> lstHd = hd.getHDByDate(from, to);
        List<HoaDonThongKeRespone> lsthdtk = new ArrayList<>();
        for (HoaDon s : lstHd) {
            List<HoaDonChiTiet> lsthdct = hdct.SelectByHoaDonCTID(s.getId());
            HoaDonThongKeRespone hd = new HoaDonThongKeRespone(s, lsthdct);
            lsthdtk.add(hd);
        }
        return lsthdtk;
    }
}
