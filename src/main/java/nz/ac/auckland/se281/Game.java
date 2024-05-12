package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {

  Player humanPlayer;
  Difficulty difficulty;
  int round;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    Player humanPlayer = new Player(choice, options[0]);

    this.humanPlayer = humanPlayer;
    this.difficulty = difficulty;
    round = 1;

    MessageCli.WELCOME_PLAYER.printMessage(humanPlayer.getPlayerName());
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.PRINT_INFO_HAND.printMessage(humanPlayer.getPlayerName(), Player.getPlayerInput());
    round++;
  }

  public void endGame() {}

  public void showStats() {}
}
