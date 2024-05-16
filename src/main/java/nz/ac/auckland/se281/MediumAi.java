package nz.ac.auckland.se281;

public class MediumAi implements Ai {

  /* Medium difficulty AI uses random strategy for the first three rounds,
  then top strategy for the rest of the game */

  private Strategy strategy;

  /**
   * keeps track of whether the AI won the last round or not.
   *
   * @param winLastRound a boolean that is true if the AI won the last round and false if the AI
   *     lost the last round
   */
  @Override
  public void setWinLastRound(boolean winLastRound) {}

  /**
   * sets the strategy the AI will use for the round.
   *
   * @param strategy the strategy the AI will use
   */
  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * selects the strategy the medium level AI will use and gets the number of fingers the AI will
   * play.
   *
   * @param round the round that is being played
   * @param player the instance of the player
   * @return the number of fingers the AI will play
   */
  @Override
  public int getAiInput(int round, Player player) {
    if (round <= 3) {
      setStrategy(new RandomStrategy());
    } else {
      setStrategy(new TopStrategy(player));
    }
    return strategy.selectNumber();
  }
}
