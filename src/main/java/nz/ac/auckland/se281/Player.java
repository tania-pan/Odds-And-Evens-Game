package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Player {

  private String playerName;
  private Choice choice;

  public Player(Choice choice, String playerName) {

    this.playerName = playerName;
    this.choice = choice;

    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public static String getPlayerInput() {
    String playerInput;
    int inputInt;

    MessageCli.ASK_INPUT.printMessage();
    playerInput = Utils.scanner.nextLine();
    inputInt = Integer.parseInt(playerInput);

    while (!Utils.isInteger(playerInput) || !(inputInt <= 5) || !(inputInt >= 0)) {
      MessageCli.INVALID_INPUT.printMessage();
      playerInput = Utils.scanner.nextLine();
      inputInt = Integer.parseInt(playerInput);
    }

    return playerInput;
  }

  public String getPlayerName() {
    return playerName;
  }

  public Choice getChoice() {
    return choice;
  }
}
