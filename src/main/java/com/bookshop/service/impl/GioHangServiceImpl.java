package com.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.entities.GioHang;
import com.bookshop.entities.NguoiDung;
import com.bookshop.repository.GioHangRepository;
import com.bookshop.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService{
	
	@Autowired
	private GioHangRepository repo;
	
	@Override
	public GioHang getGioHangByNguoiDung(NguoiDung n)
	{
		return repo.findByNguoiDung(n);
	}
	
	@Override
	public GioHang save(GioHang g)
	{
		return repo.save(g);
	}

}
