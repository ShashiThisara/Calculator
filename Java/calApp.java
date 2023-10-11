import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class calApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
          
                calculator Calculator = new calculator();
                Calculator.setTitle("Calculator");
                Calculator.setLocation(100, 200);
                Calculator.setSize(300, 340);
                Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Calculator.setVisible(true);

                calLogic logic = new calLogic(Calculator.getTxtName());
                Calculator.addButtonListeners(logic);
            }
        });
    }
}
