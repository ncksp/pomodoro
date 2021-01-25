package main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Break extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Break frame = new Break();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Break() {
		String absolutePath = Paths.get("").toAbsolutePath().toString();
		setIconImage(Toolkit.getDefaultToolkit().getImage(absolutePath+"/res/tomato.png"));
		setTitle("Pomodoro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon(absolutePath+"/res/pause.png"));
		btnNewButton.setBounds(105, 110, 81, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(0, 139, 139));
		btnNewButton_1.setIcon(new ImageIcon(absolutePath+"/res/skip.png"));
		btnNewButton_1.setBounds(221, 110, 81, 57);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("view stats");
		button.setBackground(new Color(0, 139, 139));
		button.setBounds(317, 228, 115, 25);
		contentPane.add(button);
		
		//Timer Text
		JLabel TimerText = new JLabel("");
		TimerText.setText("24:57");
		TimerText.setBounds(170, 50, 115, 25);
		TimerText.setFont(new Font(TimerText.getFont().getName(),TimerText.getFont().getStyle(),30));
		contentPane.add(TimerText);
		
		//Dot Area
		JLabel JlblDot1 = new JLabel("");
		JlblDot1.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot1.setBounds(153, 188, 18, 18);
		contentPane.add(JlblDot1);
		
		JLabel JlblDot2 = new JLabel("");
		JlblDot2.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot2.setBounds(213, 188, 18, 18);
		contentPane.add(JlblDot2);
		
		JLabel JlblDot3 = new JLabel("");
		JlblDot3.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot3.setBounds(183, 188, 18, 18);
		contentPane.add(JlblDot3);
		
		JLabel JlblDot4 = new JLabel("");
		JlblDot4.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot4.setBounds(241, 188, 18, 18);
		contentPane.add(JlblDot4);
		
		//Dot End
	}
}
