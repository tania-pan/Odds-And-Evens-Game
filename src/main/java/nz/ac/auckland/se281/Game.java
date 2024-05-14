package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {

  Player player;
  Ai HAL9000;
  Difficulty difficulty;
  int round;
  boolean gameStarted = false;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    Player player = new Player(choice, options[0]);
    Ai HAL9000 = AiCreator.createAi(difficulty);

    this.player = player;
    this.HAL9000 = HAL9000;
    this.difficulty = difficulty;
    round = 1;
    gameStarted = true;

    MessageCli.WELCOME_PLAYER.printMessage(player.getPlayerName());
  }

  public void play() {

    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    round++;

    // getting human player input
    int playerInput = player.getPlayerInput();
    MessageCli.PRINT_INFO_HAND.printMessage(player.getPlayerName(), Integer.toString(playerInput));

    // getting AI input
    int aiInput = HAL9000.getAiInput(round, player);
    MessageCli.PRINT_INFO_HAND.printMessage(Ai.aiName, Integer.toString(aiInput));

    // determining winner
    determineWinner(playerInput, aiInput);
  }

  public void endGame() {}

  public void showStats() {}

  public void determineWinner(int playerInput, int aiInput) {
    int result = playerInput + aiInput;
    Choice resultParity;

    if (Utils.isEven(result)) {
      resultParity = Choice.EVEN;
    } else {
      resultParity = Choice.ODD;
    }

    if (resultParity.equals(player.getChoice())) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(result), resultParity.name(), player.getPlayerName());
      HAL9000.setWinLastRound(false);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(result), resultParity.name(), Ai.aiName);
      HAL9000.setWinLastRound(true);
    }
  }
}
