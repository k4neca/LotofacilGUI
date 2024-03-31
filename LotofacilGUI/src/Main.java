import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        Random gerador = new Random();

        boolean condicao;
        int numero, numSorteado, opcao;
        char letra, letraSorteada = 'C';
        String tela;

        do {
            ImageIcon icon = new ImageIcon("NP_Logo.png");
            ImageIcon iconNumbers = new ImageIcon("numbers.png");
            ImageIcon iconLetras = new ImageIcon("letras.png");
            ImageIcon iconParImpar = new ImageIcon("parImpar.png");
            ImageIcon iconExit = new ImageIcon("exit.png");

            tela = (String) JOptionPane.showInputDialog(null,"1) Apostar de 0 a 100\n2) Apostar de A à Z\n3) Apostar em par ou impar\n0) Sair",
                    "MENU LOTOFÁCIL", JOptionPane.INFORMATION_MESSAGE, icon,null,"");

            opcao = Integer.parseInt(tela);

            switch (opcao){
                case 1:
                    do {
                        try {
                            tela = (String) JOptionPane.showInputDialog(null,"Digite um numero de 0 a 100: ",
                                    "Apostar de 0 a 100", JOptionPane.INFORMATION_MESSAGE, iconNumbers,null,"");
                            numero = Integer.parseInt(tela);
                            if (numero < 0 || numero > 100) {
                                JOptionPane.showMessageDialog(null,"O numero informado não está entre 0 e 100","Número inválido", JOptionPane.ERROR_MESSAGE);
                                condicao = false;
                            }else {
                                numSorteado = gerador.nextInt(101);
                                if (numero == numSorteado){
                                    JOptionPane.showMessageDialog(null,"Parabens você ganhou R$ 1.000,00 reais!");
                                    condicao = true;
                                }else {
                                    JOptionPane.showMessageDialog(null,"Infelizmente o número sorteado foi o " +numSorteado);
                                    condicao = true;
                                }
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor digite um número válido!");
                            condicao = false;
                        }
                    }while (!condicao);
                    break;
                case 2:
                    do {
                        tela = (String) JOptionPane.showInputDialog(null,"Digite uma letra de A à Z: ",
                                "Apostar de A à Z", JOptionPane.INFORMATION_MESSAGE, iconLetras,null,"");
                        letra = tela.charAt(0);
                        letra = Character.toUpperCase(letra);
                        if (Character.isLetter(letra)){
                            if (letra == letraSorteada){
                                JOptionPane.showMessageDialog(null,"Parabéns, você ganhou R$ 500,00 reais!");
                                condicao = true;
                            }else {
                                JOptionPane.showMessageDialog(null,"Que pena! A letra sorteada foi: " +letraSorteada);
                                condicao = true;
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Por favor digite uma letra!");
                            condicao = false;
                        }
                    }while (!condicao);
                    break;
                case 3:
                    try {
                        tela = (String) JOptionPane.showInputDialog(null,"Informe um numero inteiro:",
                                "Apostar em par ou ímpar", JOptionPane.INFORMATION_MESSAGE, iconParImpar,null,"");
                        numero = Integer.parseInt(tela);

                        if (numero % 2 == 0){
                            JOptionPane.showMessageDialog(null,"Parabéns! Você ganhou R$ 100,00 reais");
                        }else {
                            JOptionPane.showMessageDialog(null,"Que pena! O número digitado é ímpar e a premiação foi para números pares");
                        }
                    }catch (NumberFormatException err){
                        JOptionPane.showMessageDialog(null,"Deve ser informado um numero inteiro!");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Saindo","Encerrando o programa",JOptionPane.INFORMATION_MESSAGE,iconExit);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção escolhida inválida");
                    break;
            }
        }while (opcao != 0);
    }
}