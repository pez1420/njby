package com.njby.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njby.entity.Ad;
import com.njby.entity.search.SearchAd;
import com.njby.service.AdService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Controller("adminAdController")
@RequestMapping({"/admin/ad"})
public class AdController extends BaseAdminController{
	  @Resource
	  private AdService adService;
	  
	  @RequestMapping(value={"/list"}, method={RequestMethod.GET})
	  public String list(Pageable pageable, SearchAd searchAd, ModelMap model)
	  {
		  Page<Ad> page = this.adService.findPage(pageable, searchAd);
		  model.addAttribute("page", this.adService.findPage(pageable, searchAd));
		  return "/admin/content/ad/ad_view";
	  }	 
}
