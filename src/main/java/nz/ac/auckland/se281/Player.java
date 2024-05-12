package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Player {

  private String playerName;
  private Choice choice;

  public Player(Choice choice, String playerName) {

    this.playerName = playerName;
    this.choice = choice;
  }

  public static int getPlayerInput() {
    String playerInput;
    int inputInt = 0;

    MessageCli.ASK_INPUT.printMessage();
    playerInput = Utils.scanner.nextLine();
    if (Utils.isInteger(playerInput)) {
      inputInt = Integer.parseInt(playerInput);
    }

    while (!(inputInt <= 5) || !(inputInt >= 0)) {
      MessageCli.INVALID_INPUT.printMessage();
      playerInput = Utils.scanner.nextLine();
      if (Utils.isInteger(playerInput)) {
        inputInt = Integer.parseInt(playerInput);
      }
    }

    return Integer.parseInt(playerInput);
  }

  public String getPlayerName() {
    return playerName;
  }

  public Choice getChoice() {
    return choice;
  }
}
