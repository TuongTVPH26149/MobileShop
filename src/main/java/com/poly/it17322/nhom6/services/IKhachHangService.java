/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.domainmodels.KhachHang;
import com.poly.it17322.nhom6.responses.KhachHangResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ACER
 */
public interface IKhachHangService {

    public List<KhachHangResponse> getlist();

    public KhachHang SelectKhachHangById(UUID id);

    public boolean Insert(KhachHangResponse khachHang);

    public boolean Update(KhachHangResponse khachHang);
    
}
