package YazBank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private static int counter = 1;
    private int numeroPessoa;
    private String name;
    private String cpf;
    private String email;
    private Date accountCreationDate = new Date();

    public Usuario(String name, String cpf, String email) {
        this.numeroPessoa = Usuario.counter++;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.accountCreationDate = new Date();
    }
    @Override
    public String toString() {
        return "\nNome: " + this.name + "\nCPF: " + this.cpf + "\nEmail: " + this.email +
                "\nData de Criação da Conta: " + this.accountCreationDate.toString() + "\n";
    }
}
