/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.repositories.RamRepositry;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.services.IRamService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class RamServiceImpl implements IRamService {

    RamRepositry repo = new RamRepositry();

    @Override
    public boolean insert(RamRespone ram) {
        Ram r = new Ram();
        r.setMa(ram.getMa());
        r.setTen(ram.getTen());
        return repo.InsertRam(r);
    }

    @Override
    public boolean update(RamRespone ram) {
        Ram r = repo.SelectRamById(ram.getId());
        r.setTen(ram.getTen());
        r.setMa(ram.getMa());
        return repo.UpdateRam(r);
    }

    @Override
    public List<RamRespone> getlist() {
        List<Ram> rams = repo.SelectAllRam();
        return rams.stream().map(RamRespone::new).collect(Collectors.toList());
    }

}
