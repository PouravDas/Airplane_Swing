package com.test.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.BoxLayout;

import com.test.model.Airplane;

public class PanelLeft extends Panel {

	Airplane airplane = null;

	TextArea l = null;
	Label label_l = null;

	TextArea b = null;
	Label label_b = null;

	public PanelLeft(Airplane airplane) {
		this.airplane = airplane;
		label_l = new Label("length");
		label_b = new Label("bredth");

		l = new TextArea();
		l.setPreferredSize(new Dimension(50, 10));
		b = new TextArea();
		b.setPreferredSize(new Dimension(50, 10));

		Button button = new Button("Click Here");
		button.setBounds(10, 10, 80, 30);

		button.addActionListener(e -> {
			int lenght = 0;
			int bredth = 0;
			try {
				lenght = Integer.parseInt(l.getText());
				bredth = Integer.parseInt(b.getText());
			} catch (Exception e2) {
				return;
			}

			synchronized (airplane) {
				System.out.println("Setting the airplane dimensions");
				airplane.setLenght(lenght);
				airplane.setBredth(bredth);
				airplane.notify();
			}
		});

		add(label_l);
		add(l);
		add(label_b);
		add(b);
		add(button);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(200, 200);
		setVisible(true);
	}

}
