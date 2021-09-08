package digitalinnovation.one.experts.shoppingcart.service;


import digitalinnovation.one.experts.shoppingcart.dto.mapper.CartMapper;
import digitalinnovation.one.experts.shoppingcart.dto.request.CartDTO;
import digitalinnovation.one.experts.shoppingcart.dto.response.MessageResponseDTO;
import digitalinnovation.one.experts.shoppingcart.exception.ResourceNotFoundException;
import digitalinnovation.one.experts.shoppingcart.model.Cart;
import digitalinnovation.one.experts.shoppingcart.model.Item;
import digitalinnovation.one.experts.shoppingcart.repository.CartRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartService {

  @Autowired
  private CartRepository cartRepository;
  private final CartMapper cartMapper = CartMapper.INSTANCE;



  public Cart save(Integer id, Item item) {
    Cart cart = verifyIfExists(id);
    cart.getItems().add(item);
    return cartRepository.save(cart);
  }


  public ResponseEntity<CartDTO> findById(Integer id) {
    CartDTO cartDTO = cartMapper.toDTO(verifyIfExists(id));
    return ResponseEntity.ok().body(cartDTO);
  }


  public void deleteById(Integer id) {
    verifyIfExists(id);
    cartRepository.deleteById(id);
  }


  public Cart verifyIfExists(Integer id) {
    Optional<Cart> savedCart = cartRepository.findById(id);
    Cart cart = null;
    if (savedCart.equals(Optional.empty())) {
      cart = new Cart(id);
    }
    else if (savedCart.isPresent()){
      cart = savedCart.get();
    }
    return cart;
  }




}
