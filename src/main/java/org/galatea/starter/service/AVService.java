package org.galatea.starter.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Level;
import org.galatea.starter.domain.PricesData;
import org.springframework.stereotype.Service;


@Slf4j
@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@Service
@RequiredArgsConstructor
public class AVService {

  @NonNull
  private AVClient avClient;

 public PricesData getPrices(final String function, final String symbol, final String apikey) {
   return avClient.getPrices(function, symbol, apikey);
 }
}
