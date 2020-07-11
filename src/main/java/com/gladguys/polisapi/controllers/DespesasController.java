package com.gladguys.polisapi.controllers;

import com.gladguys.polisapi.models.CotaEstado;
import com.gladguys.polisapi.services.DespesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/despesas")
public class DespesasController {

    private DespesaService despesaService;

    public DespesasController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PostMapping(value = "/cota/total-estado")
    public ResponseEntity salvarTotalCotasPorEstado(@RequestBody List<CotaEstado> cotas) {
        try {
            this.despesaService.salvarCotasEstado(cotas);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/cota/total-estado/{siglaUF}")
    public ResponseEntity<CotaEstado> buscarTotalMensalCotasPorEstado(@PathVariable("siglaUF") String siglaUF) {
        try {
            if (siglaUF != null) {
                CotaEstado cotaEstado = this.despesaService.buscarTotalMensalCotaPorEstado(siglaUF.toUpperCase());
                if (cotaEstado == null) return ResponseEntity.badRequest().build();
                return ResponseEntity.ok(cotaEstado);
            } else return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
