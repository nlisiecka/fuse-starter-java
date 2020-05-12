package org.galatea.starter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
public class PricesData {
  @JsonProperty("Meta Data")
  private Metadata metdata;

  @JsonProperty("Time Series (Daily)")
  public Map<String,DailyStockPrices> timeseries;

}
