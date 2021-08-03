package com.meli.LinkTrackerAPI.service;

import com.meli.LinkTrackerAPI.exception.PasswordIncorrectException;
import com.meli.LinkTrackerAPI.exception.URLInvalidException;
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
      if (isValidURL(linkRequestDTO.getLink())) {
         linkResponseDTO = new LinkResponseDTO(generateId());
         iLinkRepository.saveLinkCreated(linkRequestDTO, linkResponseDTO.getLinkId());
      } else {
         throw new URLInvalidException(linkRequestDTO.getLink());
      }

      return linkResponseDTO;
   }

   @Override
   public String getRedirectLink(String id, String password) {
      Link aux = iLinkRepository.getLinkRedirect(id);
      if (aux.getPassword().equals(password))
         return aux.getUrl();
      else
         throw new PasswordIncorrectException();
   }

   @Override
   public MetricsDTO getTotalMetrics(String id) {
      Link aux = iLinkRepository.getLinkMetrics(id);
      return new MetricsDTO("URL: " + aux.getUrl() + " con ID: " + aux.getId(), aux.getNumRedirects());
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
