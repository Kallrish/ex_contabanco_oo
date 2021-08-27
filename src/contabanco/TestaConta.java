/*
Exercício 4 a 5:
4 - No método main do programa, instancie dois objetos Conta e
    compare-os com ==.
5 - Crie 2 referências para a mesma conta e compare com ==.
Obs.: A resolução foi abreviada no código para evitar excesso
      de codificação repetida no mesmo programa, mas foi
      acrescentada uma explanação para o número 5 comentada
      próximo a comparação.
Obs2.: Após finalizar todos os outros exercícios,
       tudo é implementado e testado após a comparação citada
       acima.
 */

package contabanco;

import java.time.LocalDate;

/** Compara se as contas são iguais.*/
public class TestaConta {
  /** Classe principal: Roda o programa.*/
  public static void main(String [] args) {
    //instancia objeto e atribui valores da conta1
    Conta conta1 = new Conta("Ana");
    conta1.setAgencia("0001");
    conta1.setNumero("0001");
    conta1.setLimite(1000);
    conta1.dataDeAbertura = LocalDate.now();

    //instancia objeto e atribui valores da conta2
    Conta conta2 = new Conta();
    conta2.setAgencia("0001");
    conta2.setNumero("0002");
    conta2.setTitular("João");
    conta2.setLimite(1000);
    conta2.dataDeAbertura = LocalDate.now();

    //testa se as contas são iguais
    if (conta1 == conta2) {
      System.out.println("As contas são iguais.\n");
    } else {
      System.out.println("As contas são diferentes.\n");
    }
    /*
    ###Atenção###
    Ao tentar clonar uma conta (que por algum motivo precisaria
    de atributos similares) usando "conta2 = conta1" e testar
    com o mesmo "if" acima, o resultado seria verdadeiro, pois
    ao realizar essa atribuição, as contas passam a se referenciar
    ao mesmo endereço de memória já que a as variáveis não guardam
    o objeto, mas sim sua referência na memória.
    Para comparar os atributos, seria necessário usar os atributos
    em si na comparação.
     */

    //Mostra os dados cadastrados das duas contas.
    conta1.recuperaDadosParaImpressao();
    conta2.recuperaDadosParaImpressao();

    //Realiza saque na conta2 e deposito na conta1
    conta2.sacam(1000);
    conta1.depositam(2000);

    //Mostra o saldo atual das contas para conferir a operação (contando limite)
    conta1.getSaldoMsg();
    conta2.getSaldoMsg();

    //Realiza transferência da conta1 para conta2
    conta1.transferePara(conta2, 1000);

    //Mostra o saldo atual das contas para conferir a operação (contando limite)
    conta1.getSaldoMsg();
    conta2.getSaldoMsg();

    //Retorna o cálculo de rendimento das duas contas
    conta1.calculaRendimento();
    conta2.calculaRendimento();

    //Retorna quantas contas foram abertas até o momento
    Conta.getTotalDeContasMsg();
  }
}
