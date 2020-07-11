package com.gladguys.polisapi.controllers;

import com.gladguys.polisapi.models.CotaEstado;
import com.gladguys.polisapi.services.DespesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/despesas")
public class DespesasController {

    private DespesaService despesaService;

    public DespesasController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PostMapping(value = "/cota/total-disponivel")
    public ResponseEntity salvarCotasDisponiveis(@RequestBody List<CotaEstado> cotas) {
        try {
            this.despesaService.salvarCotasEstado(cotas);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
