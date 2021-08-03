package com.meli.LinkTrackerAPI.repository;

import com.meli.LinkTrackerAPI.exception.LinkIdInvalidException;
import com.meli.LinkTrackerAPI.model.Link;
import com.meli.LinkTrackerAPI.model.LinkRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class LinkRepository implements ILinkRepository {

   private List<Link> listLinks = new ArrayList<>();

   @Override
   public void saveLinkCreated(LinkRequestDTO linkRequestDTO, String linkId) {
      Link link = new Link(linkRequestDTO.getLink(), linkId, linkRequestDTO.getPassword(), 0);
      listLinks.add(link);
   }

   @Override
   public Link getLinkRedirect(String id) {
      Link link = null;
      for (Link item : listLinks) {
         if (item.getId().equals(id)) {
            item.setNumRedirects(item.getNumRedirects() + 1);
            link = item;
         }
      }
      if (link == null) throw new LinkIdInvalidException(id);
      return link;
   }

   @Override
   public Link getLinkMetrics(String id) {
      return getLinkById(id);
   }

   @Override
   public Link getLinkInvalid(String id) {
      Link link = getLinkById(id);
      int index = listLinks.indexOf(link);
      return listLinks.remove(index);
   }

   public Link getLinkById(String id) {
      Link link = null;
      for (Link item : listLinks) {
         if (item.getId().equals(id)) {
            link = item;
         }
      }
      if (link == null) throw new LinkIdInvalidException(id);
      return link;
   }

}
