package DTO;

public class FuncionariosDTO {
    private String nome;
    private Integer codigo;

    public FuncionariosDTO(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Setters

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    ///////////////////////////////////////////////////
    // Getters

    public Integer getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
}
