package com.jpa.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

//
//	@Bean
//	public Docket user() {
//		  return this.config("1.유저관리", Predicates.or(
//	                PathSelectors.regex("/user/*")
//	        ));
//	}
	
	
    public Docket  config(String groupName, Predicate path) {
        return new Docket(DocumentationType.SWAGGER_2).groupName(groupName).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jpa.sample.controller")) // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                /*.paths(PathSelectors.ant("/*")) // 해당 URL들 필터링*/
                .paths(path)	// 모든 맵핑한걸 다잡는거
                .build();
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}