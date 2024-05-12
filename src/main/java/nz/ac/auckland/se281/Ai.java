package nz.ac.auckland.se281;

public interface Ai {

  String aiName = "HAL-9000";

  public void setStrategy(Strategy strategy);

  public int getAiInput(int round, Player player);

  public void setAiChoice(String choice);

  public String getAiChoice();
}
