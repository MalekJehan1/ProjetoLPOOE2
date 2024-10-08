/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe2_malek_rj.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author malek
 */
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "data", nullable = false)
    private Calendar data;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status;

    @ManyToMany
    @JoinTable(
        name = "pedido_alimentos",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "alimento_id")
    )
    private List<Alimento> alimentos = new ArrayList<>();

    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    public Pedido() {}

    public Pedido(Calendar data) {
        this.data = data;
        this.status = StatusPedido.NOVO;
        this.valorTotal = 0.0;
    }

    public void addAlimento(Alimento alim, int qtd) {
        for (int i = 0; i < qtd; i++) {
            alimentos.add(alim);
        }
        somaTotal();
    }

    public void somaTotal() {
        valorTotal = 0;
        for(Alimento a : alimentos){
            valorTotal += a.getValor();
        }
    }

    public void alteraStatus(String novoStatus) {
        this.status = StatusPedido.valueOf(novoStatus.toUpperCase());
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    @Override
    public String toString(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm");
        String dataFormatada = sdf.format(data.getTime());
        return "Pedido N " + id +
                " Data: " + dataFormatada +
                " Status: " + status +
                " Valor: " + getValorTotal();
    }
}

