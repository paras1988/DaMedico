package com.recursion;

import java.awt.*;
import acm.program.*;
import acm.graphics.*;

public class Sierpinski extends GraphicsProgram {
	@Override
	public void run() {
		// draw black background square
		final GRect box = new GRect(20, 20, 242, 242);
		box.setFilled(true);
		add(box);

		// recursively draw all the white squares on top
		drawGasket(20, 20, 243);
	}

	public void drawGasket(final int x, final int y, final int side) {
		// draw single white square in middle
		final int sub = side / 3; // length of sub-squares
		final GRect box = new GRect(x + sub, y + sub, sub - 1, sub - 1);
		box.setFilled(true);
		box.setColor(Color.WHITE);
		add(box);

		if(sub >= 3) {
			// now draw eight sub-gaskets around the white square
			drawGasket(x,           y, sub);
			drawGasket(x + sub,     y, sub);
			drawGasket(x + 2 * sub, y, sub);
			drawGasket(x,           y + sub, sub);
			drawGasket(x + 2 * sub, y + sub, sub);
			drawGasket(x,           y + 2 * sub, sub);
			drawGasket(x + sub,     y + 2 * sub, sub);
			drawGasket(x + 2 * sub, y + 2 * sub, sub);
		}
	}
}

