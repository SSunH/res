package Sun.crud.res.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.StringUtils;
import com.google.gson.Gson;
import Sun.crud.res.utils.JWTkey;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

@Configuration
public class Oauth2ResourceConfig extends ResourceServerConfigurerAdapter {
	
    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String crudKeyUri;

    // API 별 필요한 인증정보 설정
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/main","/board").authenticated() // 리소스 서버에서 보호할 엔드포인트 설정
            .anyRequest().permitAll() // 다른 요청은 모두 허용
        	.and()
        	.csrf().disable() // CSRF 비활성화
        	.cors(); // CORS 허용
        
    }   
    

    // 토큰 유효성 체크
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        RemoteTokenServices remoteTokenService = new RemoteTokenServices();
//        remoteTokenService.setClientId("clientId");
//        remoteTokenService.setClientSecret("secretKey");
//        remoteTokenService.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
//        resources.tokenServices(remoteTokenService);
//    }
    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        try{ 
//             직접 oauth 서버를 호출하여 공개키 읽어서 jwt 디코드 키 등록
        	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            converter.setVerifier(new RsaVerifier(getPublicKeyValue(crudKeyUri)));
            return converter;
        }catch (Exception e){
            return new JwtAccessTokenConverter();
        }
    }

    private String getPublicKeyValue(String uriKey) {
        JsonNode response = Unirest.get(uriKey)
                .asJson().getBody();
        return StringUtils.isEmpty(response.toString()) ? "" : new Gson().fromJson(response.toString(), JWTkey.class).getValue();

        
    }
	

    
}
