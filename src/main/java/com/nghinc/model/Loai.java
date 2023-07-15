package com.nghinc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="loai")
public class Loai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loaiID;
	@Column(name = "ten" ,length = 100,columnDefinition = "nvarchar(100) not null")
	private String ten;

	@OneToMany(mappedBy = "loai" ,cascade = CascadeType.ALL)
	private Set<SanPham> products;
	
}
