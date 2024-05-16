package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {

  /**
   * creates the instance of the AI with the desired difficulty.
   * 
   * @param difficulty  the difficulty the player chose when starting a new game
   * @return  an instance of the AI with the desired difficulty
   */
  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();
      case MEDIUM:
        return new MediumAi();
      case HARD:
        return new HardAi();
      default:
        return null;
    }
  }
}
