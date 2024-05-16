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

  /** 
   * gets the number of fingers the player wishes to play for that round.
   * 
   * @return returns the number of finger the player wishes to play for that round
   */
  public int getPlayerInput() {
    String playerInput;
    int inputInt = 0;

    MessageCli.ASK_INPUT.printMessage();
    playerInput = Utils.scanner.nextLine();
    if (Utils.isInteger(playerInput)) {
      inputInt = Integer.parseInt(playerInput);
    }

    // input must be an integer between 0-5
    while (!(inputInt <= 5) || !(inputInt >= 0)) {
      MessageCli.INVALID_INPUT.printMessage();
      playerInput = Utils.scanner.nextLine();
      if (Utils.isInteger(playerInput)) {
        inputInt = Integer.parseInt(playerInput);
      }
    }

    // keep track of the number of odd or even numbers the player chooses
    if (Utils.isEven(inputInt)) {
      evenCount++;
    } else {
      oddCount++;
    }

    return Integer.parseInt(playerInput);
  }

  /**  
   * gets player name.
   * 
   * @return returns player name
   */
  public String getPlayerName() {
    return playerName;
  }

  /**  
   * gets player choice for the game.
   * 
   * @return returns player's choice
   */
  public Choice getChoice() {
    return choice;
  }

  /**  
   * gets the number of odd inputs the player has played.
   * 
   * @return returns the odd number input count
   */
  public int getOdd() {
    return oddCount;
  }

  /**  
   * gets the number of even inputs the player has played.
   * 
   * @return returns the even number input count
   */
  public int getEven() {
    return evenCount;
  }

  /**
   * increases the number of rounds the player has won.
   */
  public void addWin() {
    this.winCount++;
  }

  /**
   * gets the number of rounds the player has won.
   * 
   * @return  returns the number of rounds the player has won
   */
  public int getWinCount() {
    return winCount;
  }
}
