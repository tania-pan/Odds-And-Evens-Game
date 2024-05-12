package nz.ac.auckland.se281;

public class Easy implements Ai {

  // Easy difficulty AI only uses the random strategy
  Strategy strategy;
  String choice;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getAiInput(int round, Player player) {
    setStrategy(new Random());
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
