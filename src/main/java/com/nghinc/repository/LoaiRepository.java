package com.nghinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nghinc.model.Loai;

@Repository
public interface LoaiRepository  extends JpaRepository<Loai, Long>{


	 @Query("SELECT l FROM Loai l WHERE l.ten LIKE %:ten%")
	    List<Loai> findByTenContaining(@Param("ten") String ten);
//	List<Loai> findByTenContaining(String ten);
}
