package nz.ac.auckland.se281;

public class Medium implements Ai {

  /* Medium difficulty AI uses random strategy for the first three rounds,
  then top strategy for the rest of the game */

  Strategy strategy;
  String choice;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getAiInput(int round, Player player) {
    if (round <= 3) {
      setStrategy(new Random());
    } else {
      setStrategy(new Top(player));
    }
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
