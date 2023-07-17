package com.nghinc.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nghinc.model.Loai;
import com.nghinc.model.SanPham;
import com.nghinc.service.LoaiService;
import com.nghinc.service.SanPhamService;

@Controller
@RequestMapping("admin/sanpham")
public class SanPhamController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiService loaiService;

	@ModelAttribute("listLoai")
	public List<Loai> list() {
		return loaiService.findAll();
	}

	@GetMapping("/")
	public String home(Model model) {
		List<SanPham> list = sanPhamService.findAll();
		model.addAttribute("products", list);
		return "admin/sanpham/listproduct";

	}

	@GetMapping("/add")
	public String add() {
		
		return "admin/sanpham/addOrEdit";
	}

}
