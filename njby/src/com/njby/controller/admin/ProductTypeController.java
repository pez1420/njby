package com.njby.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Admin;
import com.njby.entity.ProductType;
import com.njby.service.ProductTypeService;


@Controller("adminProductTypeController")
@RequestMapping({ "/admin/product_type" })
public class ProductTypeController extends BaseAdminController{
	@Resource
	ProductTypeService productTypeService;
	
	@RequestMapping(value = {"/list"}, method = {RequestMethod.GET})
	public String list(ModelMap model) {
		model.addAttribute("productTypeTree", this.productTypeService.findTree());
		return "/admin/products/product_type/product_type_view";
	}	
	
	@RequestMapping(value = {"/add"}, method = {RequestMethod.GET})
	public String add(ModelMap model) {
		model.addAttribute("productTypeTree", this.productTypeService.findTree());
		return "/admin/products/product_type/product_type_add";	
	}
	
	@RequestMapping(value = {"/save"}, method = {RequestMethod.POST})
	public String save(ProductType productType, String parentId, 
			RedirectAttributes redirectAttributes) {
		
		ProductType parent = productTypeService.find(parentId);
		productType.setParent(parent);
		
		if (parent != null) {
			productType.setGrade(Integer.valueOf(parent.getGrade().intValue() + 1));
			productType.setTreePath(parent.getTreePath() + parent.getId() + ProductType.TREE_PATH_SEPRATOR);
		} else {
			productType.setGrade(Integer.valueOf(0));
			productType.setTreePath(ProductType.TREE_PATH_SEPRATOR);
		}	
		
		//productType.setOrders(parent.getOrders());
		
		productTypeService.save(productType);
		
		addFlashAttribute(redirectAttributes, success);
		
		//从一个controller跳转到另一个controller
		return "redirect:list.jhtml";
	}
	
	
	@RequestMapping(value = { "/edit" }, method = {RequestMethod.GET })
	public String edit(String id, ModelMap model) {
		ProductType productType = this.productTypeService.find(id);
		model.addAttribute("productType", productType);
		model.addAttribute("productTypeTree", this.productTypeService.findTree());
		model.addAttribute("children", this.productTypeService.findChildrens(productType));
		return "/admin/products/product_type/product_type_edit";
	}
	
	@RequestMapping(value = { "/update" }, method = {RequestMethod.POST })
	public String update(ProductType productType, String parentId, 
			RedirectAttributes redirectAttributes) {
		
		productType.setParent(productTypeService.find(parentId));	
		
		if (productType.getParent() != null) {
			ProductType parent = productType.getParent();
			if (parent.equals(productType)) {
				List<ProductType> childrens = this.productTypeService.findChildrens(parent);
				if ( childrens != null && childrens.contains(parent) ) {
					return "/admin/common/error";
				}
			}
		}
		
		this.productTypeService.update(productType);
		
		addFlashAttribute(redirectAttributes, success);
		return "redirect:list.jhtml";		
	}
}
