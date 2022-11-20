/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.domainmodels;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author LiamTrieu
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HoaDonChiTietID implements Serializable {

    private HoaDon hoaDon;
    private ChiTietSP chiTietSP;
}
