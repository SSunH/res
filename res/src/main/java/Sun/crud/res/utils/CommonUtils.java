package Sun.crud.res.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Sun.crud.res.entity.TokenInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Slf4j
@Component
public class CommonUtils {

    public TokenInfo getAccessTokenInfo(HttpServletRequest request){
        TokenInfo tokenInfo = null;
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.startsWithIgnoreCase(authorization, "Bearer")){
            Jwt jwt = JwtHelper.decode(StringUtils.replace(authorization, "Bearer ",""));
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create(); // snakecase to camelcase
            tokenInfo = gson.fromJson(jwt.getClaims(), TokenInfo.class);
        }
        return tokenInfo;
    }

}