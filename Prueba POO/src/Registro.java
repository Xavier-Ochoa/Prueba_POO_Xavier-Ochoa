import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registro {
    public JPanel panel1;
    private JTextField ingreso_de_id;
    private JTextField ingreso_de_cedula;
    private JTextField ingreso_de_nombre;
    private JTextField ingreso_de_nota1;
    private JTextField ingreso_de_nota2;
    private JTextField ingreso_de_nota3;
    private JTextField ingreso_de_nota4;
    private JTextField ingreso_de_nota5;
    private JButton boton_agregar_a_la_base;
    private JButton ver_prodmedioss;

    public Registro() {
        boton_agregar_a_la_base.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardar_notas();
            }
        });
        ver_prodmedioss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }

    private void guardar_notas() {
        String id = ingreso_de_id.getText();
        String cedula = ingreso_de_cedula.getText();
        String nombre = ingreso_de_nombre.getText();
        String nota1 = ingreso_de_nota1.getText();
        String nota2 = ingreso_de_nota2.getText();
        String nota3 = ingreso_de_nota3.getText();
        String nota4 = ingreso_de_nota4.getText();
        String nota5 = ingreso_de_nota5.getText();

        String query = "INSERT INTO estudiantes (id, cedula, nombre, estudiante1, estudiante2, estudiante3, estudiante4, estudiante5) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.setString(2, cedula);
            pstmt.setString(3, nombre);
            pstmt.setDouble(4, Double.parseDouble(nota1));
            pstmt.setDouble(5, Double.parseDouble(nota2));
            pstmt.setDouble(6, Double.parseDouble(nota3));
            pstmt.setDouble(7, Double.parseDouble(nota4));
            pstmt.setDouble(8, Double.parseDouble(nota5));

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(panel1, "Notas guardadas exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(panel1, "Error al guardar las notas del estudiante: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(panel1, "Error inesperado: " + e.getMessage());
        }
    }



    }










