package com.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.entities.GioHang;
import com.bookshop.entities.NguoiDung;

public interface GioHangRepository extends JpaRepository<GioHang, Long>{
	
	GioHang findByNguoiDung(NguoiDung n);
	
}
