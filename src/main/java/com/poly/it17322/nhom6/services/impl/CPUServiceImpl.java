/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.services.impl;

import com.poly.it17322.nhom6.domainmodels.CPU;
import com.poly.it17322.nhom6.repositories.CPURepository;
import com.poly.it17322.nhom6.responses.CPURespone;
import com.poly.it17322.nhom6.services.ICPUService;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class CPUServiceImpl implements ICPUService {

    CPURepository repo = new CPURepository();

    @Override
    public List<CPURespone> getlist() {
        List<CPU> cpu = repo.SelectCPU();
        return cpu.stream().map(CPURespone::new).collect(Collectors.toList());
    }

    @Override
    public boolean insert(CPURespone ram) {
        CPU c = new CPU();
        c.setMa(ram.getMa());
        c.setTen(ram.getTen());
        return repo.InsertCPU(c);
    }

    @Override
    public boolean update(CPURespone cpu) {
        CPU c = repo.SelectAllById(cpu.getId());
        c.setMa(cpu.getMa());
        c.setTen(cpu.getTen());
        return repo.UIpdate(c);
    }

}
