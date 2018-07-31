package Interfaces;

import customView.PinBox;
import enums.PinBoxState;

public interface PinBoxListerner {
    public void pinBox(PinBox pinBox, PinBoxState pinBoxState);
}
