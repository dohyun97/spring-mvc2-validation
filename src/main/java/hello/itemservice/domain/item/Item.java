package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Object error:이 방법을 추천 안해.오브젝트 오류부분만 직접 코드로 작성하는 것을 권수
//@ScriptAssert(lang = "javascript",script = "_this.price * _this.quantity >= 10000",message = "총합이 10000원 넘어야 합니다")
@Data
public class Item {
//    @NotNull(groups = UpdateCheck.class) //수정시에만 이 조건 필요
    private Long id;
//    @NotBlank(message = "공백x",groups = {UpdateCheck.class, SaveCheck.class})  //" " //message를 사용하면 내가 직접 오류메세지 설정 가(default message) ->messageSource(errors.properties에서 메시지 없으면 적용)
    private String itemName;
//    @NotNull(groups = {UpdateCheck.class, SaveCheck.class})   //0
//    @Range(min=1000,max=1000000,groups = {UpdateCheck.class, SaveCheck.class}) //수정,등록 둘다 이 조건 필요
    private Integer price;
//    @NotNull(groups = {UpdateCheck.class, SaveCheck.class}) //0
//    @Max(value = 9999, groups =  SaveCheck.class) //등록시에만 필요
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
