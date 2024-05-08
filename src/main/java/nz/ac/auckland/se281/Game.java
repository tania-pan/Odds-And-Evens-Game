package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {

  String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    int round = 1;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // getting a valid human input
    int playerFingies = -1;

    while (playerFingies == -1) {

      MessageCli.ASK_INPUT.printMessage();
      String playerInput = Utils.scanner.nextLine();
      int inputInt = Integer.parseInt(playerInput);

      if (Utils.isInteger(playerInput)) {
        if ((inputInt <= 5) && (inputInt >= 0)) {
          playerFingies = inputInt;
          break;
        }
      }
      MessageCli.INVALID_INPUT.printMessage();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(playerFingies));
  }

  public void endGame() {}

  public void showStats() {}
}
