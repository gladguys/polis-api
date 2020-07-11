package com.gladguys.polisapi.util;

public class MapeadorEstadoSiglaUf {

    private static final String ACRE = "Acre";
    private static final String ALAGOAS = "Alagoas";
    private static final String AMAZONAS = "Amazonas";
    private static final String AMAPA = "Amapá";
    private static final String BAHIA = "Bahia";
    private static final String CEARA = "Ceará";
    private static final String DISTRITO_FEDERAL = "Distrito Federal";
    private static final String ESPIRITO_SANTO = "Espírito Santo";
    private static final String GOIAS = "Goiás";
    private static final String MINAS_GERAIS = "Minas Gerais";
    private static final String MATO_GROSSO_SUL = "Mato Grosso do Sul";
    private static final String MATO_GROSSO = "Mato Grosso";
    private static final String MARANHAO = "Maranhão";
    private static final String PARAIBA = "Paraíba";
    private static final String PARA = "Pará";
    private static final String PERNAMBUCO = "Pernambuco";
    private static final String PIAUI = "Piauí";
    private static final String PARANA = "Paraná";
    private static final String RIO_JANEIRO = "Rio de Janeiro";
    private static final String RIO_GRANDE_SUL = "Rio Grande do Sul";
    private static final String RONDONIA = "Rondônia";
    private static final String RORAIMA = "Roraima";
    private static final String RIO_GRANDE_NORTE = "Rio Grande do Norte";
    private static final String SAO_PAULO = "São Paulo";
    private static final String SANTA_CATARINA = "Santa Catarina";
    private static final String SERGIPE = "Sergipe";
    private static final String TOCANTINS = "Tocantins";


    public static String retornaSiglaUFParaNomeEstado(String nomeEstado) {
        String sigla;
        switch(nomeEstado) {
            case ACRE: sigla = "AC"; break;
            case ALAGOAS: sigla = "AL"; break;
            case AMAZONAS: sigla = "AM"; break;
            case AMAPA: sigla = "AP"; break;
            case BAHIA: sigla = "BA"; break;
            case CEARA: sigla = "CE"; break;
            case DISTRITO_FEDERAL: sigla = "DF"; break;
            case ESPIRITO_SANTO: sigla = "ES"; break;
            case GOIAS: sigla = "GO"; break;
            case MARANHAO: sigla = "MA"; break;
            case MATO_GROSSO: sigla = "MT"; break;
            case MATO_GROSSO_SUL: sigla = "MS"; break;
            case MINAS_GERAIS: sigla = "MG"; break;
            case PARA: sigla = "PA"; break;
            case PARAIBA: sigla = "PB"; break;
            case PARANA: sigla = "PR"; break;
            case PERNAMBUCO: sigla = "PE"; break;
            case PIAUI: sigla = "PI"; break;
            case RIO_JANEIRO: sigla = "RJ"; break;
            case RIO_GRANDE_NORTE: sigla = "RN"; break;
            case RIO_GRANDE_SUL: sigla = "RS"; break;
            case RONDONIA: sigla = "RO"; break;
            case RORAIMA: sigla = "RR"; break;
            case SANTA_CATARINA: sigla = "SC"; break;
            case SAO_PAULO: sigla = "SP"; break;
            case SERGIPE: sigla = "SE"; break;
            case TOCANTINS: sigla = "TO"; break;
            default: sigla = "Não Informado";
        };

        return sigla;
    }
}
