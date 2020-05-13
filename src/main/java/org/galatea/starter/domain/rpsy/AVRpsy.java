package org.galatea.starter.domain.rpsy;

import java.util.List;
import org.galatea.starter.domain.DailyStockPrices;
import org.galatea.starter.domain.DailyStockPricesId;
import org.springframework.data.repository.CrudRepository;

public interface AVRpsy extends CrudRepository<DailyStockPrices, DailyStockPricesId> {

  List<DailyStockPrices> findBySymbol(String symbol);

}
