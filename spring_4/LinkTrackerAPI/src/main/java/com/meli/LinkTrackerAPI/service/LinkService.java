package com.meli.LinkTrackerAPI.service;

import com.meli.LinkTrackerAPI.model.*;
import com.meli.LinkTrackerAPI.repository.ILinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class LinkService implements ILinkService {

   @Autowired
   ILinkRepository iLinkRepository;

   @Override
   public LinkResponseDTO createLinkDTO(LinkRequestDTO linkRequestDTO) {
      LinkResponseDTO linkResponseDTO = null;
      linkResponseDTO = (isValidURL(linkRequestDTO.getLink())) ? new LinkResponseDTO(generateId()) : null;
      if (linkResponseDTO != null) {
         iLinkRepository.saveLinkCreated(linkRequestDTO, linkResponseDTO.getLinkId());
      }

      return linkResponseDTO;
   }

   @Override
   public String getRedirectLink(String id) {
      return iLinkRepository.getLinkRedirect(id).getUrl();
   }

   @Override
   public MetricsDTO getTotalMetrics(String id) {
      Link aux = iLinkRepository.getLinkMetrics(id);
      return new MetricsDTO("URL: " + aux.getId() + " con ID: " + aux.getId(), aux.getNumRedirects());
   }

   @Override
   public RemoveLinkDTO getInvalidLink(String id) {
      Link aux = iLinkRepository.getLinkInvalid(id);
      return new RemoveLinkDTO("Link: " + aux.getUrl() + " ha quedado invalidado");
   }

   // Se valida si la URL es valida
   public boolean isValidURL(String url) {
      UrlValidator valid = new UrlValidator();
      return valid.isValid(url);
   }

   // Se genera el id unico para el link con la libreria UUID
   public String generateId() {
      UUID uuid = UUID.randomUUID();
      return uuid.toString().substring(0, 8);
   }
}
