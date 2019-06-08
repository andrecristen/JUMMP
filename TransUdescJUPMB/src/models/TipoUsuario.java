package models;
// representa os tipos de pessoa no sistema

public enum TipoUsuario {
    MOTORISTA("Motorista"),
    MECANICO("Mecânico"),
    CLIENTE("Cliente"),
    ADMINISTRADOR("Administrador");

    private String tipo;

    public static TipoUsuario fromString(String text) {
        for (TipoUsuario tipo : TipoUsuario.values()) {
            if (tipo.tipo.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        return null;
    }

    private TipoUsuario(String nome) {
        this.tipo = nome;
    }

    @Override
    public String toString() {
        return tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
