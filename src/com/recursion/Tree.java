/*package com.recursion;

import acm.program.*;
import acm.graphics.*;

public class Tree extends GraphicsProgram {
	@Override
	public void run() {
		drawTree(120, 200, 50, 90);
	}

	public void drawTree(final double x0, final double y0, final double len, final double angle) {
		if(len > 2) {
			final double x1 = x0 + len * GMath.cosDegrees(angle);
			final double y1 = y0 - len * GMath.sinDegrees(angle);

			add(new GLine(x0, y0, x1, y1));
			drawTree(x1, y1, len * 0.75, angle + 30);
			drawTree(x1, y1, len * 0.66, angle - 50);
		}
	}
}

 */