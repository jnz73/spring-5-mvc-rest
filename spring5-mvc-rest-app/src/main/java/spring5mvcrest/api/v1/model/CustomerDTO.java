package spring5mvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {

    @ApiModelProperty(value = "this is the first name", required = true)
    private String firstname;
    @ApiModelProperty(value = "this is the last name", required = true)
    private String lastname;
    @JsonProperty("customer_url")
    private String customerUrl;
}
