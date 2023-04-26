package com.bookshop.dto;

import com.bookshop.entities.NguoiDung;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class LienHeDTO {

	private NguoiDung email;

	public NguoiDung getEmail() {
		return email;
	}

	public void setEmail(NguoiDung email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LienHeDTO [id=" + id + ", noiDungTraLoi=" + noiDungTraLoi + ", tieuDe=" + tieuDe + ", diaChiDen="
				+ diaChiDen + ", ngayTraLoi=" + ngayTraLoi + "]";
	}

	private long id;
	
	@NotEmpty(message="Nội dung trả lời không được trống")
	private String noiDungTraLoi;
	
	private String tieuDe;
	private String diaChiDen;
	
	private Date ngayTraLoi;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNoiDungTraLoi() {
		return noiDungTraLoi;
	}

	public Date getNgayTraLoi() {
		return ngayTraLoi;
	}

	public Date setNgayTraLoi(Date ngayTraLoi) {
		this.ngayTraLoi = ngayTraLoi;
		return ngayTraLoi;
	}

	public void setNoiDungTraLoi(String noiDungTraLoi) {
		this.noiDungTraLoi = noiDungTraLoi;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getDiaChiDen() {
		return diaChiDen;
	}

	public void setDiaChiDen(String diaChiDen) {
		this.diaChiDen = diaChiDen;
	}
}
