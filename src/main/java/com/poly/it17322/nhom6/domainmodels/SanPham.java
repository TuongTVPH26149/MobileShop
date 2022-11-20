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
 * @author LiamTrieu
 */
@Entity
@Table(name = "SanPham")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SanPham implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private UUID Id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "Ten", length = 30, nullable = false)
    private String ten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHang", referencedColumnName = "id")
    private Hang hang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHDH", referencedColumnName = "id")
    private HDH hDH;

    @Column(name = "CreatedDate", insertable = false, updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "lastModifiedDate", insertable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "Deleted", insertable = false)
    private boolean deleted;
}
