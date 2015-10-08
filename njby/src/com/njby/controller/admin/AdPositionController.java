package com.njby.controller.admin;

import javax.annotation.Resource;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njby.entity.search.SearchAdPosition;
import com.njby.service.AdPositionService;
import com.njby.utils.Pageable;


@Controller("adminAdPositionController")
@RequestMapping({"/admin/ad_position"})
public class AdPositionController extends BaseAdminController{
	  @Resource
	  private AdPositionService adPositionService;
	  
	  @RequestMapping(value={"/list"}, method={RequestMethod.GET})
	  public String list(Pageable pageable, SearchAdPosition searchAdPosition, ModelMap model)
	  {
		  model.addAttribute("page", this.adPositionService.findPage(pageable, searchAdPosition));
		  return "/admin/content/adposition/adposition_view";
	  }	  
	  
}
