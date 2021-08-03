package com.meli.LinkTrackerAPI.controller;

import com.meli.LinkTrackerAPI.model.LinkRequestDTO;
import com.meli.LinkTrackerAPI.model.LinkResponseDTO;
import com.meli.LinkTrackerAPI.model.MetricsDTO;
import com.meli.LinkTrackerAPI.model.RemoveLinkDTO;
import com.meli.LinkTrackerAPI.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {

   @Autowired
   ILinkService iLinkService;

   @PostMapping("")
   public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO)  {
      return new ResponseEntity<>(iLinkService.createLinkDTO(linkRequestDTO), HttpStatus.CREATED);
   }

   @GetMapping("/{linkId}")
   public RedirectView redirectLinkId(@PathVariable String linkId) {
      return new RedirectView(iLinkService.getRedirectLink(linkId));
   }

   @GetMapping("/metrics/{linkId}")
   public ResponseEntity<MetricsDTO> totalRedirectsLink(@PathVariable String linkId){
      return new ResponseEntity<>(iLinkService.getTotalMetrics(linkId), HttpStatus.ACCEPTED);
   }

   @PostMapping("/invalidate/{linkId}")
   public ResponseEntity<RemoveLinkDTO> invalidLink(@PathVariable String linkId){
      return new ResponseEntity<>(iLinkService.getInvalidLink(linkId), HttpStatus.OK);
   }
}
