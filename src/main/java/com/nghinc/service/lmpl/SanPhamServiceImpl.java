package com.nghinc.service.lmpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nghinc.model.SanPham;
import com.nghinc.repository.SanPhamRepository;
import com.nghinc.service.SanPhamService;
@Service
public class SanPhamServiceImpl  implements SanPhamService{
  
	SanPhamRepository sanPhamRepository;
	
	 public SanPhamServiceImpl(SanPhamRepository sanPhamRepository) {
		this.sanPhamRepository = sanPhamRepository;
	}

	@Override
	public <S extends SanPham> S save(S entity) {
		return sanPhamRepository.save(entity);
	}

	@Override
	public List<SanPham> findAll() {
		return sanPhamRepository.findAll();
	}

	@Override
	public Optional<SanPham> findById(Long id) {
		return sanPhamRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		sanPhamRepository.deleteById(id);
	}
	 
	
}
