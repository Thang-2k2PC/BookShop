package com.bookshop.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HangSanXuat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty(message="Tên hãng sản xuất không được trống")
	private String tenHangSanXuat;

	@JsonIgnore
	@OneToMany(mappedBy = "hangSanXuat")
	private List<SanPham> listSanPham;

}
