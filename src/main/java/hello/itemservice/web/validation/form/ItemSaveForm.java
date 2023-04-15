package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
@Data
public class ItemSaveForm  {
   @NotNull(message = "Please type item name")
    private String itemName;
   @NotNull(message = "Please type price")
   @Range(min = 1000,max = 1000000,message = "Price should be higher than 1000 and Lower than 1000000")
    private Integer price;

   @NotNull(message = "please type quantity")
   @Max(value=9999,message = "Quantity should be not over 9999")
    private Integer quantity;
}
