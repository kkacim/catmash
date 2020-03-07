package org.catmash.service;

import java.util.HashSet;
import java.util.Set;

import org.catmash.datamodel.Cat;
import org.catmash.datamodel.Outcome;
import org.catmash.service.contract.IEloService;
import org.springframework.stereotype.Service;

@Service
public class EloServiceImpl implements IEloService {

  @Override
  public Set<Cat> calculateNewRatings(Cat winner, Cat loser) {
    winner.setRating(calculateNewRating(winner.getRating(), calculateWinOdds(winner.getRating(), loser.getRating()), Outcome.WIN.getScore()));
    loser.setRating(calculateNewRating(loser.getRating(), calculateWinOdds(loser.getRating(), winner.getRating()), Outcome.LOSS.getScore()));

    Set<Cat> catSet = new HashSet<>();
    catSet.add(winner);
    catSet.add(loser);
    return catSet;
  }

  /**
   * Calculate win odds of a cat vs his opponent
   *
   * @see <a href="https://en.wikipedia.org/wiki/Elo_rating_system#Mathematical_details">Source</a>
   *
   * @param playerRating The player cat rating
   * @param opponentRating The opponent cat rating
   * @return Win odds
   */
  private double calculateWinOdds(int playerRating, int opponentRating) {
    return 1 / (1 + Math.pow(10, (opponentRating - playerRating) / 400.0));
  }

  /**
   * Calculate new rating of a cat after a battle. For now an average fix k-factor of 24 is used.
   * 
   * @see <a href="https://en.wikipedia.org/wiki/Elo_rating_system#Mathematical_details">Source</a>
   *
   * @param rating Old rating
   * @param winOdds Win odds
   * @param score The battle score
   * @return New rating
   */
  private int calculateNewRating(int rating, double winOdds, float score) {
    return (int) Math.round(rating + 24 * (score - winOdds));
  }
}
