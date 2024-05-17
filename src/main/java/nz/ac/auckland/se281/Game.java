package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {

  private Player player;
  private Ai hal9000;
  private int round;
  private boolean gameStarted = false;

  /**
   * starts a new game of Odd or Even.
   *
   * @param difficulty difficulty of AI opponent
   * @param choice player's guess of odd or even
   * @param options array that contains the player's inputs of name, difficulty and choice
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // initialise player and AI
    Player player = new Player(choice, options[0]);
    Ai hal9000 = AiFactory.createAi(difficulty);

    // overrides or resets particulars from previous game
    this.player = player;
    this.hal9000 = hal9000;
    round = 0;
    gameStarted = true;

    MessageCli.WELCOME_PLAYER.printMessage(player.getPlayerName());
  }

  /** starts and plays a new round of an existing game. */
  public void play() {

    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // getting AI and player inputs for the round
    int aiInput = hal9000.getAiInput(round, player);
    int playerInput = player.getPlayerInput();

    // printing AI and player inputs for the round
    MessageCli.PRINT_INFO_HAND.printMessage(player.getPlayerName(), Integer.toString(playerInput));
    MessageCli.PRINT_INFO_HAND.printMessage(Ai.aiName, Integer.toString(aiInput));

    // determining winner
    determineWinner(playerInput, aiInput);
  }

  /**
   * ends the game and prints the statistics of wins and losses for the player and the AI and prints
   * the winner of the game.
   */
  public void endGame() {

    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    showStats();

    // print winner of the game or tie
    if (player.getWinCount() > (round - player.getWinCount())) {
      MessageCli.PRINT_END_GAME.printMessage(player.getPlayerName());
    } else if ((round - player.getWinCount()) > player.getWinCount()) {
      MessageCli.PRINT_END_GAME.printMessage(Ai.aiName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage(Ai.aiName);
    }

    gameStarted = false;
  }

  /** prints the statistics of wins and losses for the player and the AI. */
  public void showStats() {

    // if game has not started, do not show stats
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print wins and losses of player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player.getPlayerName(),
        Integer.toString(player.getWinCount()),
        Integer.toString(round - player.getWinCount()));

    // print wins and losses of AI
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        Ai.aiName,
        Integer.toString(round - player.getWinCount()),
        Integer.toString(player.getWinCount()));
  }

  /**
   * calculates the winner of a round and prints the outcome of a round.
   *
   * @param playerInput the number of fingers that the player selects for a round
   * @param aiInput the number of fingers that the AI selects for a round
   */
  public void determineWinner(int playerInput, int aiInput) {
    int result = playerInput + aiInput;
    Choice resultParity;

    // determine if the sum of the player and AI inputs is odd or even
    if (Utils.isEven(result)) {
      resultParity = Choice.EVEN;
    } else {
      resultParity = Choice.ODD;
    }

    // determine winner of the round and print outcomes
    if (resultParity.equals(player.getChoice())) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(result), resultParity.name(), player.getPlayerName());
      hal9000.setWinLastRound(false);
      player.addWin();
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(result), resultParity.name(), Ai.aiName);
      hal9000.setWinLastRound(true);
    }
  }
}
