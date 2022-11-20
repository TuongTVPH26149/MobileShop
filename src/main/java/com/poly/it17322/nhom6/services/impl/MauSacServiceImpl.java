/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;


import com.poly.it17322.nhom6.domainmodels.MauSac;
import com.poly.it17322.nhom6.repositories.MauSacRepository;
import com.poly.it17322.nhom6.responses.MauSacRespone;
import com.poly.it17322.nhom6.services.IMauSacService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class MauSacServiceImpl implements IMauSacService {

    MauSacRepository repo = new MauSacRepository();

    @Override
    public List<MauSacRespone> getlist() {
        List<MauSac> mausacs = repo.SelectAllMauSac();
        return mausacs.stream().map(MauSacRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insert(MauSacRespone mausac) {
        MauSac m = new MauSac();
        m.setMa(mausac.getMa());
        m.setTen(mausac.getTen());
        return repo.InsertMauSac(m);
    }

    @Override
    public boolean update(MauSacRespone mausac) {
        MauSac m = repo.SelectMauSacById(mausac.getId());
        m.setMa(mausac.getMa());
        m.setTen(mausac.getTen());
        return repo.UpdateMauSac(m);
    }

}
