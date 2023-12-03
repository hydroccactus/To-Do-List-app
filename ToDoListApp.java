import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp {
    public static void main(String[] args) {
        // membuat Frame nya
        final JFrame frame = new JFrame();
        frame.setTitle("To-Do List Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 600);
        frame.setLayout(null); // set layout manager to null

        // Title nya
        JLabel title = new JLabel("To Do List", SwingConstants.CENTER);
        title.setBounds(0, 0, 520, 25);

        // membuat area input
        final JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 30, 350, 25);

        // buat display list nya
        final DefaultListModel<String> listModel = new DefaultListModel<String>();
        final JList<String> list = new JList<String>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(20, 90, 350, 400);
        // buat title border
        TitledBorder border = BorderFactory.createTitledBorder("List");
        list.setBorder(border);

        // tombol add nya
        JButton addButton = new JButton("Add");
        addButton.setBounds(20, 70, 350, 25);

        // actionListener nya
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textArea.getText();
                if (!input.isEmpty()) {
                    listModel.addElement(input);
                    textArea.setText("");
                    JOptionPane.showMessageDialog(frame, "Successfully\nTask has been added");
                } else {
                    JOptionPane.showMessageDialog(frame, "Error\nNo task has been added.\nPlease fill in the task", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // tombol remove nya
        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(20, 500, 350, 25); // adjust bounds

        // actionListener nya
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // add components to the frame
        frame.add(title);
        frame.add(textArea);
        frame.add(scrollPane);
        frame.add(addButton);
        frame.add(removeButton);

        // set frame visibility to true
        frame.setVisible(true);
    }
}
