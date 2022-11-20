/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.domainmodels.Ram;
import com.poly.it17322.nhom6.responses.RamRespone;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IRamService {
    public List<RamRespone> getlist();
    public boolean insert(RamRespone ram);
    public boolean update(RamRespone ram);
}
