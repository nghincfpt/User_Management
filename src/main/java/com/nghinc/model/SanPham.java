package com.nghinc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sapPhamID;

	@Column(name="ten",length=50,columnDefinition = "nvarchar(100) null")
	private String ten;
	@Column(name="gia")
	private float gia;
	@Column(name="giamPhanTram")
	private float giamPhanTram;
	@Column(name="soLuong")
	private int soLuong;
	@Column(name="trangThai")
	private String TrangThai;
	@Column(name="hinh")
	private String hinh;
	@Column(name="soSao")
	private String soSao;
	@Column(name="soDanhGia")
	private String soDanhGia;
	@Column(name="mau")
	private String mau;
	@Column(name="kieusp")
	private boolean kieuSP;
	@Column(name="giaBanDau")
	private String giaBanDau;
	
	@ManyToOne
	@JoinColumn(name="loaiID")
	private Loai loai;

	
	@OneToOne(mappedBy = "sanPham",cascade = CascadeType.ALL)
	private SanPhamChiTiet sanPhamChiTiet;
}
