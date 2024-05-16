package nz.ac.auckland.se281;

public class EasyAi implements Ai {

  // Easy difficulty AI only uses the random strategy
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
   * get the number of fingers the AI will play using the random strategy.
   *
   * @param round the round that is being played
   * @param player the instance of the player
   * @return the number of fingers the AI will play
   */
  @Override
  public int getAiInput(int round, Player player) {
    setStrategy(new RandomStrategy());
    return strategy.selectNumber();
  }
}
