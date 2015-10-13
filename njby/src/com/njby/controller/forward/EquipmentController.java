package com.njby.controller.forward;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njby.entity.Equipment;
import com.njby.service.EquipmentService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;


@Controller("frowardEquipmentController")
@RequestMapping({ "/equipment" })
public class EquipmentController extends BaseForwardController {

	@Resource
	private EquipmentService equipmentService;
	
	
	@RequestMapping(value={"/list"}, method={RequestMethod.GET})
	public String list(Integer pageNumber,
			Integer pageSize, HttpServletRequest request, ModelMap model) {
		pageSize = 8;
		Pageable pageable = new Pageable(pageNumber, pageSize);
	    model.addAttribute("pageNumber", pageNumber);
	    model.addAttribute("pageSize", pageSize);
	    Page<Equipment> equipments = this.equipmentService.findPage(pageable, null);
	    model.addAttribute("page", this.equipmentService.findPage(pageable, null));
		return "/forward/equipment/list";
	}
	
}