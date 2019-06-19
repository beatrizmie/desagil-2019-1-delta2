package br.pro.hashi.ensino.desagil.aps.model;

public class HalfAdder extends Gate {
  private final AndGate and;
  private final XorGate xor;

  public HalfAdder() {
    super("HalfAdder", 2, 2);

    and = new AndGate();
    xor = new XorGate();

  }

  @Override
  public boolean read(int outputPin) {
    if (outputPin == 0) {
      return xor.read();
    } if (outputPin == 1) {
      return and.read();
    } else {
      throw new IndexOutOfBoundsException(outputPin);
    }
  }


  @Override
  public void connect(int inputPin, SignalEmitter emitter) {
    switch (inputPin) {
      case 0:
        and.connect(0,emitter);
        xor.connect(0,emitter);
        break;
      case 1:
        and.connect(1,emitter);
        xor.connect(1,emitter);
        break;
      default:
        throw new IndexOutOfBoundsException(inputPin);
    }
  }
}

