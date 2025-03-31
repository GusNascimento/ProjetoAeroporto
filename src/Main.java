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
    // cadastra o avião
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
        boolean isItDone = false;
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

    // passageiro -> mostrar avião -> selecionar voo -> verificar disponbilidade
    // - > verificar quantidade e montar
    private static void FazerReserva() {
       String temp = "";
       String temp2 = "";
       String listaVoo = "";
       String nome = "";
        String cpf = "";
        int voo = 0;
        int assento = 0;
        int fileira = 0;

       nome = JOptionPane.showInputDialog("Digite o nome: ");
       cpf = JOptionPane.showInputDialog("Digite o cpf: ");

       Passageiro pass = new Passageiro(nome, cpf);



        for (int i = 0; i < voos.size(); i++) {
            listaVoo += "\n" + (i + 1) + " - [" + voos.get(i).aviao.getModelo() + " | " + voos.get(i).horario + " - "
                    + voos.get(i).data + "]";
        }

        boolean isItDone = false;

        do {

            try{
                temp2 = JOptionPane.showInputDialog("Digite o número do voo \n" + listaVoo);
                voo = Integer.parseInt(temp2);
                isItDone = true;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Insira um número!");
            }
        } while (!isItDone);

        int quantidadeLivre = qntDisponivel(voos.get(voo-1));

        if (quantidadeLivre > 0){
          boolean verify = false;
          do{

            do {
                try{
                 temp = JOptionPane.showInputDialog("Selecione o assento");
                  assento = Integer.parseInt(temp);
                 verify = true;
                } catch (Exception e) {JOptionPane.showMessageDialog(null, "Insira um número!");
                }
            } while(!verify);

            do {
                try{
                    temp2 = JOptionPane.showInputDialog("Selecione a fileira");
                    fileira = Integer.parseInt(temp2);
                    verify = false;
                } catch (Exception e) {JOptionPane.showMessageDialog(null, "Insira um número!");
                }
            } while(verify);

            verify = VerificaLugar(voos.get(voo-1), fileira, assento);

            if (verify){
                JOptionPane.showMessageDialog(null, "Lugar Ocupado!");
            } else {
                try{
                    voos.get(voo).aviao.lugares[assento][fileira] = pass;
                    JOptionPane.showMessageDialog(null,
                            "Passageiro " + pass.nome + " adicionado com sucesso ao Voo");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Escolha de Fila/Cadeira Inválida" + "\n Fila " + fileira
                            + " & Cadeira " +assento+ "\nnão correspondem a um assento existente no Avião");
                    verify = true;
                }
            }

          } while (verify);

        } else{
            JOptionPane.showMessageDialog(null, "Não há lugares disponíveis nesse voo");
        }


    }

    public static boolean VerificaLugar(Voo voo, int fila, int cadeira) {
        try {
            Passageiro verif = voo.aviao.lugares[fila - 1][cadeira - 1];
            return verif != null;
        } catch (Exception e) {
            return false;
        }
    }
    private static String mostraMatrix (int voo){
        Passageiro [][] matriz = voos.get(voo).aviao.lugares;
        String aux = "";
        for (Passageiro[] p1 : matriz){
            for(Passageiro p2 : p1){
                if (p2 == null){
                    aux += "[_]";
                } else {
                    aux += "[" + p2.nome + "]";
                }
                aux = "\n";
            }
        }
        return aux;
    }

    public static int qntDisponivel (Voo voo){
        Passageiro [][] pass = voo.aviao.lugares;
        int count = 0;
        for (Passageiro[] p1 : pass) {
            for (Passageiro p2 : p1) {
                if (p2 == null){
                    count++;
                }
            }
        }
        return count;
    }
}
