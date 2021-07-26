package br.com.zupacademy.kleysson.casadocodigo.dto;

public class ErrorFormDTO {
    private String campo;
    private String erro;

    public ErrorFormDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
