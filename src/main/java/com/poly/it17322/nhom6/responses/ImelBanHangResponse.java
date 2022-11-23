/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.Imel;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Setter
@Getter
public class ImelBanHangResponse {
    private UUID id;
    private int ma;
    private String trangThai;

    public ImelBanHangResponse(Imel i) {
        this.id = i.getId();
        this.ma = i.getMa();
        this.trangThai = i.getTrangThaiImel().getMa();
    }
}
