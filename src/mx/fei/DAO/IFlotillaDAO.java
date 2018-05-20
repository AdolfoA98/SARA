/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.DAO;

import mx.fei.domain.Flotilla;

/**
 *
 * @author jethr
 */
public interface IFlotillaDAO {
    
    boolean agregarFlotilla(Flotilla flotilla);
    boolean eliminarFlotilla(String matriculaFlotilla);
    boolean EditarFlotilla(String matriculaFlotilla);
    
}
