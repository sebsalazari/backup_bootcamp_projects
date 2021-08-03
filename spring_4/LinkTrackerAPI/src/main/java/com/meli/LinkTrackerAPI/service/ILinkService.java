package com.meli.LinkTrackerAPI.service;

import com.meli.LinkTrackerAPI.model.LinkRequestDTO;
import com.meli.LinkTrackerAPI.model.LinkResponseDTO;
import com.meli.LinkTrackerAPI.model.MetricsDTO;
import com.meli.LinkTrackerAPI.model.RemoveLinkDTO;

public interface ILinkService {
   LinkResponseDTO createLinkDTO (LinkRequestDTO linkRequestDTO);
   String getRedirectLink (String id, String password);
   MetricsDTO getTotalMetrics (String id);
   RemoveLinkDTO getInvalidLink (String id);
}
