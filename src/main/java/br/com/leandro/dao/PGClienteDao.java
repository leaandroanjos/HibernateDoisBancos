package br.com.leandro.dao;

import br.com.leandro.domain.Cliente;

public class PGClienteDao extends GenericDao<Cliente> implements IClienteDao<Cliente> {

    public PGClienteDao(){
        super(Cliente.class, "Postgre1");
    }

}
