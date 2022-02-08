/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gustavo
 */
public class Conexao {
    
    EntityManagerFactory fac = Persistence.createEntityManagerFactory("ChatbotPU");
    EntityManager manager = fac.createEntityManager();
    
    public EntityManagerFactory getConexao() {
        return this.fac;
    }
    
}
