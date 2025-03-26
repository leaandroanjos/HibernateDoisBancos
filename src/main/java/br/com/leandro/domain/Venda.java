package br.com.leandro.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="venda_seq")
    @SequenceGenerator(name="venda_seq", sequenceName="sq_venda", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(nullable = false, length = 100, name = "produto")
    private String produto;

    @Column(nullable = false, name = "quantidade")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
