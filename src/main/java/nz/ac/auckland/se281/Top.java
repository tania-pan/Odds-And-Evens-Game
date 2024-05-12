package nz.ac.auckland.se281;

public class Top implements Strategy {

  int oddCount = 0;
  int evenCount = 0;

  public void setCounts() {}

  @Override
  public int selectNumber() {
    setCounts();
    if (oddCount > evenCount) {
      return Utils.getRandomOddNumber();
    } else if (oddCount < evenCount) {
      return Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
