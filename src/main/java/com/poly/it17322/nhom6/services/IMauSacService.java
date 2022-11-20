/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.nhom6.services;

import com.poly.it17322.nhom6.responses.MauSacRespone;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IMauSacService {

    public List<MauSacRespone> getlist();

    public boolean insert(MauSacRespone ms);

    public boolean update(MauSacRespone ms);
}
