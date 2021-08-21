package com.test.gui;

import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.BoxLayout;

import com.test.model.Airplane;

public class PanelRight extends Panel {

	private TextArea l = null;
	private Label label_l = null;

	private TextArea b = null;
	private Label label_b = null;

	private AirplaneCanvas canvas = null;

	private static final String lengthTxt = "Input length : ";
	private static final String bresdthTxt = "Input breadth : ";

	private Airplane airplane = null;

	public PanelRight(Airplane airplane) {

		this.airplane = airplane;

		label_l = new Label(lengthTxt);
		label_b = new Label(bresdthTxt);

		l = new TextArea();
		b = new TextArea();

		add(label_l);
		add(label_b);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(100, 100);
		setVisible(true);

		new Thread(() -> {
			while (true) {
				synchronized (airplane) {
					System.out.println("going to wait");
					try {
						airplane.wait();
					} catch (Exception e) {
					}
					drow(airplane);
				}
			}
		}).start();
	}

	public void drow(Airplane airplane) {

		if (canvas != null) {
			remove(canvas);
		}

		label_l.setText(lengthTxt + airplane.getLenght());
		label_b.setText(bresdthTxt + airplane.getBredth());
		canvas = new AirplaneCanvas(airplane);
		add(canvas);

		revalidate();
		repaint();
	}
}
