package com.jopdias.productcatalog.controller;

import com.jopdias.productcatalog.dto.request.ProductDTO;
import com.jopdias.productcatalog.dto.response.MessageResponseDTO;
import com.jopdias.productcatalog.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "product")
public class ProductController {

 ProductService productService;

 @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }


  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createProduct(@RequestBody ProductDTO productDTO){
  return productService.create(productDTO);
  }


  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<ProductDTO> findById(@PathVariable String id){
  return productService.findById(id);
  }

  @GetMapping()
  public List<ProductDTO> getAllProducts(){
  return productService.getAllProducts();
  }

}
