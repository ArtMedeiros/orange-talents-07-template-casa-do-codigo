package br.com.zupacademy.kleysson.casadocodigo.dto.request;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.ObjectExists;
import br.com.zupacademy.kleysson.casadocodigo.config.validation.UniqueColumn;
import br.com.zupacademy.kleysson.casadocodigo.model.Cliente;
import br.com.zupacademy.kleysson.casadocodigo.model.Estado;
import br.com.zupacademy.kleysson.casadocodigo.model.Pais;
import br.com.zupacademy.kleysson.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.kleysson.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequest {

    @NotEmpty
    @Email
    @UniqueColumn(field = "email", entity = Cliente.class)
    private String email;

    @NotEmpty
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @UniqueColumn(field = "documento", entity = Cliente.class)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ObjectExists(field = "id", entity = Pais.class)
    private Long pais;

    private Long estado;

    @NotBlank
    private String cep;

    @NotBlank
    private String telefone;

    public ClienteRequest() {
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Optional<Pais> paisObj = paisRepository.findById(pais);

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento,cidade, paisObj.get(), cep, telefone);

        if(estadoIsPresent()){
            Optional<Estado> estadoObj = estadoRepository.findById(estado);
            cliente.setEstado(estadoObj.get());
        }


        return cliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean estadoIsPresent(){
        return this.estado != null;
    }
}
