package com.nghinc.service;

import java.util.List;
import java.util.Optional;

import com.nghinc.model.Loai;

public interface LoaiService {

	List<Loai> findAll();

	<S extends Loai> S save(S entity);

	Optional<Loai> findById(Long id);

	void deleteById(Long id);

	List<Loai> findByTenContaining(String ten);
 
}
