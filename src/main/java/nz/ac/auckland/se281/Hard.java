package nz.ac.auckland.se281;

public class Hard implements Ai {

  /* Hard difficulty AI uses the random strategy for the first three rounds,
  then the AI will switch strategies if it loses the previous round */

  Strategy strategy;
  String choice;
  boolean winLastRound = false;

  public void setWinLastRound(boolean winLastRound) {
    this.winLastRound = winLastRound;
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int getAiInput(int round, Player player) {
    if (round <= 3) {
      setStrategy(new Random());
    } else if (winLastRound == false) {
      if (strategy instanceof Random) {
        setStrategy(new Top(player));
      } else if (strategy instanceof Top) {
        setStrategy(new Random());
      }
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
