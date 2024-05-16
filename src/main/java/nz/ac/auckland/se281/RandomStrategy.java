package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  /**
   * getting the number of fingers to play using the random strategy.
   * 
   * @return  number of fingers to play
   */
  @Override
  public int selectNumber() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
