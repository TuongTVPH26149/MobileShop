/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.CPURespone;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ICPUService {

    public List<CPURespone> getlist();

    public boolean insert(CPURespone cpu);

    public boolean update(CPURespone cpu);
}
