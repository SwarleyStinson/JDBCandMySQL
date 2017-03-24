import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MerchantController implements MerchantControllerDocs {

    @RequestMapping(value = "/merchant",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String createMerchant() {
        String result = "response";


        return result;
    }
    /* produces = {MediaType.APPLICATION_JSON_VALUE})*/

}
