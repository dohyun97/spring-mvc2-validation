package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Object error:이 방법을 추천 안해.오브젝트 오류부분만 직접 코드로 작성하는 것을 권장
//@ScriptAssert(lang = "javascript",script = "_this.price * _this.quantity >= 10000",message = "총합이 10000원 넘어야 합니다")
@Data
public class Item {

    private Long id;
    @NotBlank(message = "공백x")  //" " //message를 사용하면 내가 직접 오류메세지 설정 가(default message) ->messageSource(errors.properties에서 메시지 없으면 적용)
    private String itemName;
    @NotNull   //0
    @Range(min=1000,max=1000000)
    private Integer price;
    @NotNull //0
    @Max(9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
