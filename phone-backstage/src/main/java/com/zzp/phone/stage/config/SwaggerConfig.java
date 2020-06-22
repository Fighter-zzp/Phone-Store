package com.zzp.phone.stage.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * <p>
 * //TODO
 * SwaggerConfig.java
 * </p>
 *
 * @author 佐斯特勒
 * @version v1.0.0
 * @date 2020/5/26 23:49
 * @see SwaggerConfig
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    public ApiInfo createAi() {
        return new ApiInfoBuilder().title("手机商城移动端接口").
                description("SpringBoot项目").
                contact(new Contact("zzp", "http://www.baidu.com", "zzptest@163.com")).build();
    }

    @Bean
    public Docket createD() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAi()).select().
                apis(RequestHandlerSelectors.basePackage("com.zzp.phone.stage.controller")).build();
    }
}
