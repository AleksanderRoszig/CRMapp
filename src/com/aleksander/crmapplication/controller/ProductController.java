package com.aleksander.crmapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aleksander.crmapplication.dao.ProductDAO;
import com.aleksander.crmapplication.entity.Customer;
import com.aleksander.crmapplication.entity.Product;
import com.aleksander.crmapplication.service.ProductService;


@Controller
@RequestMapping("/product")

public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		// get customers from the dao
		List<Product> theProduct= productService.getProduct();
		
		// add the customers to the model
		theModel.addAttribute("products", theProduct);

		
		return "list-products";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Product theProduct= new Product();
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product") Product theProduct, BindingResult theBindingResult) {
		
		
		if(theBindingResult.hasErrors()) {
			return "product-form";
		}
		else {
			// save the product using service
			productService.saveProduct(theProduct);
			
			return "redirect:/product/list";
		}
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		// delete the product
		productService.deleteProduct(theId);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
		
		// get the product from our service
		Product theProduct= productService.getProduct(theId);
		
		// set product as a model attribute to pre-populate the form
		theModel.addAttribute("product", theProduct);
		
		// send over to our form
		
		return "product-form";
	}
	
	 @PostMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        // search product from the service
	        List<Product> theProduct = productService.searchProduct(theSearchName);
	                
	        // add the product to the model
	        theModel.addAttribute("product", theProduct);

	        return "list-products";        
	    }
	
}
