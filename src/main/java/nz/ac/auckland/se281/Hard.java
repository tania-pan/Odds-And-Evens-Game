package nz.ac.auckland.se281;

public class Hard implements Ai {

  /* Hard difficulty AI uses the random strategy for the first three rounds,
  then the AI will switch strategies if it loses the previous round */

  Strategy strategy;
  String choice;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getAiInput(int round, Player player) {
    // setStrategy();
    return strategy.selectNumber();
  }

  @Override
  public void setAiChoice(String choice) {
    this.choice = choice;
  }

  @Override
  public String getAiChoice() {
    return choice;
  }
}
