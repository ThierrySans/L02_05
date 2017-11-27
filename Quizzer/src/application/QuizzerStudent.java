package application;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import frontend.View_questions_gui;

public class QuizzerStudent extends Window {	

	public QuizzerStudent() {
		super();
	}
	
	public QuizzerStudent(boolean set) {
		super(set);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
    
    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizzerStudent window = new QuizzerStudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Quizzer.BACKGROUND);
		frame.setBounds(100, 100, 604, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Helper function that creates KeyEvent listener to return to login if shift+Q is pressed.
		Quizzer.LoginListener(frame, setup);
		
		JLabel lblQuizzer = new JLabel("Quizzer (Student)");
		lblQuizzer.setFont(Quizzer.QUIZZERFONT);
		lblQuizzer.setForeground(Quizzer.FOREGROUND);
		lblQuizzer.setBounds(165, 11, 356, 65);
		frame.getContentPane().add(lblQuizzer);
		
	    final JButton btnView = new JButton("View Assignment");
	    btnView.setFocusable(false);
	    btnView.setBackground(Quizzer.BUTTON);
		btnView.setForeground(Quizzer.FOREGROUND);
		btnView.setBounds(10, 130, 158, 53);
	    btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					View_questions_gui aq = new View_questions_gui();
					aq.student = true;
					aq.frame.setVisible(true);
					frame.dispose();
				}
			});
	    btnView.setEnabled(setup);
	    frame.getContentPane().add(btnView); 
		JLabel lblReturn = new JLabel("Press Shift+Q to return to the Login screen.");
		lblReturn.setBounds(10, 306, 454, 46);
		lblReturn.setForeground(Quizzer.FOREGROUND);
		lblReturn.setFont(Quizzer.BOLDQUIZZERFONT);
		frame.getContentPane().add(lblReturn);

	}
	public static void Start(JFrame old_frame, boolean setup) {
		QuizzerStudent app = new QuizzerStudent(setup);
        app.frame.setVisible(setup);
        old_frame.dispose();
	}
}
