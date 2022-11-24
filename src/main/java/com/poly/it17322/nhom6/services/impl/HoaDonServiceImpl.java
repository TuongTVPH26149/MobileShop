/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.repositories.HoaDonRepository;
import com.poly.it17322.nhom6.responses.HoaDonResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import com.poly.it17322.nhom6.services.IHoaDonService;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author Rùa
 */
public class HoaDonServiceImpl implements IHoaDonService {

    private HoaDonRepository hoadonRepository = new HoaDonRepository();

    @Override
    public List<HoaDonResponse> SelectHoaDon() {
        List<HoaDon> hoadons = hoadonRepository.SelectALLHoaDon();
        return hoadons.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }
     @Override
    public List<HoaDonResponse> getByCodeAndCreateDate(String ma, Date from, Date to) {
        List<HoaDon> hoadons = hoadonRepository.getByCodeAndCreateDate(ma, from, to);
        return hoadons.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDonResponse> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        List<HoaDon> hoadons = hoadonRepository.getByCodeAndUpdateDate(ma, from, to);
        return hoadons.stream().map(HoaDonResponse::new).collect(Collectors.toList());
    }
}
