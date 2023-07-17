package com.nghinc.service;

import java.util.List;
import java.util.Optional;

import com.nghinc.model.SanPham;
import com.nghinc.repository.SanPhamRepository;

public interface SanPhamService  {

	void deleteById(Long id);

	Optional<SanPham> findById(Long id);

	List<SanPham> findAll();

	<S extends SanPham> S save(S entity);

	

}
