package YazBank;

import lombok.Data;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Conta {
    private static int counter = 1;

    private int numeroConta;
    private Usuario usuario;
    private double saldo;

    public Conta(Usuario usuario) {
        this.numeroConta = Conta.counter++;
        this.usuario = usuario;
        this.saldo = 0.0;
    }

    public void depositar(Double valor) {
        this.saldo += valor;
    }

    public void sacar(Double valor) {
        if (this.saldo <= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void transferencia(Conta destinatario, Double valor) {
        if (valor > this.saldo) {
            this.sacar(valor);
            destinatario.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    @Override
    public String toString() {
        return "Número da Conta: " + this.numeroConta + "\nSaldo: " + this.saldo +
                "\nUsuário: " + this.usuario;
    }

}
