package conversions;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ConversionsController {

    @RequestMapping("/")
    public String index() {
        return "should be page with form inputs.";
    }
    
    @RequestMapping(value = "/created", method = RequestMethod.POST)
    public String created() {
        return "should be page with output.";
    }

}
