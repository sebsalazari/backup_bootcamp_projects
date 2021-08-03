package com.meli.LinkTrackerAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetricsDTO {
   private String message;
   private Integer totalRedirectsLink;
}
