/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HDH;
import com.poly.it17322.nhom6.domainmodels.Hang;
import com.poly.it17322.nhom6.repositories.HDHRepository;
import com.poly.it17322.nhom6.responses.HDHRespone;
import com.poly.it17322.nhom6.services.IHDHService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class HDHServiceImpl implements IHDHService {

    HDHRepository repo = new HDHRepository();

    @Override
    public List<HDHRespone> getlist() {
        List<HDH> hdhs = repo.SelestAllHDH();
        return hdhs.stream().map(HDHRespone::new).collect(Collectors.toList());
    }


    @Override
    public boolean insert(HDHRespone hdh) {
        HDH h = new HDH();
        h.setMa(hdh.getMa());
        h.setTen(hdh.getTen());
        return repo.InsertHDH(h);
    }

    @Override
    public boolean update(HDHRespone hdh) {
                HDH h = repo.SelectHDHById(hdh.getId());
        h.setTen(hdh.getTen());
        h.setMa(hdh.getMa());
        return repo.UpdateHDH(h);
    }

}
