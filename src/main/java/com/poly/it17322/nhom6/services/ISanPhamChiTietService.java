/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.CPURespone;
import com.poly.it17322.nhom6.responses.HDHRespone;
import com.poly.it17322.nhom6.responses.HangRespone;
import com.poly.it17322.nhom6.responses.MauSacRespone;
import com.poly.it17322.nhom6.responses.RamRespone;
import com.poly.it17322.nhom6.responses.RomRespone;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ISanPhamChiTietService {
    public List<HangRespone> getlistHang();
    
    public boolean insertHang(HangRespone hang);
    
    public boolean updateHang(HangRespone hang);
    
    public List<RomRespone> getlistRom();
    
    public boolean insertRom(RomRespone rom);
    
    public boolean updateRom(RomRespone rom);
    
    public List<RamRespone> getlistRam();
    
    public boolean insertRam(RamRespone ram);
    
    public boolean updateRam(RamRespone ram);
    
    public List<MauSacRespone> getlistMauSac();
    
    public boolean insertMauSac(MauSacRespone ms);
    
    public boolean updateMauSac(MauSacRespone ms);
    
    public List<HDHRespone> getlistHDH();
    
    public boolean insertHDH(HDHRespone hdh);
    
    public boolean updatehdh(HDHRespone hdh);
    
    public List<CPURespone> getlistCPU();
    
    public boolean insertCPU(CPURespone cpu);
    
    public boolean updateCPU(CPURespone cpu);
    
}
