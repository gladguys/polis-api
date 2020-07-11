package com.gladguys.polisapi.models;

import com.gladguys.polisapi.util.MapeadorEstadoSiglaUf;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CotaEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String siglaUF;

    private String nomeUF;

    private String cotaDisponivel;

    public void addSiglaUF() {
        siglaUF = MapeadorEstadoSiglaUf.retornaSiglaUFParaNomeEstado(nomeUF);
    }
}
