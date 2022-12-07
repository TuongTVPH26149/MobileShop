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
import com.poly.it17322.nhom6.responses.top5sprespone;
import com.poly.it17322.nhom6.utilities.HibernatUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

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

    public List<top5sprespone> getTop(Date from, Date to) {
        List<top5sprespone> lstTop5 = new ArrayList<>();
        try {
            Session session = HibernatUtil.getSession();
            NativeQuery query = session.createNativeQuery("Select B.Ten as ten, C.Ten as mausac, D.Ten as ram,E.Ten as rom,\n"
                    + "SUM(G.SoLuong) as soluong, SUM(H.TongTien) as tongtien\n"
                    + "From ChiTietSP A\n"
                    + "join SanPham B on A.IdSP = B.Id\n"
                    + "join MauSac C on C.Id = A.IdMauSac\n"
                    + "join Ram D on D.Id = A.IdRam\n"
                    + "join Rom E on E.Id = A.IdRom\n"
                    + "join HoaDonChiTiet G on G.IdChiTietSP = A.Id\n"
                    + "join HoaDon H on G.IdHoaDon = H.Id\n"
                    + "where ngayThanhToan >= :from and ngayThanhToan <= :to and H.TrangThai in (3,4)\n"
                    + "Group by B.Ten, C.Ten, D.Ten,E.Ten\n"
                    + "order by SUM(G.SoLuong) desc");
            query.setParameter("from", from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            query.setParameter("to", to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            List<Object[]> lsto = query.getResultList();
            for (Object[] o : lsto) {
                String ten = o[0].toString();
                String mausac = o[1].toString();
                String ram = o[2].toString();
                String rom = o[3].toString();
                String sl = o[4].toString();
                String tongTien = o[5].toString();
                lstTop5.add(new top5sprespone(ten, sl, tongTien));
            }
        } catch (Exception e) {
        }

        return lstTop5;
    }

    public BigDecimal getWeekChar(Date to) {
        List<HoaDon> lst = hd.getHDByDate(to, to);
        BigDecimal b = new BigDecimal(0);
        for (HoaDon s : lst) {
            try {
                b = b.add(s.getTongTien());
            } catch (Exception e) {
            }
        }
        return b;
    }
    
    public BigDecimal getYearChar(Date now, Date to) {
        List<HoaDon> lst = hd.getHDByDate(now, to);
        BigDecimal b = new BigDecimal(0);
        for (HoaDon s : lst) {
            try {
                b = b.add(s.getTongTien());
            } catch (Exception e) {
            }
        }
        return b;
    }
}
