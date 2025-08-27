package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class DeleteStudent extends JFrame {
    private JComboBox<String> comboRollNumbers;
    private JButton btnDelete, btnCancel;

    public DeleteStudent() {
        // Frame settings
        setTitle("Delete Student");
        setSize(950, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(heading);

        // Roll Number ComboBox
        comboRollNumbers = new JComboBox<>();
        comboRollNumbers.setBounds(200, 20, 200, 25);
        add(comboRollNumbers);

        // Load Roll Numbers into ComboBox
        loadRollNumbers();

        // Buttons
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(100, 80, 120, 30);
        styleButton(btnDelete, new Color(220, 53, 69), Color.WHITE);
        add(btnDelete);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(250, 80, 120, 30);
        styleButton(btnCancel, new Color(108, 117, 125), Color.WHITE);
        add(btnCancel);

        // Table for Showing Student Details (Optional)
        JTable table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 120, 900, 200);
        add(sp);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Button Actions
        btnDelete.addActionListener(e -> deleteStudent());
        btnCancel.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void loadRollNumbers() {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT rollno FROM student");
            while (rs.next()) {
                comboRollNumbers.addItem(rs.getString("rollno"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading roll numbers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        String selectedRollNumber = (String) comboRollNumbers.getSelectedItem();

        if (selectedRollNumber == null) {
            JOptionPane.showMessageDialog(this, "No roll number selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Conn conn = new Conn();
            PreparedStatement pst = conn.c.prepareStatement("DELETE FROM student WHERE rollno = ?");
            pst.setString(1, selectedRollNumber);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                comboRollNumbers.removeItem(selectedRollNumber);
            } else {
                JOptionPane.showMessageDialog(this, "Roll number not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void styleButton(JButton button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DeleteStudent::new);
    }
}
