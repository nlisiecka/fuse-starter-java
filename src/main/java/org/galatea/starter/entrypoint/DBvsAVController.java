package org.galatea.starter.entrypoint;

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
import org.galatea.starter.domain.rpsy.AVRpsy;
import org.galatea.starter.service.AVService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;


@Slf4j
@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@Controller
@RequiredArgsConstructor
public class DBvsAVController {

  @NonNull
  AVRpsy pricesrpsy;

  @NonNull
  private AVService avService;

  public List<DailyStockPrices> prices(String symbol){

    List<DailyStockPrices> result =  pricesrpsy.findBySymbol(symbol);

    log.info("Customer found with findBySymbol():");
    log.info("--------------------------------");
    log.info(result.toString());
    log.info("");

    if(result == null || result.isEmpty()) {
      result = avService.getPrices("TIME_SERIES_DAILY", symbol, "full", "RGRKCZXEPACXPSXK");
      pricesrpsy.saveAll(result);
    }

    return  result;

  }

}
