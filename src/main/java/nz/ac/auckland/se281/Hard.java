package nz.ac.auckland.se281;

public class Hard implements Ai {

  // Easy difficulty only uses the random strategy
  Strategy strategy;
  String choice;

  @Override
  public void setStrategy() {
    Random randomStrategy = new Random();
    this.strategy = randomStrategy;
  }

  @Override
  public int getAiInput() {
    setStrategy();
    return ((Random) strategy).selectNumber();
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
