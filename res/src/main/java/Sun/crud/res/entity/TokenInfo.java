package Sun.crud.res.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TokenInfo {
	@JsonProperty
    private String name;
	@JsonProperty
    private String email;
	@JsonProperty
    private String clientId;
	@JsonProperty
    private String role;
}