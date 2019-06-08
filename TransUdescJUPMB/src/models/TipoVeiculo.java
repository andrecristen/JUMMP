package models;
//representa os tipos de veiculos no sistema

public enum TipoVeiculo {
    CARRO("Carro"),
    CAMINHAO("Caminhão"),
    FURGAO("Furgão"),
    UTILITARIO("Utilitário");

    private String tipo;

    public static TipoVeiculo fromString(String text) {
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            if (tipo.tipo.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        return null;
    }

    private TipoVeiculo(String nome) {
        this.tipo = nome;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
