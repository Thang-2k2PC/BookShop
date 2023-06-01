package com.bookshop.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@Entity
public class LienHe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String emailLienHe;

	private String noiDungLienHe;

	private String noiDungTraLoi;

	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone="GMT+7")
	private Date ngayLienHe;

	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone="GMT+7")
	private Date ngayTraLoi;

	private String trangThai;
	
	@ManyToOne
	@JoinColumn(name = "ma_nguoi_tra_loi")
	private NguoiDung nguoiTraLoi;
}
