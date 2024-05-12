package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {

  String playerName;
  Difficulty difficulty;
  Choice choice;
  int round;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    playerName = options[0];
    this.difficulty = difficulty;
    this.choice = choice;
    round = 1;

    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // getting a valid human input

    int inputInt;
    String playerInput;
    boolean firstInput = true;

    do {

      // print correct message based on whether it's the first input or not
      if (firstInput == true) {
        MessageCli.ASK_INPUT.printMessage();
        firstInput = false;
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }

      playerInput = Utils.scanner.nextLine();
      inputInt = Integer.parseInt(playerInput);

    } while (!Utils.isInteger(playerInput) || !(inputInt <= 5) || !(inputInt >= 0));

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerInput);
    round++;
  }

  public void endGame() {}

  public void showStats() {}
}
