package com.bookshop.service;

import java.text.ParseException;

import org.springframework.data.domain.Page;

import com.bookshop.dto.SearchLienHeObject;
import com.bookshop.entities.LienHe;

public interface LienHeService {

	Page<LienHe> getLienHeByFilter(SearchLienHeObject object, int page) throws ParseException;

	LienHe findById(long id);
	
	LienHe save(LienHe lh);
	
	int countByTrangThai(String trangThai);

}
