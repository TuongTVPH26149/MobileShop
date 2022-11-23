/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.CPU;
import com.poly.it17322.nhom6.domainmodels.HDH;
import com.poly.it17322.nhom6.domainmodels.Hang;
import com.poly.it17322.nhom6.domainmodels.MauSac;
import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.repositories.CPURepository;
import com.poly.it17322.nhom6.repositories.HDHRepository;
import com.poly.it17322.nhom6.repositories.Hangrepository;
import com.poly.it17322.nhom6.repositories.MauSacRepository;
import com.poly.it17322.nhom6.repositories.RamRepositry;
import com.poly.it17322.nhom6.repositories.RomRepository;
import com.poly.it17322.nhom6.responses.CPURespone;
import com.poly.it17322.nhom6.responses.HDHRespone;
import com.poly.it17322.nhom6.responses.HangRespone;
import com.poly.it17322.nhom6.responses.MauSacRespone;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.responses.RomRespone;
import com.poly.it17322.nhom6.services.ISanPhamChiTietService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class SanPhamChiTietServiceImpl implements ISanPhamChiTietService {

    Hangrepository hangrepo = new Hangrepository();
    RomRepository romrepo = new RomRepository();
    RamRepositry ramrepo = new RamRepositry();
    MauSacRepository mausacrepo = new MauSacRepository();
    HDHRepository hdhrepo = new HDHRepository();
    CPURepository cpurepo = new CPURepository();

    @Override
    public List<HangRespone> getlistHang() {
        List<Hang> hangs = hangrepo.SelestAllHang();
        return hangs.stream().map(HangRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertHang(HangRespone hang) {
        Hang h = new Hang();
        h.setMa(hang.getMa());
        h.setTen(hang.getTen());
        return hangrepo.InsertHang(h);
    }

    @Override
    public boolean updateHang(HangRespone hang) {
        Hang h = hangrepo.SelectHangById(hang.getId());
        h.setMa(hang.getMa());
        h.setTen(hang.getTen());
        return hangrepo.UpdateHang(h);
    }

    @Override
    public List<RomRespone> getlistRom() {
        List<Rom> roms = romrepo.selectALLRom();
        return roms.stream().map(RomRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertRom(RomRespone rom) {
        Rom r = new Rom();
        r.setMa(rom.getMa());
        r.setTen(rom.getTen());
        return romrepo.InsertRom(r);
    }

    @Override
    public boolean updateRom(RomRespone rom) {
        Rom r = romrepo.SelectRomById(rom.getId());
        r.setMa(rom.getMa());
        r.setTen(rom.getTen());
        return romrepo.UpdateRom(r);
    }

    @Override
    public List<RamRespone> getlistRam() {
        List<Ram> rams = ramrepo.SelectAllRam();
        return rams.stream().map(RamRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertRam(RamRespone ram) {
        Ram r = new Ram();
        r.setMa(ram.getMa());
        r.setTen(ram.getTen());
        return ramrepo.InsertRam(r);
    }

    @Override
    public boolean updateRam(RamRespone ram) {
        Ram r = ramrepo.SelectRamById(ram.getId());
        r.setMa(ram.getMa());
        r.setTen(ram.getTen());
        return ramrepo.UpdateRam(r);
    }

    @Override
    public List<MauSacRespone> getlistMauSac() {
        List<MauSac> mausacs = mausacrepo.SelectAllMauSac();
        return mausacs.stream().map(MauSacRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertMauSac(MauSacRespone ms) {
        MauSac m = new MauSac();
        m.setMa(ms.getMa());
        m.setTen(ms.getTen());
        return mausacrepo.InsertMauSac(m);
    }

    @Override
    public boolean updateMauSac(MauSacRespone ms) {
        MauSac m = mausacrepo.SelectMauSacById(ms.getId());
        m.setMa(ms.getMa());
        m.setTen(ms.getTen());
        return mausacrepo.UpdateMauSac(m);
    }

    @Override
    public List<HDHRespone> getlistHDH() {
        List<HDH> hdhs = hdhrepo.SelestAllHDH();
        return hdhs.stream().map(HDHRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertHDH(HDHRespone hdh) {
        HDH h = new HDH();
        h.setMa(hdh.getMa());
        h.setTen(hdh.getTen());
        return hdhrepo.InsertHDH(h);
    }

    @Override
    public boolean updatehdh(HDHRespone hdh) {
        HDH h = hdhrepo.SelectHDHById(hdh.getId());
        h.setMa(hdh.getMa());
        h.setTen(hdh.getTen());
        return hdhrepo.UpdateHDH(h);
    }

    @Override
    public List<CPURespone> getlistCPU() {
        List<CPU> cpu = cpurepo.SelectCPU();
        return cpu.stream().map(CPURespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertCPU(CPURespone cpu) {
        CPU c = new CPU();
        c.setMa(cpu.getMa());
        c.setTen(cpu.getTen());
        return cpurepo.InsertCPU(c);
    }

    @Override
    public boolean updateCPU(CPURespone cpu) {
        CPU c = cpurepo.SelectAllById(cpu.getId());
        c.setMa(cpu.getMa());
        c.setTen(cpu.getTen());
        return cpurepo.UIpdate(c);
    }

}
