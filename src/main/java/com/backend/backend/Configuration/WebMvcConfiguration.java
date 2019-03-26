package com.backend.backend.Configuration;

import com.backend.backend.Component.RequestTimeInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * WebMvcConfiguration
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

  @Autowired
  @Qualifier("requestTimeInterceptor")
  private RequestTimeInterceptor requestTimeInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(requestTimeInterceptor);
  }


}