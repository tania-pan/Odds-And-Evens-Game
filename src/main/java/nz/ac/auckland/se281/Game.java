package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {

  Player player;
  Difficulty difficulty;
  int round;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    Player humanPlayer = new Player(choice, options[0]);

    this.player = humanPlayer;
    this.difficulty = difficulty;
    round = 1;

    MessageCli.WELCOME_PLAYER.printMessage(player.getPlayerName());
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.PRINT_INFO_HAND.printMessage(player.getPlayerName(), Player.getPlayerInput());
    round++;

    // creating AI instance
    Ai Hal9000 = AiCreator.createAi(difficulty);
    MessageCli.PRINT_INFO_HAND.printMessage(Ai.aiName, Hal9000.getAiInput().toString());
  }

  public void endGame() {}

  public void showStats() {}
}
