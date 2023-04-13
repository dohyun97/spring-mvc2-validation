package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
@Data
public class ItemUpdatForm {
    @NotNull
    private Long id;

    @NotNull
    private String itemName;
    @NotNull
    @Range(min = 1000,max = 1000000)
    private Integer price;

    private Integer quantity; //수정시 수량은 자유롭게 변경 가능
}
