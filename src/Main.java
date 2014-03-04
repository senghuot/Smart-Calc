// Open-Source Project: Smart_Calc
// This program is intended to "creatively" help users solve their Math-126 problems
// I don't promote abusing or cheating the system.
// Developer: Senghuot Lim
// last revision: 4/9/13

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	
		// Components for user inputs  
		private static JLabel l1 = new JLabel("<html> <B>A :</B> </html>");
		private static JTextField tx1 = new JTextField(6);

		private static JLabel l2 = new JLabel("<html> <B>B :</B> </html>");
		private static JTextField tx2 = new JTextField(6); 
		
		private static JLabel l3 = new JLabel("<html> <B>C :</B>  </html>");
		private static JTextField tx3 = new JTextField(6);
		
		private static JTextArea summary = new JTextArea();
		private static JButton compute = new JButton("Compute");
		private static Point3d p1;
		private static Point3d p2;
		private static Point3d p3;
		
	public static void main(String[] args){
		// declaring frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 400));
		frame.setResizable(false);
		frame.setTitle("Smart Calc: version: 0.1.1");
		frame.setLayout(new BorderLayout());
		frame.setBackground(Color.GRAY);
		
		//customize fields and some actions
		//summary.setBackground(Color.BLACK); // homebrew
		//summary.setForeground(new Color(00, 242, 0)); // homebrew
		summary.setEditable(false);
		compute.addActionListener(new ActionListener() {
			//action to be performed
			public void actionPerformed(ActionEvent event) {
				// construct defualt Point3d (0, 0, 0) when none user data input is found 
				if(tx1.getText().length() == 0)
					tx1.setText("0 0 0");
				
				if(tx2.getText().length() == 0)
					tx2.setText("0 0 0");
				
				if(tx3.getText().length() == 0)
					tx3.setText("0 0 0");
				
				Scanner console = new Scanner(tx1.getText());
				p1 = new Point3d(console.nextDouble(), console.nextDouble(), console.nextDouble());
				console = new Scanner (tx2.getText());
				p2 = new Point3d(console.nextDouble(), console.nextDouble(), console.nextDouble());
				console = new Scanner (tx3.getText());
				p3 = new Point3d(console.nextDouble(), console.nextDouble(), console.nextDouble());
				
				summary.setText(" Quick Summary: \n\n|A|=" + p1.getMagnitude() + "\n|B| = " + p2.getMagnitude() 
						+ "\n|C| = " + p3.getMagnitude()
						+ "\n AB = " + p1.getVector(p2)
						+ "\n AC = " + p1.getVector(p3)
						+ "\n A . B = " + p1.getDotProduct(p2)
						+ "\n A . C = " + p1.getDotProduct(p3)
						+ "\n A x B = " + p1.getCrossProduct(p2)
						+ "\n B x A = " + p2.getCrossProduct(p1)
						+ "\n Angle A&B = " + p1.getAngleRadian(p2) + " radians or " + p1.getAngleDegree(p2) + " degrees"
						+ "\n Area of triangle: " + p1.getAreaTriangle(p1.getVector(p2), p1.getVector(p3))
						);
			}
		});
		
		// north components
		JPanel north = new JPanel(new FlowLayout());
		north.add(l1);
		north.add(tx1);
		north.add(l2);
		north.add(tx2);
		north.add(l3);
		north.add(tx3);

		
		JPanel south = new JPanel(new FlowLayout());
		south.add(compute);
		
		frame.add(north, BorderLayout.NORTH);
		frame.add(summary, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	
}
