/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.domainmodels;

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
 * @author LiamTrieu
 */
@Entity
@Table(name = "KhuyenMai")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @Column(name = "Ma", unique = true, length = 20, nullable = false)
    private String ma;

    @Column(name = "Ten", length = 30, nullable = false)
    private String ten;

    @Column(name = "NgayBD")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayBD;

    @Column(name = "NgayKT")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayKT;

    @Column(name = "GiaTri")
    private int giaTri;

    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdLoaiKM", referencedColumnName = "id")
    private LoaiKM loaiKM;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "Deleted", insertable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "khuyenMai", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietSP> lstChiTietSP;

}
