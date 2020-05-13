package org.galatea.starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Level;
import org.galatea.starter.domain.DailyStockPrices;
import org.galatea.starter.domain.PricesData;
import org.springframework.stereotype.Service;


@Slf4j
@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@Service
@RequiredArgsConstructor
public class AVService {

  @NonNull
  private AVClient avClient;

 public List<DailyStockPrices> getPrices(final String function, final String symbol, final String outputsize, final String apikey) {
   PricesData response = avClient.getPrices(function, symbol, outputsize, apikey);
   Map<String, DailyStockPrices> response_timeseries = response.timeseries;
   response_timeseries.forEach((k, v) -> v.setDate(k));
   response_timeseries.forEach((k, v) -> v.setSymbol(symbol));
   List result = new ArrayList<DailyStockPrices>(response_timeseries.values());
   return result;

 }
}
