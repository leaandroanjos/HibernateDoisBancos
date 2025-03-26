package br.com.leandro.dao;

import br.com.leandro.domain.Cliente;

public class MYClienteDao extends GenericDao<Cliente> implements IClienteDao<Cliente> {

    public MYClienteDao(){
        super(Cliente.class, "Mysql1");
    }

}
