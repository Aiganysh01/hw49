package com.example.homework49.controller;

import com.example.homework49.model.Candidate;
import com.example.homework49.service.CandidateDataModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/error")
    public static String handleError() {
        return "error";
    }

    @RequestMapping("/candidates")
    public String candidates(Model model){
        model.addAttribute("candidates", CandidateDataModel.getCandidates());
        return "candidates";
    }

    @GetMapping("/votes")
    public String votes(Model model){
        model.addAttribute("candidates", CandidateDataModel.getCandidates());
        return "votes";
    }

    @GetMapping("/thankyou")
    public String thankyou(@RequestParam String name, Model model){
        Candidate candidate = CandidateDataModel.checkCandidate(name);
        model.addAttribute("thankyou", candidate);
        return "thankyou";
    }

}
