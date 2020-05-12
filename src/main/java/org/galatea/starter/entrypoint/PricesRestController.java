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
import org.galatea.starter.service.AVService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@Validated
@RestController
@RequiredArgsConstructor
public class PricesRestController {

    @NonNull
    private AVService avService;

    @GetMapping(value = "${mvc.av.getPricesPath}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public List<DailyStockPrices> prices(
        @RequestParam(value = "symbol") final String symbol,
        @RequestParam(value = "days") final Integer days){
        PricesData response = avService.getPrices("TIME_SERIES_DAILY", symbol, "RGRKCZXEPACXPSXK");
        Map<String, DailyStockPrices> response_timeseries = response.timeseries;
        response_timeseries.forEach((k, v) -> v.setDate(k));
        response_timeseries.forEach((k, v) -> v.setSymbol(symbol));
        List<DailyStockPrices> result = new ArrayList<DailyStockPrices>(response_timeseries.values());
        if(days <= result.size()){
            return result.subList(0, days);
        }
        else{
            return result;
        }

    }
}



    //@RequestParam(value = "days") final Integer days)

 /*   @GetMapping(value = "${mvc.av.getPricesPath}", produces = {
       MediaType.APPLICATION_JSON_VALUE})
    public PricesData prices(
        @RequestParam(value = "symbol") final String symbol){
    PricesData result = avService.getPrices("TIME_SERIES_DAILY", symbol,"RGRKCZXEPACXPSXK");
    return result;
    /*if(days <= result.size()){
        return result.subList(0, days);
    }
    else{
        return result;
    }

    /*Map<String, DailyStockPrices> map = result.timeSeries.get(0);
    Set<Entry<String,DailyStockPrices>> s = map.entrySet();
    String key=null;
    for (Map.Entry<String, DailyStockPrices> entry : s)
    {
        key = entry.getKey();
    }
    if(key==null || key.isEmpty()) return "hello";
    return key;
    //return "hello";*/



    /*@GetMapping("/prices")
    public DailyStockPrices prices(@RequestParam(value = "stock") String stock){
      return new DailyStockPrices(stock);

    }*/



