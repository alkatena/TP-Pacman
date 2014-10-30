package com.grupo2.balls;

/**
 *
 * @author mauri
 */
public class BigBall implements Ball {

    @Override
    public int isEaten() {
        // INFORMAR EL EVENTO "BOLA GRANDE COMIDA" Y SETEARLE A LA CELDA NULLBALL
        return 30;
    }

    @Override
    public boolean isEatable() {
        return true;
	}

	@Override
	public String toString() {
		return "bolon";
	}

}
