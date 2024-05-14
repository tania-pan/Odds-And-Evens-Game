package nz.ac.auckland.se281;

public interface Ai {

  final String aiName = "HAL-9000";
  boolean winLastRound = false;

  public void setWinLastRound(boolean winLastRound);

  public void setStrategy(Strategy strategy);

  public int getAiInput(int round, Player player);

  public void setAiChoice(String choice);

  public String getAiChoice();
}
