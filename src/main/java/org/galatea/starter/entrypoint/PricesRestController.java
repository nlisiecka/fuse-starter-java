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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@RestController
@RequiredArgsConstructor
public class PricesRestController {

    @NonNull
    private DBvsAVController dbavcontroller;

    @GetMapping(value = "${mvc.av.getPricesPath}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public List<DailyStockPrices> prices(
        @RequestParam(value = "symbol") final String symbol,
        @RequestParam(value = "days") final Integer days){
        List<DailyStockPrices> result = dbavcontroller.prices(symbol);


       /* pricesrpsy.save(result.get(0));
        pricesrpsy.save(result.get(1));
        pricesrpsy.save(result.get(2));

        List<DailyStockPrices> retrivedprice =  pricesrpsy.findBySymbol(symbol);
        log.info("Customer found with findBySymbol():");
        log.info("--------------------------------");
        log.info(retrivedprice.toString());
        log.info("");*/

        if(days <= result.size()){
            return result.subList(0, days);
        }
        else{
            return result;
        }

    }
}





