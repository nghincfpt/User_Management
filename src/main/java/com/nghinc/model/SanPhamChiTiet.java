package com.nghinc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sanPhamChiTiet")
public class SanPhamChiTiet {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long spctID;
	@Column(name="cpu")
	private String cpu;
	@Column(name="oCung")
	private String oCung;
	@Column(name="manHinh")
	private String  manHinh;
	@Column(name="cardManHinh")
	private String cardManHinh;
	@Column(name="congKetNoi")
	private String congKetNoi;
	@Column(name="heDieuHanh")
	private String heDieuHanh;
	@Column(name="thietKe")
	private String thietKe;
	@Column(name="kichThuocKhoiLuong")
	private String kichThuocKhoiLuong;
	@Column(name="thoiDiemRaMat")
	private String  thoiDiemRaMat;
	@Column(name="moTa")
	private String moTa;
	
	
	@OneToOne
	@JoinColumn(name="sapPhamID")
	private SanPham sanPham;
	
	@OneToMany(mappedBy = "sanPhamChiTiet",cascade = CascadeType.ALL)
	 private Set<ChiTietDonHang> chiTietDonHang;
	
	
}
