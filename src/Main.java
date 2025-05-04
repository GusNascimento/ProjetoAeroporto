import java.util.ArrayList;
import javax.swing.*;

public class Main {
    static ArrayList<Voo> voos = new ArrayList<Voo>();
    static ArrayList<Aviao> aeronaves = new ArrayList<Aviao>();
    static ArrayList <Passageiro> passageiros = new ArrayList<Passageiro>();

    public static void main(String[] args) {
        String temp = "";
        int menu;
        do {
            try{
               temp = JOptionPane.showInputDialog("""
                       Bem vindo ao Gerenciador de Voos!
                        1 - Parâmetros do Sistema\
                       
                        2 - Reserva de Passagens
                        3 - Sair""");

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
                temp = JOptionPane.showInputDialog("""
                        Parâmetros do Sistema
                         1 - Cadastrar Aeronave\
                        
                         2 - Cadastrar Voo
                         3 - Voltar""");
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
        String modelo = JOptionPane.showInputDialog("Cadastro do Avião:\nInsira o Modelo");
        if(modelo == null || modelo.isEmpty()){
            return;
        }
        int fileira = 0, cadeira = 0;
        int loop = 0;
        int loop2 = 0;

        do {
            try {
                fileira = Integer.parseInt(JOptionPane.showInputDialog("Número de fileiras no avião"));
                if (fileira <= 0) {
                    break;
                }
                loop = 1;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (loop != 1);

        do {
            try{
                cadeira = Integer.parseInt(JOptionPane.showInputDialog("Número de fileiras no avião"));
                if (cadeira <= 0) {
                    break;
                }
                loop2 = 1;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (loop2 != 1);

        Aviao aviao = new Aviao(modelo, fileira, cadeira);
        aeronaves.add(aviao);

        JOptionPane.showMessageDialog(null,
                "Aeronave '" + modelo + "' cadastrada com sucesso!\n" +
                        "Capacidade: " + (fileira * cadeira) + " passageiros\n" +
                        aeronaves.size() + " na lista.");
    }
    private static void CadastrarVoo() {
        StringBuilder tempVoo = new StringBuilder();
        String data, horario, aux;
        boolean isItDone = false;
        int aviao = 0;

        for (int i = 0; i < aeronaves.size(); i++) {
            tempVoo.append("\n ").append(i + 1).append(" - ").append(aeronaves.get(i).getModelo());
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
                temp = JOptionPane.showInputDialog("""
                        Bem vindo ao Gerenciador de Voos!
                         1 - Fazer Reserva\
                        
                         2 - Consultar Lugares Vazios
                         3 - Consultar Reservas Realizadas
                         4 - Voltar""");
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
                    ConsultaReservas();
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
    private static void FazerReserva() {
        String nome = "";
        String cpf = "";
        if (voos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não há voos disponíveis!");
        }

        int selecVoo = 0, selecCpf = 0;

        do {
            try {
                nome = JOptionPane.showInputDialog("Digite o nome do passageiro:");
                selecVoo = 1;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Insira um nome válido");
            }
        } while(selecVoo != 1);


        do {
            try {
                cpf = JOptionPane.showInputDialog("Digite o CPF do passageiro:");
                selecCpf = 1;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Insira um nome válido");
            }
        } while(selecCpf != 1);

        Passageiro pass = new Passageiro(nome, cpf);

        StringBuilder listaVoos = new StringBuilder();
        for (int i = 0; i < voos.size(); i++) {
            Voo v = voos.get(i);
            listaVoos.append("\n").append(i+1).append(" - Voo ").append(v.nro)
                    .append(" (").append(v.data).append(" ").append(v.horario).append(")");
        }


        Voo vooCad = null;

        while (vooCad == null) {
            try {
                String input = JOptionPane.showInputDialog("Selecione o avião" + listaVoos);
                int selectInput = Integer.parseInt(input) - 1;
                vooCad = voos.get(selectInput);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Seleção inválida!");
            }
        }

        int cont = 0;
        while (cont == 0) {
            try {
                String exib = mostraMatrix(voos.indexOf(vooCad));
                int row = Integer.parseInt(JOptionPane.showInputDialog(exib +
                        "\n Digite a fileira desejada ( 1 -" + vooCad.aviao.lugares.length + "):"));
                int seat = Integer.parseInt(JOptionPane.showInputDialog(exib +
                        "\n Digite o assento desejado ( 1 -" + vooCad.aviao.lugares[0].length + "):"));
                if (row < 1 || row > vooCad.aviao.lugares[0].length || seat < 1 || seat > vooCad.aviao.lugares[0].length){
                    throw new Exception("Fora dos limites");
                }

                if (VerificaLugar(vooCad,row,seat)) {
                    vooCad.aviao.lugares[row-1][seat-1] = pass;
                    JOptionPane.showMessageDialog(null,
                            "Reserva confirmada para " + nome +
                                    "\nVoo: " + vooCad.nro +
                                    "\nAssento: " + row + "-" + seat);
                    cont = 1;
                    passageiros.add(pass);
                } else{
                    JOptionPane.showMessageDialog(null, "Assento já ocupado! Selecione outro.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Valores inválidos!\n" +
                                "Fileira deve ser 1-" + vooCad.aviao.lugares.length + "\n" +
                                "Assento deve ser 1-" + vooCad.aviao.lugares[0].length);
            }
        }
    }
    private static void ConsultaLugaresReservados() {
        if (voos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não há voos disponíveis!");
        }

        StringBuilder listaConsultaVoos = new StringBuilder();
        for (int i = 0; i < voos.size(); i++) {
            Voo v = voos.get(i);
            listaConsultaVoos.append("\n").append(i+1).append(" - Voo ").append(v.nro)
                    .append(" (").append(v.data).append(" ").append(v.horario).append(")");
        }
        Voo consultaVoo = null;

        while (consultaVoo == null) {
            try {
                String input = JOptionPane.showInputDialog("Selecione o avião" + listaConsultaVoos);
                int selectInput = Integer.parseInt(input) - 1;
                consultaVoo = voos.get(selectInput);
                String show = mostraMatrix(consultaVoo.getNro());
                JOptionPane.showMessageDialog(null, show);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Seleção inválida!");
            }
        }
        

    }
    private static void ConsultaReservas() {
        if (voos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não há voos disponíveis!");
        }

        StringBuilder listaConsulta = new StringBuilder();
        for (int i = 0; i < voos.size(); i++) {
            Voo v = voos.get(i);
            listaConsulta.append("\n").append(i+1).append(" - Voo ").append(v.nro)
                    .append(" (").append(v.data).append(" ").append(v.horario).append(")");
        }

        Voo teste = null;

        while (teste == null) {
            try {
                String input = JOptionPane.showInputDialog("Selecione o avião" + listaConsulta);
                int selectInput = Integer.parseInt(input) - 1;
                teste = voos.get(selectInput);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Seleção inválida!");
            }
        }

        boolean isItIn = false;
        StringBuilder listaConsultaReservas = new StringBuilder();
        listaConsultaReservas.append("Passageiros do voo: ").append(teste.nro).append("\n");
        for (int fila = 0; fila < teste.aviao.lugares.length ; fila++) {
            for (int cadeira = 0; cadeira < teste.aviao.lugares[fila].length ; cadeira++) {
                if (teste.aviao.lugares[cadeira][fila] != null) {
                    listaConsultaReservas.append(" Fila").append(fila + 1)
                            .append(", Cadeira ").append(cadeira + 1)
                            .append(": ")
                            .append("Nome: ")
                            .append(teste.aviao.lugares[cadeira][fila].nome)
                            .append(" (CPF: ")
                            .append(teste.aviao.lugares[cadeira][fila].cpf)
                            .append(")\n");
                    isItIn = true;
                }
            }
        }

        if (!isItIn){
            listaConsultaReservas.append("Não há passageiros");
        }

        JOptionPane.showMessageDialog(null, listaConsultaReservas);

    }

    public static boolean VerificaLugar(Voo voo, int fila, int cadeira) {
        try {
            return voo.aviao.lugares[fila-1][cadeira-1] == null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return true; // Considera como ocupado se for inválido
        }
    }
    private static String mostraMatrix (int vooIndex){
        Passageiro[][] lugares = voos.get(vooIndex).aviao.lugares;
        StringBuilder sb = new StringBuilder("\nMapa de Ocupação:\n");

        sb.append("     ");
        for (int j = 0; j < lugares[0].length; j++) {
            sb.append(String.format("%2d ", j+1));
        }
        sb.append("\n");

        for (int i = 0; i < lugares.length; i++) {
            sb.append(String.format("F%02d ", i+1));
            for (int j = 0; j < lugares[i].length; j++) {
                sb.append(lugares[i][j] == null ? "[_]" : "[X]").append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

