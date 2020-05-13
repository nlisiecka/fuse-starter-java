package org.galatea.starter.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
@Entity
@IdClass(DailyStockPricesId.class)
public class DailyStockPrices {

    @Id
    private String symbol;

    @Id
    private String date;

    @JsonProperty("open")
    @JsonAlias("1. open")
    private Double open;

    @JsonProperty("high")
    @JsonAlias("2. high")
    private Double high;

    @JsonProperty("low")
    @JsonAlias("3. low")
    private Double low;

    @JsonProperty("close")
    @JsonAlias("4. close")
    private Double close;

    @JsonProperty("volume")
    @JsonAlias("5. volume")
    private Integer volume;

}
