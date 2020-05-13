package org.galatea.starter.service;

import feign.Headers;
import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Level;
import org.galatea.starter.domain.PricesData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@FeignClient(name = "AV", url = "${spring.rest.avBasePath}", configuration = AVConfigs.class)
public interface AVClient {

  @GetMapping("/query")
  @Headers("Content-Type: application/json")
  PricesData getPrices(
      @RequestParam(required = true) String function,
      @RequestParam(required = true) String symbol,
      @RequestParam String outputsize,
      @RequestParam(required = true) String apikey);
}

