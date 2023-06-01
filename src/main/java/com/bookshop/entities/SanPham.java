package com.bookshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
public class SanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String tenSanPham;
	private long donGia;
	private int donViKho;
	private int donViBan;
	private String thongTinChung;
	
	@Transient
	@JsonIgnore
	private MultipartFile hinhAnh;

	@ManyToOne
	@JoinColumn(name = "ma_danh_muc")
	private DanhMuc danhMuc;

	@ManyToOne
	@JoinColumn(name = "ma_hang_sx")
	private HangSanXuat hangSanXuat;


}
