package com.nghinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nghinc.model.SanPham;
@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long>{

}
