package hello.itemservice.web.validation;


import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {
    @PostMapping("/add")  //이거는 타입메치 에러 메세지가 우리가 만든걸로 안보여
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult){
        log.info("API controller");
        if(bindingResult.hasErrors()){
            log.info("검증 오류 발생 {}",bindingResult);
            return bindingResult.getAllErrors();  //모든 오류정보들이 보여. 필요한 데이터만 뽑아야돼
        }
        log.info("성공 로직 실행");
        return form;
    }
}
