import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class calLogic implements ActionListener {
    private JTextField textField;
    private StringBuilder currentInput = new StringBuilder();
    private String previousInput = "";
    private String operator = "";
    private List<String> history = new ArrayList<>();
    private StringBuilder equation = new StringBuilder();

    public calLogic(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (isNumeric(command) || ".".equals(command)) {
            currentInput.append(command);
            equation.append(command);
            textField.setText(equation.toString());
        } else if ("+".equals(command) || "-".equals(command) || "x".equals(command) || "/".equals(command)) {
            if (currentInput.length() > 0) {
                if (!previousInput.isEmpty()) {
                    calculate();
                }
                operator = command;
                equation.append(" " + operator + " ");
                textField.setText(equation.toString());
                previousInput = currentInput.toString();
                currentInput.setLength(0);
            }
        } else if ("=".equals(command)) {
            if (!currentInput.toString().isEmpty() && !previousInput.isEmpty() && !operator.isEmpty()) {
                calculate();
                operator = "";
                equation.append(" = " + currentInput.toString());
                history.add(equation.toString());
                textField.setText(currentInput.toString());
            }
        } else if ("C".equals(command)) {
            clearInput();
        } else if ("History".equals(command)) {
            showHistory();
        }
    }

    private boolean isNumeric(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    private void calculate() {
        double num1 = Double.parseDouble(previousInput);
        double num2 = Double.parseDouble(currentInput.toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textField.setText("Error: Division by zero");
                    currentInput.setLength(0);
                    previousInput = "";
                    operator = "";
                    equation.setLength(0);
                    return;
                }
                break;
        }

        if (result == (int) result) {
            currentInput.setLength(0);
            currentInput.append((int) result);
        } else {
            currentInput.setLength(0);
            currentInput.append(result);
        }
    }

    private void clearInput() {
        currentInput.setLength(0);
        previousInput = "";
        operator = "";
        equation.setLength(0);
        textField.setText("");
    }

    private void showHistory() {
        StringBuilder historyText = new StringBuilder("Calculation History:\n");
        for (String calculation : history) {
            historyText.append(calculation).append("\n");
        }
        JOptionPane.showMessageDialog(null, historyText.toString(), "Calculation History", JOptionPane.INFORMATION_MESSAGE);
    }
}