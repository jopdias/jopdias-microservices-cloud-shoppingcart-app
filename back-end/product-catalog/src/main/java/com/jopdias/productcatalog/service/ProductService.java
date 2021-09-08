package com.jopdias.productcatalog.service;

import com.jopdias.productcatalog.dto.mapper.ProductMapper;
import com.jopdias.productcatalog.dto.request.ProductDTO;
import com.jopdias.productcatalog.dto.response.MessageResponseDTO;
import com.jopdias.productcatalog.model.Product;
import com.jopdias.productcatalog.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;


  public MessageResponseDTO create(ProductDTO productDTO) {
    Product product = productMapper.toModel(productDTO);
    Product savedProduct = productRepository.save(product);

    MessageResponseDTO messageResponse = createMessageResponse("Created product w/ ID:", savedProduct.getId().toString());

   return messageResponse;
  }

  public List<ProductDTO> getAllProducts() {

//    List<Product> allProducts = (List<Product>) productRepository.findAll();
    List<Product> allProducts = new ArrayList<>();
    Iterable it = productRepository.findAll();
    it.forEach(x-> allProducts.add((Product)x));


    return allProducts.stream().map(productMapper::toDTO).collect(Collectors.toList());
  }

  public ResponseEntity<ProductDTO> findById(String id) {
    ProductDTO productDTO = productMapper.toDTO(verifyIfExists(id));
    return ResponseEntity.ok().body(productDTO);

  }

  private MessageResponseDTO createMessageResponse(String s, String id2) {
    return MessageResponseDTO.builder()
        .message(s + id2)
        .build();
  }

  public Product verifyIfExists(String id)  throws ResourceNotFoundException {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found: "));
  }



}
