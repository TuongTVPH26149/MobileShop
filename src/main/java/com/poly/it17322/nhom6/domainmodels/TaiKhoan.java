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
@Table(name = "TaiKhoan")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoan {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @Column(name = "Ma", unique = true, length = 20, nullable = false)
    private String ma;

    @Column(name = "HoTen", length = 50, nullable = false)
    private String hoTen;

    @Column(name = "GioiTinh", length = 10, nullable = true)
    private String gioiTinh;

    @Column(name = "NgaySinh", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "DiaChi", length = 100, nullable = true)
    private String diaChi;

    @Column(name = "Email", length = 100, nullable = false)
    private String email;

    @Column(name = "Sdt", length = 30, nullable = true)
    private String sdt;

    @Column(name = "MatKhau", length = 100, nullable = false)
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV", referencedColumnName = "id")
    private ChucVu chucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTrangThaiTK", referencedColumnName = "id")
    private TrangThaiTaiKhoan trangThaiTK;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "Deleted", insertable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDon> lstHoaDon;
}
