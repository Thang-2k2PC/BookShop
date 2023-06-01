package com.bookshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ChiTietDonHang {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name="ma_san_pham")
	private SanPham sanPham;

	private long donGia;

	private int soLuongDat;
	
	private int soLuongNhanHang;

	@ManyToOne
	@JoinColumn(name = "ma_don_hang")
	@JsonIgnore
	private DonHang donHang;
}
