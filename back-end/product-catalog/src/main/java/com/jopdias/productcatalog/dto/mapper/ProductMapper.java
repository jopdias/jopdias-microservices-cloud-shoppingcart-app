package com.jopdias.productcatalog.dto.mapper;

import com.jopdias.productcatalog.dto.request.ProductDTO;
import com.jopdias.productcatalog.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  Product toModel(ProductDTO dto);
  ProductDTO toDTO(Product dto);

}
