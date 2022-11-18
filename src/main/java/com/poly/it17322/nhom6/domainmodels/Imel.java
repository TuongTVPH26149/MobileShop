/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.domainmodels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "Imel")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Imel implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "id", insertable = false, nullable = true)
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "id", insertable = false, nullable = true)
    private ChiTietSP chiTietSP;

    @Column(name = "Ma", unique = true)
    private int ma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTrangThaiImel", referencedColumnName = "id")
    private TrangThaiImel trangThaiImel;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "Deleted", insertable = false)
    private boolean deleted;
    
    @OneToMany(mappedBy = "imel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BaoHanh> lstBaoHanh;
}
