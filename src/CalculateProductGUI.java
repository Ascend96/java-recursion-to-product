import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalculateProductGUI extends JFrame {

    private JTextField numberField;
    private DefaultListModel<Integer> listModel;
    private JLabel productLabel;

    private final List<Integer> numbers = new ArrayList<>();

    // constructor for the GUI
    public CalculateProductGUI() {
        setTitle("Recursive Product Calculator");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    // initializes the GUI components
    private void initializeComponents() {
        // Top panel: input
        JPanel inputPanel = new JPanel(new FlowLayout());
        numberField = new JTextField(10);
        JButton addButton = new JButton("Add Number");

        inputPanel.add(new JLabel("Enter number:"));
        inputPanel.add(numberField);
        inputPanel.add(addButton);

        // Center panel: list
        listModel = new DefaultListModel<>();
        JList<Integer> numberList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(numberList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Numbers"));

        // panel for displaying the product
        JPanel productPanel = new JPanel();
        productLabel = new JLabel("Product: 1");
        productLabel.setFont(new Font("Arial", Font.BOLD, 16));
        productPanel.add(productLabel);

        // layout
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(productPanel, BorderLayout.SOUTH);

        // events
        addButton.addActionListener(_ -> addNumber());
        numberField.addActionListener(_ -> addNumber());
    }

    // adds a number to the list and updates the product recursively
    private void addNumber() {
        try {
            int value = Integer.parseInt(numberField.getText().trim());

            numbers.add(value);
            listModel.addElement(value);

            updateProduct();

            numberField.setText("");
            numberField.requestFocus();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid integer.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // updates the value of the product based on each number the user entered
    private void updateProduct() {
        int[] array = numbers.stream().mapToInt(Integer::intValue).toArray();
        int result = RecursiveProduct.findProduct(array);
        productLabel.setText("Product: " + result);
    }
}
