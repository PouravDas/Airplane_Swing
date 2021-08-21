package com.test.gui;

import java.awt.Graphics;

import javax.swing.JComponent;

import com.test.model.Airplane;

public class AirplaneCanvas extends JComponent {

	private int length;
	private int breadth;

	private final int x = 150;
	private final int y = 0;

	public AirplaneCanvas(Airplane airplane) {
		this.length = airplane.getLenght();
		this.breadth = airplane.getBredth();
	}

	@Override
	public void paint(Graphics g) {
		g.drawLine(x, y, x, y + length);
		g.drawLine(x - breadth / 2, (y + length) / 3, x + breadth / 2, y + (y + length) / 3);

	}
}
