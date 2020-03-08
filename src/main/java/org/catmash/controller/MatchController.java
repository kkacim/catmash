package org.catmash.controller;

import java.util.List;
import java.util.Set;

import org.catmash.datamodel.Cat;
import org.catmash.service.contract.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match")
public class MatchController implements IMatchService {

  @Autowired
  private IMatchService matchService;

  @GetMapping("/random")
  @Override
  public Set<Cat> getTwoRandomCats() {
    return matchService.getTwoRandomCats();
  }

  @PostMapping("/vote")
  @Override
  public void vote(@RequestParam String winnerId, @RequestParam String loserId) {
    matchService.vote(winnerId, loserId);
  }

  @GetMapping("/bestof")
  @Override
  public List<Cat> getAllCatsSortedByRating() {
    return matchService.getAllCatsSortedByRating();
  }
}
