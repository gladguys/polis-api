package com.gladguys.polisapi.services;

import com.gladguys.polisapi.models.CotaEstado;
import com.gladguys.polisapi.repositories.CotaEstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    private CotaEstadoRepository cotaEstadoRepository;

    public DespesaService(CotaEstadoRepository cotaEstadoRepository) {
        this.cotaEstadoRepository = cotaEstadoRepository;
    }

    public void salvarCotasEstado(List<CotaEstado> cotas) {
        cotas.stream().forEach(c -> c.addSiglaUF());
        this.cotaEstadoRepository.saveAll(cotas);
    }

    public CotaEstado buscarTotalMensalCotaPorEstado(String siglaUF) {
        return this.cotaEstadoRepository.findBySiglaUF(siglaUF);
    }
}
