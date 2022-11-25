/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.KhuyenMai;
import com.poly.it17322.nhom6.repositories.KhuyenMaiRepository;
import com.poly.it17322.nhom6.responses.KhuyenMaiResponse;
import com.poly.it17322.nhom6.services.IKhuyenMaiService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author TUYEN
 */
public class KhuyenMaiServiceImpl implements IKhuyenMaiService {

    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMaiResponse> SelectKhuyenMai() {
        List<KhuyenMai> khuyenMais = khuyenMaiRepository.selectALLKhuyenMai();
        return khuyenMais.stream().map(KhuyenMaiResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<KhuyenMaiResponse> getByCodeAndCreateDate(String ma, Date from, Date to) {
        List<KhuyenMai> khuyenMais = khuyenMaiRepository.getByCodeAndCreateDate(ma, from, to);
        return khuyenMais.stream().map(KhuyenMaiResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<KhuyenMaiResponse> getByCodeAndUpdateDate(String ma, Date from, Date to) {
        List<KhuyenMai> khuyenMais = khuyenMaiRepository.getByCodeAndUpdateDate(ma, from, to);
        return khuyenMais.stream().map(KhuyenMaiResponse::new).collect(Collectors.toList());
    }

}
