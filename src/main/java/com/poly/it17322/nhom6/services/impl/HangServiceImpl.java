/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;


import com.poly.it17322.nhom6.domainmodels.Hang;
import com.poly.it17322.nhom6.repositories.Hangrepository;
import com.poly.it17322.nhom6.responses.HangRespone;
import com.poly.it17322.nhom6.services.IHangService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class HangServiceImpl implements IHangService {

    Hangrepository repo = new Hangrepository();

    @Override
    public List<HangRespone> getlist() {
        List<Hang> hangs = repo.SelestAllHang();
        return hangs.stream().map(HangRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insert(HangRespone hang) {
        Hang h = new Hang();
        h.setMa(hang.getMa());
        h.setTen(hang.getTen());
        return repo.InsertHang(h);
    }

    @Override
    public boolean update(HangRespone hang) {
        Hang h = repo.SelectHangById(hang.getId());
        h.setMa(hang.getMa());
        h.setTen(hang.getTen());
        return repo.UpdateHang(h);
    }

}
