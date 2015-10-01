package com.JavaQues;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class TestJpanel extends JPanel {

	@Override
	public void paintComponent(final Graphics g) {
		// Draw Tree Here
		g.drawOval(5, 5, 25, 25);
	}

	public static void main(final String[] args) {
		final JFrame jFrame = new JFrame();
		jFrame.add(new TestJpanel());
		jFrame.setSize(500, 500);
		jFrame.setVisible(true);
	}

}