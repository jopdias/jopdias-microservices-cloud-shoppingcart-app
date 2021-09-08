package digitalinnovation.one.experts.shoppingcart.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDetails {
  private Date timestamp;
  private String message;
  private String details;
}
