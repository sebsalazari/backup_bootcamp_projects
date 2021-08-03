package com.meli.LinkTrackerAPI.repository;

import com.meli.LinkTrackerAPI.model.Link;
import com.meli.LinkTrackerAPI.model.LinkRequestDTO;

public interface ILinkRepository {
   void saveLinkCreated (LinkRequestDTO linkRequestDTO, String linkId);
   Link getLinkRedirect (String id);
   Link getLinkMetrics (String id);
   Link getLinkInvalid (String id);
}
