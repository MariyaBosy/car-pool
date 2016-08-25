package com.practo.jedi.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practo.jedi.carpool.data.dto.ListingFilterDTO;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.model.SourceModel;
import com.practo.jedi.carpool.service.ListingService;
import com.practo.jedi.carpool.service.SourceService;

@Controller
public class ApplicationController {
  private int itemsPerPage = 10;

  @Autowired
  private ListingService listingService;

  @Autowired
  private SourceService sourceService;

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/search")
  public String search(ListingFilterDTO filters, Pageable pageable, Model model) {
    Iterable<ListingModel> listings = listingService.filter(filters, updatePageable(pageable, itemsPerPage));
    model.addAttribute("listings", listings);
    Iterable<SourceModel> sources = sourceService.get();
    model.addAttribute("sources", sources);
    return "search";
  }

  @RequestMapping("/post")
  public String post() {
    return "post";
  }
}
