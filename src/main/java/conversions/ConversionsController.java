package conversions;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversionsController {

    @RequestMapping("/")
    public String index(ConversionModel conversionModel) {
        return "conversions/index";
    }
    
    @RequestMapping(value = "/created", method = RequestMethod.POST)
    public String checkBeforeCreation(
        @Valid ConversionModel conversionModel, BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "conversions/index";
        }
    
        return "conversions/created";
    }

}
