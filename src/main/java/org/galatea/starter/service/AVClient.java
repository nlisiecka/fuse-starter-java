package org.galatea.starter.service;

import feign.Headers;
import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Level;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@FeignClient(name = "AV", url = "${spring.rest.avBasePath}")
public interface AVClient {

  @GetMapping("/query")
  @Headers("Content-Type: application/json")
  String getPrices(
      @RequestParam(required = true) String function,
      @RequestParam(required = true) String symbol,
      @RequestParam(required = true) String apikey);
}

