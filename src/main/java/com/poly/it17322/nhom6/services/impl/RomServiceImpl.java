/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.repositories.RomRepository;
import com.poly.it17322.nhom6.services.IRomService;
import java.util.List;

/**
 *
 * @author admin
 */
public class RomServiceImpl implements IRomService {

    RomRepository repo = new RomRepository();

    @Override
    public List<Rom> getlist() {
        return repo.selectALLRom();
    }

    @Override
    public boolean insert(Rom rom) {
        return repo.InsertRom(rom);
    }

    @Override
    public boolean update(Rom rom) {
        return repo.UpdateRom(rom);
    }

}
