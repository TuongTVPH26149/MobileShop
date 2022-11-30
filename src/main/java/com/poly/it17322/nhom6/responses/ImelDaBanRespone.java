/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.ImelBan;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
public class ImelDaBanRespone {
    private UUID id;
    private String ma;

    public ImelDaBanRespone(ImelBan imel) {
        this.id = imel.getId();
        this.ma = imel.getMa();
    }
}
