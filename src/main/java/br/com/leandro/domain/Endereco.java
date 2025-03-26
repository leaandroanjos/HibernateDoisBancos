package br.com.leandro.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="end_seq")
    @SequenceGenerator(name="end_seq", sequenceName="sq_end", initialValue = 1, allocationSize = 1)
    private Integer id;

    @Column(length = 100, nullable = false, name = "rua")
    private String rua;

    @Column(length = 6, nullable = false, name = "numero")
    private Integer num;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
