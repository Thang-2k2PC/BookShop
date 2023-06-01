package com.bookshop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
@Entity
public class ChiMucGioHang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "ma_san_pham")
	private SanPham sanPham;
	
	private int so_luong;
	
	@ManyToOne
	@JoinColumn(name = "ma_gio_hang")
	private GioHang gioHang;

}
