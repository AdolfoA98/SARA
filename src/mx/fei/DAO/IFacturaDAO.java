/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.DAO;

import mx.fei.domain.Factura;

/**
 *
 * @author dell
 */
public interface IFacturaDAO {
    
    boolean crearFactura(Factura factura);
}
