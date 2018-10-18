package com.yartemp;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Pogoda extends JFrame {
	JLabel label;
	JLabel lblTemperature;
	JLabel lblTemperatureChange;
	JLabel lblPressure;
	JLabel lblPressureChange;
	JLabel lblLight;
	JLabel lblAverageTemperature;
	JButton btnShowData;
	
	private void updateData() {
		try {
			Parser parser = new Parser();
			lblTemperature.setText(parser.getTemperature());
			lblTemperatureChange.setText(parser.getTemperatureChange());
			lblPressure.setText(parser.getPressure());
			lblPressureChange.setText(parser.getPressureChange() );
			lblLight.setText(parser.getLight());
			lblAverageTemperature.setText(parser.getAverageTemperature());
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Появилась ошибка: "+e);
		
		}
		
		
	}
	
	public Pogoda() {
		setTitle("Погода в Ярославле");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnShowData = new JButton("Обновить данные");
		btnShowData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowData.setBounds(188, 374, 194, 50);
		getContentPane().add(btnShowData);
		btnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				updateData();
			}
		});
		
		
		JLabel label = new JLabel("Температура в Ярославле");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(58, 11, 454, 58);
		getContentPane().add(label);
		
		lblTemperature = new JLabel("Текущая температура:");
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTemperature.setBounds(80, 100, 400, 30);
		getContentPane().add(lblTemperature);
		
		lblTemperatureChange = new JLabel("Измение температуры:");
		lblTemperatureChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTemperatureChange.setBounds(80, 140, 400, 30);
		getContentPane().add(lblTemperatureChange);
		
		lblPressure = new JLabel("Атмосферное давление: ");
		lblPressure.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPressure.setBounds(80, 180, 400, 30);
		getContentPane().add(lblPressure);
		
		lblPressureChange = new JLabel("Изменение давления: ");
		lblPressureChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPressureChange.setBounds(80, 220, 400, 30);
		getContentPane().add(lblPressureChange);
		
		lblLight = new JLabel("Солнечность: ");
		lblLight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLight.setBounds(80, 260, 400, 30);
		getContentPane().add(lblLight);
		
		lblAverageTemperature = new JLabel("Средняя температура за последние 24 часа: ");
		lblAverageTemperature.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAverageTemperature.setBounds(80, 300, 450, 30);
		getContentPane().add(lblAverageTemperature);
		
		updateData();
		
	}

	public static void main(String[] args) {
		Pogoda pogoda = new Pogoda();
		pogoda.setSize(new Dimension(600, 500));
		pogoda.setVisible(true);

	}
}
