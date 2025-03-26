package br.com.leandro;

import br.com.leandro.dao.MYClienteDao;
import br.com.leandro.dao.PGClienteDao;
import br.com.leandro.dao.IClienteDao;
import br.com.leandro.domain.Endereco;
import br.com.leandro.domain.Venda;
import org.junit.Test;
import br.com.leandro.domain.Cliente;

public class ClienteTest {

    private IClienteDao<Cliente> pgclienteDao;
    private IClienteDao<Cliente> myclienteDao;

    public ClienteTest(){
        pgclienteDao = new PGClienteDao();
        myclienteDao = new MYClienteDao();
    }


    @Test
    public void cadastrarCliente(){
        Cliente cli = criarCliente();
        pgclienteDao.cadastrar(cli);
        System.out.println("Cliente cadastrado com sucesso no PgAdmin!");
        pgclienteDao.excluir(cli);
    }

    @Test
    public void cadastrarClienteMySql(){

        Cliente cli = criarCliente();
        myclienteDao.cadastrar(cli);
        System.out.println("Cliente cadastrado com sucesso no MySql!");
        myclienteDao.excluir(cli);
    }

    private Cliente criarCliente(){
        Cliente cli = new Cliente();
        cli.setNome("Leandro");
        cli.setCpf(56227402826L);

        Endereco end = new Endereco();
        end.setNum(276);
        end.setRua("Rua marechal Deodoro");
        cli.setEndereco(end);

        Venda venda = new Venda();
        venda.setProduto("Detergente");
        venda.setQuantidade(5);
        cli.addVenda(venda);

        return cli;
    }

}
