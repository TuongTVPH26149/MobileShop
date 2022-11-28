/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.Imel;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author admin
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class ImelSPRespone {
    private UUID id;
    private String ma;
    private int trangthai;

    public ImelSPRespone(Imel imel) {
        this.id = imel.getId();
        this.ma = imel.getMa();
        this.trangthai = imel.getTrangThai();
    }
    
    public Object[] toDataRow(){
        return new Object[]{ma};
    }
}
