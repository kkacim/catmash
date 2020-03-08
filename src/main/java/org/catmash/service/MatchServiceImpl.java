package org.catmash.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.catmash.datamodel.Cat;
import org.catmash.repository.CatRepository;
import org.catmash.service.contract.IEloService;
import org.catmash.service.contract.IMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements IMatchService {

  @Autowired
  private CatRepository catRepository;
  @Autowired
  private IEloService eloService;

  @Override
  public Set<Cat> getTwoRandomCats() {
    return catRepository.findCatRandom();
  }

  @Override
  public void vote(String winnerId, String loserId) {
    try {
      Cat winnerCat = catRepository.findById(winnerId).orElseThrow(() -> new NoSuchElementException("No cat found with id " + winnerId));
      Cat loserCat = catRepository.findById(loserId).orElseThrow(() -> new NoSuchElementException("No cat found with id " + loserId));
      catRepository.saveAll(eloService.calculateNewRatings(winnerCat, loserCat));
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Cat> getAllCatsSortedByRating() {
    return catRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
  }
}
