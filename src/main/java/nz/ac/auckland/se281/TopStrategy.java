package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private Player player;

  public TopStrategy(Player player) {
    this.player = player;
  }

  /**
   * getting the number of fingers to play using the top strategy.
   *
   * @return number of fingers to play
   */
  @Override
  public int selectNumber() {

    // if playerChoice is odd, ai picks same parity number as player
    // if playerChoice is even, ai picks different parity number as player

    if (player.getOdd() > player.getEven()) { // player will likely choose odd
      if (player.getChoice().equals(Choice.ODD)) {
        return Utils.getRandomOddNumber(); // odd + odd = even
      } else if (player.getChoice().equals(Choice.EVEN)) {
        return Utils.getRandomEvenNumber(); // odd + even = odd
      }
    } else if (player.getEven() > player.getOdd()) { // player will likely choose even
      if (player.getChoice().equals(Choice.ODD)) {
        return Utils.getRandomEvenNumber(); // even + even = even
      } else if (player.getChoice().equals(Choice.EVEN)) {
        return Utils.getRandomOddNumber(); // even + odd = odd
      }
    } else {
      // player has picked an equal amount of odds and evens, AI will pick a random number
      return Utils.getRandomNumberRange(0, 5);
    }

    return -1;
  }
}
