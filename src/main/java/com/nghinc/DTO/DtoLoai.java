package com.nghinc.DTO;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoLoai {

	private  Long loaiID;
	@NotEmpty
	@Length(min=4)
	private String ten;
	
	private Boolean isEdit=false;
	
}
