/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.repositories.RamRepositry;
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
    public boolean insert(Ram ram) {
        return repo.InsertRam(ram);
    }

    @Override
    public boolean update(Ram ram) {
        repo.SelectRamById(ram.getId());
//        ram.setTen(ram.getTen());
//        ram.setMa(ram.getMa());
        return repo.UpdateRam(ram);
    }

    @Override
    public List<Ram> getlist() {
        return repo.SelectAllRam();

    }

}
