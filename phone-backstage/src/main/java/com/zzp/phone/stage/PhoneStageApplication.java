package com.zzp.phone.stage;

import com.zzp.phone.stage.util.SnowFlakeIdUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Phone主接口
 * <p>
 * //TODO
 * PhoneStageApplication.java
 * </p>
 *
 * @author 佐斯特勒
 * @version v1.0.0
 * @date 2020/5/25 20:08
 * @see PhoneStageApplication
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.zzp.phone.stage.mapper")
@EnableTransactionManagement
public class PhoneStageApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(PhoneStageApplication.class, args);
    }

    /**
     * 添加资源控制器允许knife4j
     * @param registry .
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 雪花id生成器注入
     *
     * @return .
     */
    @Bean
    public SnowFlakeIdUtil getIdWorker() {
        return new SnowFlakeIdUtil(1, 1);
    }
}
