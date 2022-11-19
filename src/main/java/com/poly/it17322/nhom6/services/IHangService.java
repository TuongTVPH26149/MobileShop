/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.HangSPRespone;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IHangService {
    public List<HangSPRespone> getlist();
    public boolean insert(HangSPRespone hang);
    public boolean update(HangSPRespone hang);
}
