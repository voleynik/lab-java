package lab.junit;

class Money {
  private int amount;

  public Money(int amount) {
      this.amount = amount;
  }

  public int getAmount() {
      return amount;
  }

  public Money add(Money m) {
    return new Money( this.getAmount() + m.getAmount());
  }
}