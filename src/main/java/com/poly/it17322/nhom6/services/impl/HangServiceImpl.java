/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.Hang;
import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.repositories.Hangrepository;
import com.poly.it17322.nhom6.repositories.RomRepository;
import com.poly.it17322.nhom6.responses.HangSPRespone;
import com.poly.it17322.nhom6.responses.RomRespone;
import com.poly.it17322.nhom6.services.IHangService;
import com.poly.it17322.nhom6.services.IRomService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class HangServiceImpl implements IHangService {

    Hangrepository repo = new Hangrepository();

    @Override
    public List<HangSPRespone> getlist() {
        List<Hang> hangs = repo.SelestAllHang();
        return hangs.stream().map(HangSPRespone::new).collect(Collectors.toList());
    }


    @Override
    public boolean insert(HangSPRespone hang) {
        Hang h = new Hang();
        h.setMa(hang.getMa());
        h.setTen(hang.getTen());
        return repo.InsertHang(h);
    }

    @Override
    public boolean update(HangSPRespone hang) {
                Hang h = repo.SelectHangById(hang.getId());
        h.setTen(hang.getTen());
        h.setMa(hang.getMa());
        return repo.UpdateHang(h);
    }

}
