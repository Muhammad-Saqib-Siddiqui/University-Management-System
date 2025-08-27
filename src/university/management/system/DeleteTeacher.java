package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;

public class DeleteTeacher extends JFrame {
    private JComboBox<String> comboEmpIdi;
    private JButton btnDelete, btnCancel;

    public DeleteTeacher() {
        // Frame settings
        setTitle("Delete Teacher");
        setSize(950, 380);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
        setLayout(null);
getContentPane().setBackground(Color.WHITE);
        
    // Heading
        JLabel heading = new JLabel("Search by employee ID");
        heading.setBounds(20, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(heading);

        // Employee ID ComboBox
        comboEmpIdi = new JComboBox<>();
        comboEmpIdi.setBounds(200, 20, 200, 25);
        add(comboEmpIdi);

        // Load Employee IDs into ComboBox
        loadEmployeeIds();

        // Buttons
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(100, 80, 120, 30);
        styleButton(btnDelete, new Color(220, 53, 69), Color.WHITE);
        add(btnDelete);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(250, 80, 120, 30);
        styleButton(btnCancel, new Color(108, 117, 125), Color.WHITE);
        add(btnCancel);

        // Table for showing Teacher details (Optional)
        JTable table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 120, 900, 200);
        add(sp);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Button Actions
        btnDelete.addActionListener(e -> deleteTeacher());
        btnCancel.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void loadEmployeeIds() {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT empId FROM teacher");
            while (rs.next()) {
                comboEmpIdi.addItem(rs.getString("empId"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading employee IDs: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTeacher() {
        String selectedEmpId = (String) comboEmpIdi.getSelectedItem();

           if (selectedEmpId == null) {
            JOptionPane.showMessageDialog(this, "No employee ID selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Conn conn = null;
        try {
            conn = new Conn();

            // Start a transaction
            conn.c.setAutoCommit(false);

            // Delete from the teacher table
            PreparedStatement pst1 = conn.c.prepareStatement("DELETE FROM teacher WHERE empId = ?");
            pst1.setString(1, selectedEmpId);
            pst1.executeUpdate();

            // Delete related records from education
            PreparedStatement pst2 = conn.c.prepareStatement("DELETE FROM teacher WHERE education = ?");
            pst2.setString(1, selectedEmpId);
            pst2.executeUpdate();

            // Delete related records from department
            PreparedStatement pst3 = conn.c.prepareStatement("DELETE FROM teacher WHERE department = ?");
            pst3.setString(1, selectedEmpId);
            pst3.executeUpdate();

            // Commit the transaction
            conn.c.commit();

            // Show success message
            JOptionPane.showMessageDialog(this, "Teacher and related data deleted successfully!");
            comboEmpIdi.removeItem(selectedEmpId); // Remove from dropdown as well
            loadEmployeeIds(); // Reload the dropdown

        } catch (SQLException e) {
            // Rollback in case of error
            try {
                if (conn != null) {
                    conn.c.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
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
        SwingUtilities.invokeLater(DeleteTeacher::new);
    }
}
