package de.privat.smoke_counter;

import javax.swing.SwingUtilities;

import de.privat.smoke_counter.view.Gui;

public class Start {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Gui();
			}
		});
	}
}
