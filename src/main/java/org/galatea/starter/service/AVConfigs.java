package org.galatea.starter.service;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AVConfigs {

  @Bean
  public Decoder feignDecoder() {
    return new JacksonDecoder();
  }

 /*public ObjectMapper customObjectMapper() {
   ObjectMapper objectMapper = new ObjectMapper();
  objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
   objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

   return objectMapper;

 }*/

}
