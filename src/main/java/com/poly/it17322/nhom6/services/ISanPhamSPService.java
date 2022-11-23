/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.SanPhamSPRespone;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ISanPhamSPService {

    public List<SanPhamSPRespone> getlist();

    public boolean insert(SanPhamSPRespone sp);

    public boolean update(SanPhamSPRespone sp);
    
    
}
