package com.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.entities.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
