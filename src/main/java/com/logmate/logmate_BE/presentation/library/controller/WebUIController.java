package com.logmate.logmate_BE.presentation.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class WebUIController {

  @GetMapping("/board/{userCode}")
  public String getBoard(Model model, @PathVariable String userCode) {
    model.addAttribute("userCode", userCode);
    return "log-list";
  }

}
