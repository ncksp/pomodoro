import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;

public class ViewStats {

	private JFrame frmPomodoro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStats window = new ViewStats();
					window.frmPomodoro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPomodoro = new JFrame();
		frmPomodoro.setTitle("Pomodoro");
		frmPomodoro.setBounds(100, 100, 435, 150);
		frmPomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPomodoro.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tue");
		lblNewLabel.setBounds(12, 26, 30, 16);
		frmPomodoro.getContentPane().add(lblNewLabel);
		
		JLabel lblWed = new JLabel("Wed");
		lblWed.setBounds(70, 26, 30, 16);
		frmPomodoro.getContentPane().add(lblWed);
		
		JLabel lblThu = new JLabel("Thu");
		lblThu.setBounds(128, 26, 30, 16);
		frmPomodoro.getContentPane().add(lblThu);
		
		JLabel lblFri = new JLabel("Fri");
		lblFri.setBounds(186, 26, 30, 16);
		frmPomodoro.getContentPane().add(lblFri);
		
		JLabel lblSat = new JLabel("Sat");
		lblSat.setBounds(244, 26, 30, 16);
		frmPomodoro.getContentPane().add(lblSat);
		
		JLabel lblMo = new JLabel("Mon");
		lblMo.setBounds(302, 26, 30, 16);
		frmPomodoro.getContentPane().add(lblMo);
		
		JLabel lblSun = new JLabel("Sun");
		lblSun.setBounds(360, 26, 30, 16);
		frmPomodoro.getContentPane().add(lblSun);
		
		JLabel label = new JLabel("0");
		label.setBounds(12, 43, 30, 16);
		frmPomodoro.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("0");
		label_1.setBounds(70, 43, 30, 16);
		frmPomodoro.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("0");
		label_2.setBounds(128, 43, 30, 16);
		frmPomodoro.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("0");
		label_3.setBounds(186, 43, 30, 16);
		frmPomodoro.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("0");
		label_4.setBounds(244, 43, 30, 16);
		frmPomodoro.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("0");
		label_5.setBounds(302, 43, 30, 16);
		frmPomodoro.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("0");
		label_6.setBounds(360, 43, 30, 16);
		frmPomodoro.getContentPane().add(label_6);
	}
}
