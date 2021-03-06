package models;
 // representa status para veiuclos
public enum StatusVeiculo {
    EM_MANUTENCAO("Em Manutenção"),
    OPERANDO("Operando"),
    DESATIVADO("Desativado"),
    AGUARDANDO_MANUTENCAO("Aguardando Manutenção"),
    PRONTO_PARA_OPERAR("Pronto Para Operar");

    private String status;
    
    public static StatusVeiculo fromString(String text) {
        for (StatusVeiculo status : StatusVeiculo.values()) {
            if (status.status.equalsIgnoreCase(text)) {
                return status;
            }
        }
        return null;
    }
    
    private StatusVeiculo(String nome) {
        this.status = nome;
    }

    @Override
    public String toString() {
        return status;
    }
}
