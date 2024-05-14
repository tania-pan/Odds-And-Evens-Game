package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Top implements Strategy {

  Player player;

  public Top(Player player) {
    this.player = player;
  }

  @Override
  public int selectNumber() {

    // DELETE DUPLICATE CODE

    if (player.getChoice().equals(Choice.ODD)) {
      if (player.getOdd() > player.getEven()) {
        return Utils.getRandomOddNumber();
      } else if (player.getEven() > player.getOdd()) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    } else if (player.getChoice().equals(Choice.EVEN)) {
      if (player.getOdd() > player.getEven()) {
        return Utils.getRandomEvenNumber();
      } else if (player.getEven() > player.getOdd()) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    } else {
      return 0;
    }
  }
}
