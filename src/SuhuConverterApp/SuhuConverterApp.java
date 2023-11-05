package SuhuConverterApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuhuConverterApp extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton celsiusToFahrenheitButton;
    private JButton fahrenheitToCelsiusButton;

    public SuhuConverterApp() {
        setTitle("Suhu Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        inputField = new JTextField(20);
        celsiusToFahrenheitButton = new JButton("Celsius to Fahrenheit");
        fahrenheitToCelsiusButton = new JButton("Fahrenheit to Celsius");

        celsiusToFahrenheitButton.addActionListener(this);
        fahrenheitToCelsiusButton.addActionListener(this);

        panel.add(inputField);
        panel.add(celsiusToFahrenheitButton);
        panel.add(fahrenheitToCelsiusButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SuhuConverterApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == celsiusToFahrenheitButton) {
            String input = inputField.getText();
            try {
                double celsius = Double.parseDouble(input);
                double fahrenheit = (celsius * 9 / 5) + 32;
                JOptionPane.showMessageDialog(this, celsius + " Celsius = " + fahrenheit + " Fahrenheit");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.");
            }
        } else if (e.getSource() == fahrenheitToCelsiusButton) {
            String input = inputField.getText();
            try {
                double fahrenheit = Double.parseDouble(input);
                double celsius = (fahrenheit - 32) * 5 / 9;
                JOptionPane.showMessageDialog(this, fahrenheit + " Fahrenheit = " + celsius + " Celsius");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.");
            }
        }
    }
}