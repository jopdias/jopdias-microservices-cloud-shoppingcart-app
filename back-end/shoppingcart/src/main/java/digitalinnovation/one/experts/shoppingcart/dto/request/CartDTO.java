package digitalinnovation.one.experts.shoppingcart.dto.request;
import digitalinnovation.one.experts.shoppingcart.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

  private Integer id;
  private List<Item> items;

  public List<Item> getItems() {
    if (items == null) {
      items = new ArrayList<>();
    }
    return items;
  }


}
