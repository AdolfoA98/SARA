/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.DAO;
import java.util.List;
import mx.fei.domain.Vehiculo;
/**
 *
 * @author jethr
 */
public interface IVehiculoDAO {
    
    boolean agregarAuto(Vehiculo vehiculo, String rfcCliente, String flotilla, String matriculaAdmi);
    boolean eliminarAuto(String noMotor);
    List<Vehiculo> obtenerVehiculos();
}
