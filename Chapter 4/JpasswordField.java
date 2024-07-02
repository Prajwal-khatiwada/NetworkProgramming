import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JpasswordField {
    public static void main(String[] args) {
        // Create password field and label
        JPasswordField passwordField = new JPasswordField(20);
        JLabel passwordLabel = new JLabel("Password: ");

        // Create panel and button
        JPanel passwordPanel = new JPanel();
        JButton enterButton = new JButton("Enter");

        // Create frame
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setTitle("Password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits on close

        // Add components to the panel
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        passwordPanel.add(enterButton);

        // Add panel to the frame
        frame.add(passwordPanel);

        // Make the frame visible
        frame.setVisible(true);

        // Add action listener to the button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                System.out.println("Password: " + password);
            }
        });
    }
}
