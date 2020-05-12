package org.galatea.starter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
public class Metadata {
  @JsonProperty("1. Information")
  private String info;

  @JsonProperty("2. Symbol")
  private String symbol;

  @JsonProperty("3. Last Refreshed")
  private String last_refreshed;

  @JsonProperty("4. Output Size")
  private String output_size;

  @JsonProperty("5. Time Zone")
  private String time_zone;

}
