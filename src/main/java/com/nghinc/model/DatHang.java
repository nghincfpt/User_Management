package com.nghinc.model;



import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DatHang {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dhID;
	@Column(name="ngayDat")
	private Date ngayDat;
	@Column(name="tinhThanhPho")
	private String tinhThanhPho;
	@Column(name="huyenQuan")
	private String huyenQuan;
	@Column(name="phuongXa")
	private String phuongXa;
	@Column(name="diaChi")
	private String diaChi;
	@Column(name="email")
	private String  email;
	@Column(name="hoTen")
	private String hoTen;
	@Column(name="sdt")
	private String sdt;
	@Column(name="hinhThucGiaoHang")
	private String hinhThucGiaoHang;
	@Column(name="phuongThucThanhToan")
	private String phuongThucThanhToan;
	
	@OneToMany(mappedBy = "datHangs",cascade = CascadeType.ALL)
	private Set<ChiTietDonHang> chiTietDonHang;
	
	@ManyToOne
	@JoinColumn(name="id")
	private User user;
	
}
