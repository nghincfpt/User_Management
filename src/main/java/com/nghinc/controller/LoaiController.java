package com.nghinc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nghinc.DTO.DtoLoai;
import com.nghinc.model.Loai;
import com.nghinc.service.LoaiService;

@Controller
@RequestMapping("admin/loai")
public class LoaiController {

	@Autowired
	private LoaiService loaiService;

	@GetMapping("/")
	public String Home(Model model) {

		List<Loai> list = loaiService.findAll();
		model.addAttribute("loais", list);
		return "admin/loai/list";
	}

	@GetMapping("/saveOrEdit")
	public String add(Model model) {
		model.addAttribute("loai", new DtoLoai());
		return "admin/loai/saveloai";
	}

	@PostMapping("/saveOrEdit")
	public ModelAndView saveOrupdate(ModelMap model, @ModelAttribute("loai") Loai dto) {

		Loai loai = new Loai();
		BeanUtils.copyProperties(dto, loai);
		loaiService.save(loai);

		model.addAttribute("message", "category is saved!");
		return new ModelAndView("redirect:/admin/loai/");

	}

	@GetMapping("edit/{loaiID}")
	public ModelAndView edit(ModelMap model, @PathVariable("loaiID") long loaiID) {
		Optional<Loai> opt = loaiService.findById(loaiID);
		DtoLoai dto = new DtoLoai();

		if (opt.isPresent()) {
			// lấy giá trị hiện tại gián vào edit
			Loai entity = opt.get();
			BeanUtils.copyProperties(entity, dto);

			dto.setIsEdit(true);

			model.addAttribute("loai", dto);
			return new ModelAndView("admin/loai/saveloai", model);
		}

		model.addAttribute("message", "Loai is not extsted");
		return new ModelAndView("redirect:/admin/loai/");

	}
@GetMapping("delete/{loaiID}")
	public ModelAndView deleteByID(Model model,@PathVariable("loaiID") Long loai) {
	
	loaiService.deleteById(loai);
	model.addAttribute("message","delete success");
	
	return new  ModelAndView("redirect:/admin/loai/");
	
}
@GetMapping("/search")
public String search(ModelMap model,@RequestParam(name="ten",required = false) String ten) {
	List<Loai> list= null;
	if (StringUtils.hasText(ten)) {
		list=loaiService.findByTenContaining(ten);
	}else {
		list=loaiService.findAll();
	}
	model.addAttribute("loais",list);
	return "admin/loai/list";
}

}
