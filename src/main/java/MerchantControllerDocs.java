import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "M", description = "Merchant")
public interface MerchantControllerDocs {

    @ApiOperation(
            value = "Create merchant.",
            notes = "Create merchant in ELMA BPM.")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Merchant Uid"))
    String createMerchant();

}
