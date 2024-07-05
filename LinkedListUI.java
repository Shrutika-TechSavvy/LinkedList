import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkedListUI {
    private LinkedList linkedList = new LinkedList();
    private JFrame frame;
    private JTextField inputField;
    private JTextArea displayArea;

    public LinkedListUI() {
        frame = new JFrame("Linked List Operations");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        //For centering at screen
        frame.setLocationRelativeTo(null);

        placeComponents(panel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        JLabel userLabel = new JLabel("Value:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        inputField = new JTextField(20);
        inputField.setBounds(100, 20, 165, 25);
        inputField.setToolTipText("Enter the value to be added, deleted, or searched");
        panel.add(inputField);

        JButton addButton = new JButton("Add (At end)");
        addButton.setBounds(10, 50, 160, 25);
        addButton.setToolTipText("Add a value to the end of the linked list");
        panel.add(addButton);

        JButton addAtBegButton = new JButton("Add (At begin)");
        addAtBegButton.setBounds(180, 50, 150, 25);
        addAtBegButton.setToolTipText("Add a value to the beginning of the linked list");
        panel.add(addAtBegButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(340, 50, 150, 25);
        deleteButton.setToolTipText("Delete a value from the linked list");
        panel.add(deleteButton);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(500, 50, 130, 25);
        searchButton.setToolTipText("Search for a value in the linked list");
        panel.add(searchButton);

        JButton displayButton = new JButton("Display");
        displayButton.setBounds(640, 50, 130, 25);
        displayButton.setToolTipText("Display the entire linked list");
        panel.add(displayButton);

        displayArea = new JTextArea();
        displayArea.setBounds(10, 80, 760, 250);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(10, 80, 760, 250);
        panel.add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    linkedList.add(value);
                    updateDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addAtBegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    linkedList.addAtBeg(value);
                    updateDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    linkedList.delete(value);
                    updateDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    boolean found = linkedList.search(value);
                    displayArea.setText(found ? "Value found in the list." : "Value not found in the list.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        });
    }

    private void updateDisplay() {
        displayArea.setText(linkedList.display());
    }

    public static void main(String[] args) {
        new LinkedListUI();
    }
}
