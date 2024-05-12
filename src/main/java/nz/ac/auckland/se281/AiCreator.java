package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

// This class is the factory for Hal-9000
public class AiCreator {

  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new Easy();
      case MEDIUM:
        return new Medium();
      case HARD:
        return new Hard();
      default:
        return null;
    }
  }
}
