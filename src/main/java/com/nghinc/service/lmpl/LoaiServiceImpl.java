package com.nghinc.service.lmpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nghinc.model.Loai;
import com.nghinc.repository.LoaiRepository;
import com.nghinc.service.LoaiService;

@Service
public class LoaiServiceImpl implements LoaiService {

	private LoaiRepository loaiRepository;

	public LoaiServiceImpl(LoaiRepository loaiRepository) {
		this.loaiRepository = loaiRepository;
	}

	@Override
	public <S extends Loai> S save(S entity) {
		return loaiRepository.save(entity);
	}

	@Override
	public List<Loai> findAll() {
		return loaiRepository.findAll();
	}

	@Override
	public Optional<Loai> findById(Long id) {
		return loaiRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		loaiRepository.deleteById(id);
	}

	@Override
	public List<Loai> findByTenContaining(String ten) {
		return loaiRepository.findByTenContaining(ten);
	}

}
