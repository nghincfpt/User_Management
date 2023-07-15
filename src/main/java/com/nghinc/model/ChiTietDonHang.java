package com.nghinc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//oneToMany thì cần phải sữ dụng Set <> k trung lặp , hiệu xuất tìm kiếm , tính linh hoạt < add, update,delete>
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChiTietDonHang {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ctdhID;
	@Column(name="gia")
	private float gia;
	@Column(name="soLuong")
	private int soLuong;
	@Column(name="tong")
	private float tong;
	
	@ManyToOne
	@JoinColumn(name="spctID")
	private SanPhamChiTiet sanPhamChiTiet;
	
	
	
	@ManyToOne
	@JoinColumn(name="dhID")
	private DatHang datHangs;
	
	
	
}
