package com.njby.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;





import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.njby.entity.Product;
import com.njby.entity.ProductImage;
import com.njby.entity.search.SearchProduct;
import com.njby.service.FileService;
import com.njby.service.ProductImageService;
import com.njby.service.ProductService;
import com.njby.service.ProductTypeService;
import com.njby.utils.Message;
import com.njby.utils.Page;
import com.njby.utils.Pageable;
import com.system.FileInfo;

@Controller("adminProductController")
@RequestMapping({ "/admin/product" })
public class ProductController extends BaseAdminController {
	
	@Resource
	private ProductService productService;
	
	@Resource
	private ProductImageService productImageService;
	
	@Resource
	private ProductTypeService productTypeService;
	
	@Resource
	private FileService fileService;
	
	@RequestMapping(value = { "/check_sn" }, method = { RequestMethod.GET })
	@ResponseBody
	public boolean checkSn(String previousSn, String sn) {
		if (StringUtils.isEmpty(sn)) {
			return false;
		}
		return this.productService.snUnique(previousSn, sn);
	}

	@RequestMapping(value = {"/list"}, method = {RequestMethod.GET})
	public String list(Pageable pageable, SearchProduct searchProduct, ModelMap model) {
		model.addAttribute("productTypeTree", this.productTypeService.findTree());
		//Page<Product> page = this.productService.findPage(pageable, searchProduct);
		model.addAttribute("page", this.productService.findPage(pageable, searchProduct));
		model.addAttribute("search", searchProduct);
		return "/admin/products/product_mgr/product_mgr_view";
	}
	
	@RequestMapping(value = { "/add" }, method = { RequestMethod.GET })
	public String add(ModelMap model) {
		model.addAttribute("productTypeTree", this.productTypeService.findTree());
		return "/admin/products/product_mgr/product_mgr_add";
	}
	
/*	@RequestMapping(value = { "/save" }, method = { RequestMethod.POST })
	public String save(Product product, String productTypeId,  
			//@RequestParam("imageFile")MultipartFile imageFile,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		//剪切图片http://blog.csdn.net/huahuagongzi99999/article/details/40737529?utm_source=tuicool
		
		MultipartFile imageFile = product.getImageFile();
		//验证图片有效性
		if (imageFile == null || imageFile.isEmpty() || !(this.fileService.isValid(FileInfo.FileType.image, imageFile))) {
			 addFlashAttribute(redirectAttributes, Message.error("admin.upload.invalid", new Object[0]));
			 return "redirect:add.jhtml";
		}
		
		//上传图片
		String fileName = this.fileService.upload(request, FileInfo.FileType.image, imageFile);
		if (StringUtils.isEmpty(fileName)) {
			 addFlashAttribute(redirectAttributes, Message.error("admin.upload.invalid", new Object[0]));
			 return "redirect:add.jhtml";
		}
		product.setImage(fileName);
		product.setProductType(this.productTypeService.find(productTypeId));
		
		this.productService.save(product);
		
		addFlashAttribute(redirectAttributes, success);

		return "redirect:list.jhtml";
	}*/

	@RequestMapping(value = { "/save" }, method = { RequestMethod.POST })
	public String save(Product product, String productTypeId,  
			HttpServletRequest request, RedirectAttributes redirectAttributes) {

		MultipartFile[] files = product.getFiles();
		
		if ( ArrayUtils.isNotEmpty(files) ) {
			//验证文件有效性
			for (MultipartFile file : files) {
				if (file == null || file.isEmpty() || !(this.fileService.isValid(FileInfo.FileType.image, file))) {
					 addFlashAttribute(redirectAttributes, Message.error("admin.upload.invalid", new Object[0]));
					 return "redirect:add.jhtml";
				}
			}
			
			ProductImage productImage = null;
			List<ProductImage> productImages = product.getProductImages();
			
			//确保所有上传文件都能上传成功
			for (MultipartFile file: files) {
				String fileName = this.fileService.upload(FileInfo.FileType.image, file);
				if (StringUtils.isNotEmpty(fileName)) {
					productImage = new ProductImage();
					productImage.setSource(fileName);
					productImage.setFile(file);
					productImages.add(productImage);
				} else {
					 addFlashAttribute(redirectAttributes, Message.error("admin.upload.invalid", new Object[0]));
					 return "redirect:add.jhtml";
				}
			}
			
			//生成图片的缩略图
			if ( productImages != null && !productImages.isEmpty() ) {
				for (ProductImage pi : productImages) {
					this.productImageService.build(pi);
				}
				
			}
			
			
		}
		
		
		addFlashAttribute(redirectAttributes, success);
		
		return "redirect:list.jhtml";
	}
	
	@RequestMapping(value = { "/edit" }, method = { RequestMethod.GET })
	public String edit(String id, ModelMap model) {
		model.addAttribute("productTypeTree", this.productTypeService.findTree());
		model.addAttribute("product", this.productService.find(id));
		return "/admin/products/product_mgr/product_mgr_edit";
	}
	
	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
	public String update(Product product, String productTypeId,  
			//@RequestParam("imageFile")MultipartFile imageFile,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		MultipartFile imageFile = product.getImageFile();
		//验证图片有效性
		if (imageFile == null || imageFile.isEmpty() || !(this.fileService.isValid(FileInfo.FileType.image, imageFile))) {
			 addFlashAttribute(redirectAttributes, Message.error("admin.upload.invalid", new Object[0]));
			 return "redirect:edit.jhtml?id=" + product.getId();
		}
		
		//上传图片
		String fileName = this.fileService.upload(FileInfo.FileType.image, imageFile);
		if (StringUtils.isEmpty(fileName)) {
			 addFlashAttribute(redirectAttributes, Message.error("admin.upload.invalid", new Object[0]));
			 return "redirect:edit.jhtml?id=" + product.getId();
		}
		product.setImage(fileName);
		product.setProductType(this.productTypeService.find(productTypeId));
		
		this.productService.update(product);
		
		addFlashAttribute(redirectAttributes, success);

		return "redirect:list.jhtml";
	}
	
}
