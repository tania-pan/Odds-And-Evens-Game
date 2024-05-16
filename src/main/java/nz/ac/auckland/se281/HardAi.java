package nz.ac.auckland.se281;

public class HardAi implements Ai {

  /* Hard difficulty AI uses the random strategy for the first three rounds,
  then the AI will switch strategies if it loses the previous round */

  private Strategy strategy;
  private String choice;
  private boolean winLastRound = false;

  /**
   * keeps track of whether the AI won the last round or not.
   * 
   * @param winLastRound a boolean that is true if the AI won the last round and false if the AI lost the last round
   */
  public void setWinLastRound(boolean winLastRound) {
    this.winLastRound = winLastRound;
  }

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
   * selects the strategy the hard level AI will use and gets the number of fingers the AI will play
   * 
   * @param round the round that is being played
   * @param player the instance of the player
   * @return the number of fingers the AI will play
   */
  @Override
  public int getAiInput(int round, Player player) {
    if (round <= 3) {
      setStrategy(new RandomStrategy());
    } else if (winLastRound == false) {
      if (strategy instanceof RandomStrategy) {
        setStrategy(new TopStrategy(player));
      } else if (strategy instanceof TopStrategy) {
        setStrategy(new RandomStrategy());
      }
    }

    return strategy.selectNumber();
  }

  
  /**
   * sets the AI's choice of odd or even, which is opposite to the player's choice
   * 
   * @param choice  the AI's choice, 
   */
  @Override
  public void setAiChoice(String choice) {
    this.choice = choice;
  }

    /**
   * gets the AI's choice of odd or even, which is opposite to the player's choice
   * 
   * @return choice  the AI's choice, 
   */
  @Override
  public String getAiChoice() {
    return choice;
  }
}
