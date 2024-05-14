package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Player {

  private String playerName;
  private Choice choice;
  private int oddCount = 0;
  private int evenCount = 0;
  private int winCount = 0;

  public Player(Choice choice, String playerName) {

    this.playerName = playerName;
    this.choice = choice;
  }

  public int getPlayerInput() {
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

    if (Utils.isEven(inputInt)) {
      evenCount++;
    } else {
      oddCount++;
    }

    return Integer.parseInt(playerInput);
  }

  public String getPlayerName() {
    return playerName;
  }

  public Choice getChoice() {
    return choice;
  }

  public int getOdd() {
    return oddCount;
  }

  public int getEven() {
    return evenCount;
  }

  public void addWin(boolean win) {
    this.winCount++;
  }

  public int getWinCount() {
    return winCount;
  }
}
