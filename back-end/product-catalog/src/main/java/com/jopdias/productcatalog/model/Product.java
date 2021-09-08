package com.jopdias.productcatalog.model;


import com.jopdias.productcatalog.helper.ProductIndex;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = ProductIndex.PRODUCT_INDEX)
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private String name;

  private Integer amount;



}
