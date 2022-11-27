/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.NhanVienRespone;
import java.util.List;

/**
 *
 * @author tuan0
 */
public interface INhanVienService {
    
    public List<NhanVienRespone> getList();
    
    public boolean insert(NhanVienRespone nv);

    public boolean update(NhanVienRespone nv);
}
