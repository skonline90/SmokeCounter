package de.privat.smoke_counter.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Gui extends JFrame {
	private static final String DATE_TIME_FORMAT = "dd.MM.yyyy -- HH:mm:ss";
	private int _count;
	private JPanel _main;

	public Gui() {
		_count = 0;
		_main = new JPanel();
		_main.setLayout(new BoxLayout(_main, BoxLayout.Y_AXIS));
		this.setContentPane(_main);
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		final JLabel lblLastSmoke = new JLabel("Last cigarette: " + formatter.format(LocalDateTime.now()));
		_main.add(lblLastSmoke);
		final JLabel lblCount = new JLabel("Count: " + _count);
		_main.add(lblCount);
		final JTextArea txaLog = new JTextArea();
		txaLog.setEditable(false);
		final JScrollPane pane = new JScrollPane(txaLog);
		JButton btnIncrement = new JButton("Increment");
		btnIncrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_count++;
				lblCount.setText("Count: " + _count);
				lblLastSmoke.setText("Last cigarette: " + formatter.format(LocalDateTime.now()));
				txaLog.append(formatter.format(LocalDateTime.now()) + " -- " + _count);
				txaLog.append(System.getProperty("line.separator"));
			}
		});
		_main.add(btnIncrement);
		_main.add(pane);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(new Dimension(300,400));
	}
}
