package org.galatea.starter.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Builder
public class DailyStockPrices {

    public String symbol;
    public String date;
    public String open;
    public String high;
    public String low;
    public String close;
    public String volume;

}
