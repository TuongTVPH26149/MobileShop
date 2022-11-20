/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import com.poly.it17322.nhom6.repositories.HoaDonChiTietRepository;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.responses.HoaDonChiTietResponse;
import com.poly.it17322.nhom6.responses.HoaDonResponse;

import com.poly.it17322.nhom6.services.IChiTietHoaDonService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import com.poly.it17322.nhom6.services.IHoaDonService;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author Rùa
 */
public class ChiTietHoaDonImpl implements IChiTietHoaDonService {

    HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTietResponse> SelectByHoaDonCTID(UUID IdHoaDon) {
        List<HoaDonChiTiet> hoaDonList = hoaDonChiTietRepository.SelectByHoaDonCTID(IdHoaDon);
        List<HoaDonChiTietResponse> response = hoaDonList.stream().map(hoaDon -> new HoaDonChiTietResponse(hoaDon)).collect(Collectors.toList());
        return response;
    }

}
