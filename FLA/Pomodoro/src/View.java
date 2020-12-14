import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class View {

	private JFrame frmPomodoro;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPomodoro = new JFrame();
		frmPomodoro.getContentPane().setBackground(Color.RED);
		frmPomodoro.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frmPomodoro.removeAll();
				SecondFrame SecondFrame = new  SecondFrame();
				SecondFrame.setVisible(true);
			}
			
		});
		btnNewButton.setIcon(new ImageIcon("D:\\FLA\\res\\play.png"));
		btnNewButton.setBounds(163, 110, 81, 57);
		frmPomodoro.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("view stats");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(317, 228, 115, 25);
		frmPomodoro.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\FLA\\res\\outline_dot.png"));
		lblNewLabel.setBounds(153, 188, 18, 18);
		frmPomodoro.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\FLA\\res\\outline_dot.png"));
		label.setBounds(213, 188, 18, 18);
		frmPomodoro.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\FLA\\res\\outline_dot.png"));
		label_1.setBounds(183, 188, 18, 18);
		frmPomodoro.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\FLA\\res\\outline_dot.png"));
		lblNewLabel_1.setBounds(241, 188, 18, 18);
		frmPomodoro.getContentPane().add(lblNewLabel_1);
		frmPomodoro.setTitle("Pomodoro");
		frmPomodoro.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\FLA\\res\\tomato.png"));
		frmPomodoro.setBounds(100, 100, 450, 300);
		frmPomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
