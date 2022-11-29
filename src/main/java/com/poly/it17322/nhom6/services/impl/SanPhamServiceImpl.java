/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.Imel;
import com.poly.it17322.nhom6.domainmodels.Rom;
import com.poly.it17322.nhom6.domainmodels.SanPham;
import com.poly.it17322.nhom6.repositories.CPURepository;
import com.poly.it17322.nhom6.repositories.ChiTietSPRepository;
import com.poly.it17322.nhom6.repositories.ImelRepository;
import com.poly.it17322.nhom6.repositories.ManHinhRepository;
import com.poly.it17322.nhom6.repositories.MauSacRepository;
import com.poly.it17322.nhom6.repositories.PinRepository;
import com.poly.it17322.nhom6.repositories.RamRepositry;
import com.poly.it17322.nhom6.repositories.RomRepository;
import com.poly.it17322.nhom6.repositories.SanPhamReposiry;
import com.poly.it17322.nhom6.responses.ImelAoSPRespone;
import com.poly.it17322.nhom6.responses.SanPhamSPRespone;
import com.poly.it17322.nhom6.services.ISanPhamSPService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class SanPhamServiceImpl implements ISanPhamSPService {

    private ChiTietSPRepository ctsprepo = new ChiTietSPRepository();
    SanPhamReposiry sprepo = new SanPhamReposiry();
    RomRepository romrepo = new RomRepository();
    RamRepositry ramrepo = new RamRepositry();
    MauSacRepository mausacrepo = new MauSacRepository();
    CPURepository cpurepo = new CPURepository();
    ManHinhRepository mhrepo = new ManHinhRepository();
    PinRepository pinrepo = new PinRepository();
    ImelRepository imelrepo = new ImelRepository();

    @Override
    public List<SanPhamSPRespone> getlist() {
        List<SanPhamSPRespone> lstsp = new ArrayList<>();
        List<ChiTietSP> sp = ctsprepo.selectALLChiTietSP();
        for (SanPhamSPRespone o : sp.stream().map(SanPhamSPRespone::new).collect(Collectors.toList())) {
            if (o.getSoluong() >= 0) {
                lstsp.add(o);
            }
        }
        return lstsp;
    }

    @Override
    public boolean insert(SanPhamSPRespone sp, UUID idcpu, UUID idrom, UUID idram, UUID idms, UUID idmh, UUID idpin, List<ImelAoSPRespone> lstao) {
        SanPham s = new SanPham();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String maSP = "SP" + sdf.format(new Date());
        s.setMa(maSP);
        s.setTen(sp.getTen());
        sprepo.InsertSanPham(s);
        ChiTietSP ctsp = new ChiTietSP();
        ctsp.setSanPham(s);
        ctsp.setCpu(cpurepo.SelectCPUById(idcpu));
        ctsp.setRom(romrepo.SelectRomById(idrom));
        ctsp.setRam(ramrepo.SelectRamById(idram));
        ctsp.setMauSac(mausacrepo.SelectMauSacById(idms));
        ctsp.setManHinh(mhrepo.SelectManHinhById(idmh));
        ctsp.setPin(pinrepo.SelectPinById(idpin));
        ctsp.setGia(sp.getGia());
        ctsp.setSoLuong(sp.getSoluong());
        ctsp.setLoaiHang(sp.getLoaihang());
        ctsp.setMoTa(sp.getMota());
        ctsprepo.InsertChiTietSP(ctsp);
        System.out.println(ctsp.getId());
        insertImel(lstao, ctsp);
        return true;
    }

    public void insertImel(List<ImelAoSPRespone> ma, ChiTietSP ctsp) {
        for (ImelAoSPRespone x : ma) {
            Imel imel = new Imel();
            imel.setMa(x.getMa());
            imel.setChiTietSP(ctsp);
            imelrepo.InsertImel(imel);
        }
    }

    @Override
    public boolean update(SanPhamSPRespone spr,UUID idcpu, UUID idrom, UUID idram, UUID idms, UUID idmh, UUID idpin) {
        ChiTietSP ctsp = ctsprepo.SelectChiTietSPById(spr.getId());
        SanPham sp = sprepo.SelectSanPhamById(ctsp.getSanPham().getId());
        sp.setTen(spr.getTen());
        ctsp.setCpu(cpurepo.SelectCPUById(idcpu));
        ctsp.setRom(romrepo.SelectRomById(idrom));
        ctsp.setRam(ramrepo.SelectRamById(idram));
        ctsp.setMauSac(mausacrepo.SelectMauSacById(idms));
        ctsp.setManHinh(mhrepo.SelectManHinhById(idmh));
        ctsp.setPin(pinrepo.SelectPinById(idpin));
        ctsp.setGia(spr.getGia());
        ctsp.setSoLuong(spr.getSoluong());
        ctsp.setLoaiHang(spr.getLoaihang());
        ctsp.setMoTa(spr.getMota());
        ctsp.setLoaiHang(spr.getLoaihang());
        return ctsprepo.UpdateChiTietSP(ctsp);
    }

}
