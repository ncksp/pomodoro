import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
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

	publicu JFrame frmPomodoro;
	private final Action action = new SwingAction();
	public static boolean PlayPauseStatus;
	 
	 /* Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frmPomodoro.setVisible(true);
					window.frmPomodoro.setResizable(false);
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
	
	public static final void PausePlayButton(JButton button,String Path) {
		
		if(PlayPauseStatus) {
			button.setIcon(new ImageIcon(Path+"/res/pause.png"));
			PlayPauseStatus = false;
		}
		else {
			button.setIcon(new ImageIcon(Path+"/res/play.png"));
			PlayPauseStatus = true;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PlayPauseStatus = true;
		frmPomodoro = new JFrame();
		
		frmPomodoro.getContentPane().setBackground(Color.RED);
		frmPomodoro.getContentPane().setLayout(null);
		
		String absolutePath = Paths.get("").toAbsolutePath().toString();
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setIcon(new ImageIcon(absolutePath+"/res/play.png"));
		btnNewButton.setBounds(163, 110, 81, 57);
		frmPomodoro.getContentPane().add(btnNewButton);
		
		//boolean StatusPausePlay = true;
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				frmPomodoro.removeAll();
//				frmPomodoro.setVisible(false);
//				SecondFrame SecondFrame = new  SecondFrame();
//				SecondFrame.setVisible(true);
				PausePlayButton(btnNewButton, absolutePath);
				
			}
			
		});
		
		
		
		JLabel TimerText = new JLabel("");
		TimerText.setText("24:57");
		TimerText.setBounds(170, 50, 115, 25);
		TimerText.setFont(new Font(TimerText.getFont().getName(),TimerText.getFont().getStyle(),30));
		frmPomodoro.getContentPane().add(TimerText);
		
		JButton btnNewButton_1 = new JButton("view stats");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(317, 228, 115, 25);
		frmPomodoro.getContentPane().add(btnNewButton_1);
		
		JLabel JlblDot1 = new JLabel("");
		JlblDot1.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot1.setBounds(153, 188, 18, 18);
		frmPomodoro.getContentPane().add(JlblDot1);
		
		JLabel JlblDot2 = new JLabel("");
		JlblDot2.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot2.setBounds(213, 188, 18, 18);
		frmPomodoro.getContentPane().add(JlblDot2);
		
		JLabel JlblDot3 = new JLabel("");
		JlblDot3.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot3.setBounds(183, 188, 18, 18);
		frmPomodoro.getContentPane().add(JlblDot3);
		
		JLabel JlblDot4 = new JLabel("");
		JlblDot4.setIcon(new ImageIcon(absolutePath+"/res/outline_dot.png"));
		JlblDot4.setBounds(241, 188, 18, 18);
		frmPomodoro.getContentPane().add(JlblDot4);
		
		frmPomodoro.setTitle("Pomodoro");
		frmPomodoro.setIconImage(Toolkit.getDefaultToolkit().getImage(absolutePath+"/res/tomato.png"));
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
