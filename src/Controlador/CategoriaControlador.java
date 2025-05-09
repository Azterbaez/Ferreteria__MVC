/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import DAO.CategoriaDAO;
import Modelo.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiantes
 */
public class CategoriaControlador {

    private final CategoriaDAO categoriaDAO;
    
    public CategoriaControlador() {
        this.categoriaDAO = new CategoriaDAO();
    }   
    
    
    public void crearCategoria(String nombreCategoria, String descripcionCategoria) {
        try {
            Categoria categoria = new Categoria();
            categoria.setNombreCategoria(nombreCategoria);
            categoria.setDescripcionCategoria(descripcionCategoria);
            categoriaDAO.crearCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Categoría creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public List<Categoria> obtenerTodasCategorias() {
        try {
            return categoriaDAO.leerTodasCategorias();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las categorías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

     
    
   public void actualizarCategoria(int id, String nombreCategoria, String descripcionCategoria) {
        try {
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(id);
            categoria.setNombreCategoria(nombreCategoria);
            categoria.setDescripcionCategoria(descripcionCategoria);
            categoriaDAO.actualizarCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Categoría actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una categoría
    public void eliminarCategoria(int idCategoria) {
        try {
            categoriaDAO.eliminarCategoria(idCategoria);
            JOptionPane.showMessageDialog(null, "Categoría eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   
}

