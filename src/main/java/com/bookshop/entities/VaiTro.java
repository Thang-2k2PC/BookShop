package com.bookshop.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VaiTro {

	@Id
	@GeneratedValue
	private long id;
	
	private String tenVaiTro;

	@JsonIgnore
	@ManyToMany(mappedBy = "vaiTro")
	private Set<NguoiDung> nguoiDung;

	public VaiTro(String tenVaiTro){
		this.tenVaiTro = tenVaiTro;
	}
}
