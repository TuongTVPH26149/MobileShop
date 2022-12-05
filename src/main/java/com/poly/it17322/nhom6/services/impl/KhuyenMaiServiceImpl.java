/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
import com.poly.it17322.nhom6.repositories.KhuyenMaiRepository;
import com.poly.it17322.nhom6.responses.KhuyenMaiResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author LiamTrieu
 */
public class KhuyenMaiServiceImpl {

    private KhuyenMaiRepository kmrepo = new KhuyenMaiRepository();

    public List<KhuyenMaiResponse> getList(int trangThai) {
        return kmrepo.selectALLKhuyenMai(trangThai).stream().map(KhuyenMaiResponse::new).collect(Collectors.toList());
    }

    public boolean createKM(KhuyenMaiResponse km) {
        KhuyenMai k = new KhuyenMai();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            k.setMa("KM" + sdf.format(new Date()));
            k.setTen(km.getTen());
            k.setGiaTri(km.getGiaTri());
            k.setLoaiKM(km.getLoai());
            k.setNgayBD(km.getNgayBD());
            k.setNgayKT(km.getNgayKT());
            k.setTrangThai(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kmrepo.InsertKhuyenMai(k);
    }
    
    public boolean updateKM(KhuyenMaiResponse km) {
        KhuyenMai k = kmrepo.SelectKhuyenMaiById(km.getId());
        try {
            k.setTen(km.getTen());
            k.setGiaTri(km.getGiaTri());
            k.setLoaiKM(km.getLoai());
            k.setNgayBD(km.getNgayBD());
            k.setNgayKT(km.getNgayKT());
            k.setTrangThai(km.getTrangThai());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kmrepo.UpdateKhuyenMai(k);
    }
    
    public boolean updateTTKM(int tt, UUID id) {
        KhuyenMai k = kmrepo.SelectKhuyenMaiById(id);
        try {
            k.setTrangThai(tt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kmrepo.UpdateKhuyenMai(k);
    }
}
