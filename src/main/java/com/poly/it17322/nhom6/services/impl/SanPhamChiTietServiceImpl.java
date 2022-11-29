/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.CPU;
import com.poly.it17322.nhom6.domainmodels.Imel;
import com.poly.it17322.nhom6.domainmodels.ManHinh;
import com.poly.it17322.nhom6.domainmodels.Pin;
import com.poly.it17322.nhom6.domainmodels.MauSac;
import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.repositories.CPURepository;
import com.poly.it17322.nhom6.repositories.ImelBanHangRepository;
import com.poly.it17322.nhom6.repositories.ImelRepository;
import com.poly.it17322.nhom6.repositories.ManHinhRepository;
import com.poly.it17322.nhom6.repositories.MauSacRepository;
import com.poly.it17322.nhom6.repositories.PinRepository;
import com.poly.it17322.nhom6.repositories.RamRepositry;
import com.poly.it17322.nhom6.repositories.RomRepository;
import com.poly.it17322.nhom6.repositories.SpCTSPRepository;
import com.poly.it17322.nhom6.responses.CPURespone;
import com.poly.it17322.nhom6.responses.ImelSPRespone;
import com.poly.it17322.nhom6.responses.ManHinhRespone;
import com.poly.it17322.nhom6.responses.PinRespone;
import com.poly.it17322.nhom6.responses.MauSacRespone;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.responses.RomRespone;
import com.poly.it17322.nhom6.services.ISanPhamChiTietService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class SanPhamChiTietServiceImpl implements ISanPhamChiTietService {

    RomRepository romrepo = new RomRepository();
    RamRepositry ramrepo = new RamRepositry();
    MauSacRepository mausacrepo = new MauSacRepository();
    CPURepository cpurepo = new CPURepository();
    ManHinhRepository mhrepo = new ManHinhRepository();
    PinRepository pinrepo = new PinRepository();
    SpCTSPRepository imelrepo = new SpCTSPRepository();
    ImelRepository imrepo = new ImelBanHangRepository();

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
        List<Ram> rams = ramrepo.selectALLRam();
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
        List<MauSac> mausacs = mausacrepo.selectALLMauSac();
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
    public List<CPURespone> getlistCPU() {
        List<CPU> cpu = cpurepo.selectALLCPU();
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
        CPU c = cpurepo.SelectCPUById(cpu.getId());
        c.setMa(cpu.getMa());
        c.setTen(cpu.getTen());
        return cpurepo.UpdateCPU(c);
    }

    @Override
    public List<ManHinhRespone> getlistManHinh() {
        List<ManHinh> mahinhs = mhrepo.SelectAllManHinh();
        return mahinhs.stream().map(ManHinhRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertManHinh(ManHinhRespone manhinh) {
        ManHinh m = new ManHinh();
        m.setMa(manhinh.getMa());
        m.setTen(manhinh.getTen());
        return mhrepo.InsertManHinh(m);
    }

    @Override
    public boolean updateManHinh(ManHinhRespone manhinh) {
        ManHinh m = mhrepo.SelectManHinhById(manhinh.getId());
        m.setMa(manhinh.getMa());
        m.setTen(manhinh.getTen());
        return mhrepo.UpdateManHinh(m);
    }

    @Override
    public List<PinRespone> getlistPin() {
        List<Pin> pins = pinrepo.selectALLPin();
        return pins.stream().map(PinRespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insertPin(PinRespone pin) {
        Pin p = new Pin();
        p.setMa(pin.getMa());
        p.setTen(pin.getTen());
        return pinrepo.InsertPin(p);
    }

    @Override
    public boolean updatePin(PinRespone pin) {
        Pin p = pinrepo.SelectPinById(pin.getId());
        p.setMa(pin.getMa());
        p.setTen(pin.getTen());
        return pinrepo.UpdatePin(p);
    }

    @Override
    public List<Imel> getListImel(UUID Idctsp) {       
        return imelrepo.SelectCBOImelById(Idctsp);
    }
    
    public boolean updateImel(ImelSPRespone imel){
        Imel im = imrepo.SelectImelById(imel.getId());
        im.setMa(imel.getMa());
        return imrepo.UpdateImel(im);
    }
}
