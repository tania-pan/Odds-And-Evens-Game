package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Game {

  Player player;
  Ai Hal9000;
  Difficulty difficulty;
  int round;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    Player player = new Player(choice, options[0]);
    Ai Hal9000 = AiCreator.createAi(difficulty);

    this.player = player;
    this.Hal9000 = Hal9000;
    this.difficulty = difficulty;
    round = 1;

    MessageCli.WELCOME_PLAYER.printMessage(player.getPlayerName());
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    round++;

    // getting human player input
    int playerInput = Player.getPlayerInput();
    MessageCli.PRINT_INFO_HAND.printMessage(player.getPlayerName(), Integer.toString(playerInput));

    // getting AI input
    int aiInput = Hal9000.getAiInput();
    MessageCli.PRINT_INFO_HAND.printMessage(Ai.aiName, Integer.toString(aiInput));

    // determining winner
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
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(result), resultParity.name(), Ai.aiName);
    }
  }

  public void endGame() {}

  public void showStats() {}
}
