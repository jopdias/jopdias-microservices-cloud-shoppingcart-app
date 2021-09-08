package com.jopdias.productcatalog.dto.request;


import javax.validation.constraints.NotEmpty;

public class ProductDTO {

  @NotEmpty
  private String id;

  @NotEmpty
  private String name;

  @NotEmpty
  private Integer amount;
}
