/*
Exercício: 6 (parcial):
6 - Ao invés de usar uma String para representar a data, crie outra
    classe chamada Data. Ela tem 3 campos int: dia, mês, ano.
==========
Atualizando as classes conforme os exercícios do capítulo 5.8
sobre encapsulamento, construtores e static.

Essa classe passa a ser "deprecated" no programa devido
ao uso da biblioteca LocalDate que facilita muito trabalhar
com datas, mas ela permanece para dar sentido ao exercício
que solicitava a criação da mesma.

A implementação da biblioteca LocalDate (disponível no JAVA 8+)
é de iniciativa minha e não tem relação com o que é pedido
nos exercícios.
 */

package contabanco;

/** Atributos da data. */
public class Data {
  //Define variáveis da classe
  private static String dia;
  private static String mes;
  private static String ano;
  private static String dataDeAbertura;

  //Altera a data completa de uma vez
  /** Recebe a data e distribui nas variáveis. */
  public static void entraData(String dia, String mes, String ano) {
    Data.dia = dia;
    Data.mes = mes;
    Data.ano = ano;
  }

  //Retorna a data completa formatada
  public static String dataFormatada() {
    return Data.dia + "/" + Data.mes + "/" + Data.ano;
  }
}
