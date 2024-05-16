package nz.ac.auckland.se281;

public interface Ai {

  final String aiName = "HAL-9000";

  /**
   * keeps track of whether the AI won the last round or not.
   * 
   * @param winLastRound a boolean that is true if the AI won the last round and false if the AI lost the last round
   */
  public void setWinLastRound(boolean winLastRound);

  /** 
   * sets the strategy the AI will use for the round.
   * 
   * @param strategy the strategy the AI will use
   */
  public void setStrategy(Strategy strategy);

  /** 
   * get the number of fingers the AI will play using the strategy that corresponds to the AI difficulty level.
   * 
   * @param round the round that is being played
   * @param player the instance of the player
   * @return the number of fingers the AI will play
   */
  public int getAiInput(int round, Player player);

}
