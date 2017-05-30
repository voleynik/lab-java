package lab.poc.junit;

class Msg {
  private String str;

  public Msg(String str) {
      this.str = str;
  }

  public String getMsgText() {
      return str;
  }

  //~Methods to be tested.
  public Msg add(Msg msg) {
    return new Msg( this.getMsgText().concat(msg.getMsgText()));
  }
}