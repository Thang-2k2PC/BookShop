package com.bookshop.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class NguoiDung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	
	@JsonIgnore
	private String password;
	
	@Transient
	@JsonIgnore
	private String confirmPassword;

	@Column(name = "hoten")
	private String hoTen;

	@Column(name = "sodienthoai")
	private String soDienThoai;

	@Column(name = "diachi")
	private String diaChi;
	
	@ManyToMany
	@JoinTable(name="nguoidung_vaitro",
	           joinColumns=@JoinColumn(name="ma_nguoi_dung"), 
	           inverseJoinColumns=@JoinColumn(name="ma_vai_tro"))
	private Set<VaiTro> vaiTro;

	@Transient
	@JsonIgnore
	private List<DonHang> listDonHang;
	

	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi;
	}	
}
