/*
Exercícios 1 a 3, 6 (parcial), 7:
1 - Modelar a classe de uma conta de banco com seus atributos
    e métodos.
2 - Transformar o modelo em uma classe Java chamada Conta.
    A classe deve ter os atributos nome do titular, número, agência,
    saldo, data de abertura e as ações sacar, depositar e calcular
    rendimento (saldo é multiplicado por 0.1.
3 - Na classe Conta, crie um método recuperaDadosParaImpressão()
    que não recebe parâmetros e devolve o texto com todas as
    informações da conta.
6 - Ao invés de usar uma String para representar a data, crie outra
    classe chamada Data. Ela tem 3 campos int: dia, mês, ano. Faça
    com que sua conta passe a usá-la.
7 - Modifique seu método recuperaDadosParaImpressão para que ele
    devolva o valor da dataDeAbertura da Conta.
==========
Atualizando as classes conforme os exercícios do capítulo 5.8
sobre encapsulamento, construtores e static


 */

package contabanco;

import java.time.LocalDate;

/** Atributos e métodos da conta bancária. */
public class Conta {
  //Variáveis da classe conta
  private static int totalDeContas;
  private static int proximoIdentificador = 0;

  //Variáveis das instâncias da classe conta
  private int identificador;
  private String numero;
  private String agencia;
  private String titular;
  private double limite;
  LocalDate dataDeAbertura;
  private double saldo = 0;


  //construtores

  //Contabiliza o número de contas abertas
  /** Construtor sem parâmetros. */
  public Conta() {
    Conta.totalDeContas = Conta.totalDeContas + 1;
    this.identificador = Conta.proximoIdentificador++;
  }

  //Permite informar o nome do titular durante a criação do objeto
  /** Construtor com nome do titular. */
  public Conta(String titular) {
    Conta.totalDeContas++;
    this.titular = titular;
    this.identificador = Conta.proximoIdentificador++;
  }

  //Getters and Setters

  //Retorna o identicador da conta
  public int getIdentificador() {
    return this.identificador;
  }

  //Retorna o identicador da conta com mensagem
  public void getIdentificadorMsg() {
    System.out.println("O identificador desta conta é: " + getIdentificador()
                      + ".");
  }

  //Retorna o numero
  public String getNumero() {
    return this.numero;
  }

  //Retorna o numero da conta com mensagem
  public void getNumeroMsg() {
    System.out.println("O número da conta é: " + getNumero() + ".");
  }

  //Altera o numero
  public void setNumero(String numero) {
    this.numero = numero;
  }

  //Retorna a agencia
  public String getAgencia() {
    return this.agencia;
  }

  //Retorna a agencia com mensagem
  public void getAgenciaMsg() {
    System.out.println("O número da agência é: " + getAgencia() + ".");
  }

  //Altera a agencia
  public void setAgencia(String agencia) {
    this.agencia = agencia;
  }

  //Retorna o titular
  public String getTitular() {
    return this.titular;
  }

  //Retorna o titular com mensagem
  public void getTitularMsg() {
    System.out.println("O titular é: " + getTitular() + ".");
  }

  //Altera o titular
  public void setTitular(String titular) {
    this.titular = titular;
  }

  //Retorna o limite
  public double getLimite() {
    return this.limite;
  }

  //Retorna o limite com mensagem
  public void getLimiteMsg() {
    System.out.println("O limite é: " + getLimite() + ".");
  }

  //Altera o limite
  public void setLimite(double limite) {
    this.limite = limite;
  }

  //Retorna data
  public LocalDate getdataDeAbertura() {
    return this.dataDeAbertura;
  }

  //Retorna data com mensagem
  public void getdataDeAberturaMsg() {
    System.out.println("A data de abertura é: " + getdataDeAbertura() + ".");
  }

  //Retorna saldo + limite
  public double getSaldo() {
    return this.saldo + this.limite;
  }

  //Retorna saldo + limite com mensagem
  public void getSaldoMsg() {
    System.out.println("O saldo é: " + getSaldo() + ".\n");
  }

  //Retorna total de contas
  public static int getTotalDeContas() {
    return Conta.totalDeContas;
  }

  //Retorna total de contas com mensagem
  public static void getTotalDeContasMsg() {
    System.out.println("O total de contas até agora é: " + getTotalDeContas() + ".");
  }

  //Métodos

  //Realiza saque de valores na conta
  /** Método para saque. */
  public double saca(double valor) {
    if (this.saldo < valor) {
      System.out.println("Seu saldo é insuficiente!\n");
    } else {
      this.saldo -= valor;
    }
    return this.saldo;
  }

  //Realiza saque de valores na conta e retorna mensagem
  /** Método para saque c/ mensagem. */
  public void sacam(double valor) {
    saca(valor);
    if (this.saldo > valor) {
      System.out.println("Saque de R$" + valor + " realizado na conta "
              + getNumero() + " com sucesso!\n");
    }
  }

  //Realiza depósito de valores na conta
  /** Método para depósito. */
  public double deposita(double valor) {
    if (valor <= 0) {
      System.out.println("Insira um valor positivo\n");
    } else {
      this.saldo += valor;
    }
    return this.saldo;
  }

  //Realiza depósito de valores na conta e retorna mensagem
  /** Método para depósito c/ mensagem. */
  public void depositam(double valor) {
    deposita(valor);
    System.out.println("Depósito de R$" + valor + " realizado na conta "
            + getNumero() + " com sucesso!\n");
  }

  //Transfere valores de uma conta para outra
  /** Método para transferência. */
  public void transferePara(Conta destino, double valor) {
    if (this.saldo < valor) {
      System.out.println("Saldo da conta é insuficiente!\n");

    } else if (valor <= 0) {
      System.out.println("Insira um valor positivo\n");
    } else {
      this.saca(valor);
      destino.deposita(valor);
      System.out.println("Transferência de R$" + valor + " da conta "
                       + getNumero() + " para conta " + destino.getNumero()
                       + " realizado com sucesso!\n");
    }
  }

  public void calculaRendimento() {
    System.out.println("A conta " + getNumero() + " terá rendimento de R$"
                      + this.saldo * 0.1 + " este mês.\n");
  }

  /** Método imprimir dados da conta na tela. */
  public void recuperaDadosParaImpressao() {
    //Define atributo e atribui valores para impressão
    System.out.println("Dados da conta:\n");
    getIdentificadorMsg();
    getAgenciaMsg();
    getNumeroMsg();
    getTitularMsg();
    getLimiteMsg();
    getdataDeAberturaMsg();
    getSaldoMsg();
  }

}
