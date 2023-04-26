package com.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.entities.ChiMucGioHang;
import com.bookshop.entities.GioHang;
import com.bookshop.entities.SanPham;

public interface ChiMucGioHangRepository extends JpaRepository<ChiMucGioHang, Long>{
	
	ChiMucGioHang findBySanPhamAndGioHang(SanPham sp,GioHang g);
	
	List<ChiMucGioHang> findByGioHang(GioHang g);
}
