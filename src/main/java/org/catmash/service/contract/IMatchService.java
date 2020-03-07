package org.catmash.service.contract;

import java.util.List;
import java.util.Set;

import org.catmash.datamodel.Cat;

public interface IMatchService {

  /**
   * Get two random cats from the database
   * 
   * @return Two random cats
   */
  Set<Cat> getTwoRandomCats();

  /**
   * Calculate new cats ratings and save it in the database
   * 
   * @param winnerId The winner cat id
   * @param loserId The loser cat id
   */
  void vote(String winnerId, String loserId);

  /**
   * Get all the cats sorted by rating
   * 
   * @return List of all cats sorted by rating
   */
  List<Cat> getAllCatsSortedByRating();
}
