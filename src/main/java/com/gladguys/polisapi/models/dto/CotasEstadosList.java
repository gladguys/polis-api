package com.gladguys.polisapi.models.dto;

import com.gladguys.polisapi.models.CotaEstado;
import lombok.Data;

import java.util.List;

@Data
public class CotasEstadosList {
    private List<CotaEstado> cotasEstados;
}
