/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.DAO;

import java.util.List;
import mx.fei.domain.Usuario;

/**
 *
 * @author jethr
 */
public interface IUsuarioDAO {
 
    List<Usuario> ObtenerTodoslosCliente();
    List<Usuario> obtenerClientePorNombre(String nombreCliente);
    Usuario obtenerClientePorMatricula(String MatriculaCliente);
    boolean agregarCliente(Usuario cliente, String tarjetaCredito);
}
