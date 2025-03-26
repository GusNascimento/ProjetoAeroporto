import java.util.ArrayList;
import javax.swing.*;

public class Main {
    static ArrayList<Voo> voos = new ArrayList<Voo>();
    static ArrayList<Aviao> aeronaves = new ArrayList<Aviao>();



    public static void main(String[] args) {
        String temp = "";
        int menu;
        do {
            try{
               temp = JOptionPane.showInputDialog("Bem vindo ao Gerenciador de Voos!" + "\n 1 - Parâmetros do Sistema"
                        + "\n 2 - Reserva de Passagens" + "\n 3 - Sair");

                menu = Integer.parseInt(temp);
            } catch (Exception e) {
                if (temp == null){
                    menu = 3;
                } else {
                    menu = 4;
                }
            }

            switch (menu){
                case 1:
                    CadastrarSistema();
                    break;
                case 2:
                    ReservaPassagem();
                    break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Houve um erro! Tente novamente");
                    break;
            }

        } while (menu != 3);


    }

   

    private static void CadastrarSistema() {
        String temp = "";
        int aux;

        do {
            try {
                temp = JOptionPane.showInputDialog("Parâmetros do Sistema" + "\n 1 - Cadastrar Aeronave" +
                        "\n 2 - Cadastrar Voo" + "\n 3 - Voltar");
                aux = Integer.parseInt(temp);
            } catch (Exception e) {
                if (temp == null){
                    aux = 3;
                } else {
                    aux = 4;
                }
            }

            switch (aux){
                case 1:
                    CadastrarAviao();
                     break;
                case 2:
                    CadastrarVoo();
                    break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Houve um erro! Tente novamente");
                    break;
            }
        } while (aux != 3);
    }

    private static void CadastrarAviao() {
        boolean isItDone = false;
        boolean isFileira = false;
        String modelo = "";
        int cadeira = 0;
        int fileira = 0;

        modelo = JOptionPane.showInputDialog("Cadastrar um Avião:" + "\n Insira o Modelo");
        do {
            try{
                String auxCad1 = JOptionPane.showInputDialog("Insira o número de cadeiras neste avião" +
                        "\n  (Prefira números pequenos)");
                cadeira = Integer.parseInt(auxCad1);
                isItDone = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira um número!");
            }
        } while (!isItDone);

        do {
            try{
                String auxCad1 = JOptionPane.showInputDialog("Insira o número de fileiras neste avião" +
                        "\n  (Prefira números pequenos)");
                fileira = Integer.parseInt(auxCad1);
                isFileira = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira um número!");
            }
        } while (!isFileira);

        Aviao aviao = new Aviao(modelo, cadeira, fileira);
        aeronaves.add(aviao);

        JOptionPane.showMessageDialog(null, "Aeronave '" + aviao.getModelo() + " " + aeronaves.size() +"' cadastrada com sucesso!");
    }

    private static void CadastrarVoo() {
        String tempVoo = "";
        String data, horario, aux;
        Boolean isItDone = false;
        int aviao = 0;

        for (int i = 0; i < aeronaves.size(); i++) {
            tempVoo += "\n " + (i + 1) + " - " + aeronaves.get(i).getModelo();
        }

        do {
            try {
                aux =  JOptionPane.showInputDialog("Cadastrar um Voo:" + "\n Selecione o Avião" + tempVoo);
                aviao = Integer.parseInt(aux) - 1;
                isItDone = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira um número!");
            }
        } while (!isItDone);

        data = JOptionPane.showInputDialog("Cadastrar um Voo:" + "\n Selecione a Data de Voo");
        horario = JOptionPane.showInputDialog("Cadastrar um Voo:" + "\n Selecione o Horário do Voo");

        Voo voo = new Voo(aeronaves.get(aviao), voos.size(), data, horario);

        voos.add(voo);
    }




    private static void ReservaPassagem() {
        int menu = 0;

        do {
            String temp = "";

            try {
                temp = JOptionPane.showInputDialog("Bem vindo ao Gerenciador de Voos!" + "\n 1 - Fazer Reserva"
                        + "\n 2 - Consultar Lugares Vazios" + "\n 3 - Consultar Reservas Realizadas" + "\n 4 - Voltar");
                menu = Integer.parseInt(temp);

            } catch (Exception e) {
               if (temp == null){
                   menu = 4;
               } else {
                   menu = 5;
               }
            }

            switch (menu) {
                case 1:
                    FazerReserva();
                    break;
                case 2:
                    ConsultarLugaresVazios();
                    break;
                case 3:
                    ConsultaLugaresReservados();
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Houve um erro! Tente novamente");
                    break;
            }
        } while (menu != 4);
    }

    private static void ConsultaLugaresReservados() {
    }

    private static void ConsultarLugaresVazios() {
    }

    private static void FazerReserva() {
    }
}
