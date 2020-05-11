package org.galatea.starter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.aspect4log.Log;
import net.sf.aspect4log.Log.Level;
import org.galatea.starter.domain.DailyStockPrices;
import org.springframework.stereotype.Service;


@Slf4j
@Log(enterLevel = Level.INFO, exitLevel = Level.INFO)
@Service
@RequiredArgsConstructor
public class AVService {

  @NonNull
  private AVClient avClient;

 public List<DailyStockPrices> getPrices(final String function, final String symbol, final String apikey){
   if (symbol==null || symbol.isEmpty()) {
     return Collections.emptyList();
   } else {
     String response = avClient.getPrices(function, symbol, apikey);
     response = response.replaceAll(",", "");
     response = response.replaceAll(" ", "");
     String[] tokens = response.split("TimeSeries");
     String token = tokens[1];
     //response = response.replaceAll(token, "");
     token=token.replaceAll("[^\n-.-Z0-9]+","");
     tokens = token.split("\n");
     tokens = Arrays.copyOfRange(tokens, 1, tokens.length-2);

     List <DailyStockPrices> prices= new ArrayList<DailyStockPrices>();

     for(int i=0; i<tokens.length/7; i++){
       DailyStockPrices n = new DailyStockPrices();

       tokens[7*i] = tokens[7*i].substring(1,11);

       tokens[7*i+1] = tokens[7*i+1].substring(5, tokens[7*i+1].length()-1);
       tokens[7*i+2] = tokens[7*i+2].substring(5, tokens[7*i+2].length()-1);
       tokens[7*i+3] = tokens[7*i+3].substring(5, tokens[7*i+3].length()-1);
       tokens[7*i+4] = tokens[7*i+4].substring(5, tokens[7*i+4].length()-1);
       tokens[7*i+5] = tokens[7*i+5].substring(5, tokens[7*i+5].length()-1);

       n.symbol = symbol;
       n.date = tokens[7*i];
       n.open = tokens[7*i+1];
       n.high = tokens[7*i+2];
       n.low = tokens[7*i+3];
       n.close = tokens[7*i+4];
       n.volume = tokens[7*i+5];
       prices.add(n);
     }
     return prices;
   }



 }
}
