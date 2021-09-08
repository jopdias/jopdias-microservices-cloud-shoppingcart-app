package digitalinnovation.one.experts.shoppingcart.dto.mapper;


import digitalinnovation.one.experts.shoppingcart.dto.request.CartDTO;
import digitalinnovation.one.experts.shoppingcart.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {

  CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
  Cart    toModel(CartDTO dto);
  CartDTO toDTO(Cart dto);

}
