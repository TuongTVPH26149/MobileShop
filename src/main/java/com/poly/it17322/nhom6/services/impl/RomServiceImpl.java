/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.repositories.RamRepositry;
import com.poly.it17322.nhom6.repositories.RomRepository;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.responses.RomRespone;
import com.poly.it17322.nhom6.services.IRomService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class RomServiceImpl implements IRomService {

    RomRepository repo = new RomRepository();

    @Override
    public List<RomRespone> getlist() {
        List<Rom> roms = repo.selectALLRom();
        return roms.stream().map(RomRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insert(RomRespone ram) {
        Rom r = new Rom();
        r.setMa(ram.getMa());
        r.setTen(ram.getTen());
        return repo.InsertRom(r);
    }

    @Override
    public boolean update(RomRespone rom) {
        Rom r = repo.SelectRomById(rom.getId());
        r.setMa(rom.getMa());
        r.setTen(rom.getTen());
        return repo.UpdateRom(r);
    }

}
