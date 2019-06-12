package br.pro.hashi.ensino.desagil.aps.model;

import br.pro.hashi.ensino.desagil.aps.view.GateView;

public class DeMux extends Gate {
    NandGate nand1;
    NandGate nand2;
    NandGate nand3;
    NandGate nand4;
    NandGate nand5;

    public DeMux() {
        super("DeMux", 2, 2);

        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();
        nand4 = new NandGate();
        nand5 = new NandGate();

        nand4.connect(0, nand2);
        nand4.connect(1, nand2);
        nand5.connect(0, nand3);
        nand5.connect(1, nand3);
        nand2.connect(1, nand1);
    }

    @Override
    public boolean read(int outputPin) {
        if (outputPin != 0) {
            throw new IndexOutOfBoundsException(outputPin);
        }
        return nand4.read();
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        switch (inputPin) {
            case 0:
                nand1.connect(0, emitter);
                nand1.connect(1, emitter);
                nand3.connect(0, emitter);
                break;
            case 1:
                nand2.connect(0, emitter);
                nand3.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputPin);
        }
    }
}
