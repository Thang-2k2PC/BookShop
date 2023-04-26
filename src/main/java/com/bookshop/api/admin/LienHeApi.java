package com.bookshop.api.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.bookshop.entities.NguoiDung;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.dto.LienHeDTO;
import com.bookshop.dto.SearchLienHeObject;
import com.bookshop.entities.LienHe;
import com.bookshop.entities.ResponseObject;
import com.bookshop.service.LienHeService;
import com.bookshop.service.NguoiDungService;
import com.bookshop.ulti.EmailUlti;

@RestController
@RequestMapping("/api/lien-he")
public class LienHeApi {

    @Autowired
    private LienHeService lienHeService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private EmailUlti emailUlti;

    @GetMapping("/all")
    public Page<LienHe> getLienHeByFilter(@RequestParam(defaultValue = "1") int page, @RequestParam String trangThaiLienHe, @RequestParam String tuNgay, @RequestParam String denNgay) throws ParseException {

        SearchLienHeObject object = new SearchLienHeObject();
        object.setDenNgay(denNgay);
        object.setTrangThaiLienHe(trangThaiLienHe);
        object.setTuNgay(tuNgay);

        Page<LienHe> listLienHe = lienHeService.getLienHeByFilter(object, page);
        return listLienHe;
    }

    @GetMapping("/{id}")
    public LienHe getLienHeById(@PathVariable long id) {
        return lienHeService.findById(id);
    }

    @PostMapping("/reply")
    public ResponseObject tradLoiLienHeProcess(@RequestBody @Valid LienHeDTO dto, BindingResult result, HttpServletRequest request) {
        NguoiDung currentUser = getSessionUser(request);

//        nguoiDung.setEmail("bookshop@gmail.com");
//        dto.setEmail(nguoiDung);
        nguoiDungService.findByEmail(currentUser.getEmail());
        //-------------------
        ResponseObject ro = new ResponseObject();
        System.out.println(dto.toString());
        if (result.hasErrors()) {

            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            ro.setErrorMessages(errors);


            ro.setStatus("fail");
        } else {
            System.out.println(dto.toString());

            emailUlti.sendEmail(dto.getDiaChiDen(), dto.getTieuDe(), dto.getNoiDungTraLoi());
            LienHe lienHe = lienHeService.findById(dto.getId());
            lienHe.setTrangThai("Đã trả lời");
            lienHe.setNgayTraLoi(new Date());
            lienHe.setNoiDungTraLoi(dto.getNoiDungTraLoi());
//            lienHe.setNguoiTraLoi();
//            lienHe.setNguoiTraLoi();

            lienHeService.save(lienHe);
            ro.setStatus("success");
        }
        return ro;

    }

    private NguoiDung getSessionUser(HttpServletRequest request) {
        return (NguoiDung) request.getSession().getAttribute("loggedInUser");
    }
}
