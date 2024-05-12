package nz.ac.auckland.se281;

public class Hard implements Ai {

  // Easy difficulty only uses the random strategy
  Strategy strategy;

  @Override
  public void setStrategy() {
    Random randomStrategy = new Random();
    this.strategy = randomStrategy;
  }

  @Override
  public String getAiInput() {
    setStrategy();
    return Integer.toString(((Random) strategy).selectNumber());
  }
}
