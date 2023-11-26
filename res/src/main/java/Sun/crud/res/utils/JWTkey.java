package Sun.crud.res.utils;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class JWTkey{

    String alg = "";
    String value = "";

    public String getValue() {
        if (!StringUtils.isEmpty(value)){
            return value;
        }
        return "";
    }
}