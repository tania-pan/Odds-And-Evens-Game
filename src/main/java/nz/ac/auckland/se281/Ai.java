package nz.ac.auckland.se281;

public interface Ai {
  String aiName = "HAL-9000";

  public void setStrategy();

  public int getAiInput();

  public void setAiChoice(String choice);

  public String getAiChoice();
}
