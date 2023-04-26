package com.bookshop.service;

import com.bookshop.entities.GioHang;
import com.bookshop.entities.NguoiDung;

public interface GioHangService {
	
	GioHang getGioHangByNguoiDung(NguoiDung n);
	
	GioHang save(GioHang g);
}
