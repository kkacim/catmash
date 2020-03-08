package org.catmash.service.contract;

import java.util.Set;

import org.catmash.datamodel.Cat;

public interface IEloService {

  /**
   * Calculate new ratings after a battle
   * 
   * @param winner The winner cat
   * @param loser The loser cat
   * @return The cats with their new ratings
   */
  Set<Cat> calculateNewRatings(Cat winner, Cat loser);
}
