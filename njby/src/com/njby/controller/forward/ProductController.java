package com.njby.controller.forward;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njby.entity.ProductType;
import com.njby.entity.search.SearchProduct;
import com.njby.service.ProductService;
import com.njby.service.ProductTypeService;
import com.njby.utils.Pageable;
import com.system.ResourceNotFoundException;

@Controller("frowardProductController")
@RequestMapping({ "/product" })
public class ProductController extends BaseForwardController {
	@Resource
	private ProductService productService;
	@Resource
	private ProductTypeService productTypeService;

	@RequestMapping(value={"/list/{productTypeId}"}, method={RequestMethod.GET})
	public String list(@PathVariable String productTypeId, Integer pageNumber,
			Integer pageSize, HttpServletRequest request, ModelMap model) {
		ProductType productType = this.productTypeService.find(productTypeId);
		if (productType == null) {
			throw new ResourceNotFoundException();
		}
		pageSize = 12;
		Pageable pageable = new Pageable(pageNumber, pageSize);
		model.addAttribute("productType", productType);
	    model.addAttribute("pageNumber", pageNumber);
	    model.addAttribute("pageSize", pageSize);
	    
	    SearchProduct searchProduct = new SearchProduct();
	    searchProduct.setProductTypeId(productTypeId);
	    model.addAttribute("page", this.productService.findPage(pageable, searchProduct));
	    
		return "/forward/product/list";
	}
}
