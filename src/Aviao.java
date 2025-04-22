public class Aviao extends Aeronave{
    public Passageiro[][] lugares;

    public Aviao(String Modelo, int fileira, int cadeira)
    {
        super(Modelo);
        this.lugares = new Passageiro[fileira][cadeira];
    }

    public boolean VerificaLugarOcupado(int fileira, int assento) {
        if (fileira <= 0 || assento <= 0 ||
                fileira > lugares.length || assento > lugares[0].length) {
            return false;
        }
        return lugares[fileira-1][assento-1] != null;
    }

    public Passageiro GetPassageiro(int a, int b)
    {
        return lugares[a][b];
    }

    public void SetPassageiro(int a, int b, Passageiro pass)
    {
        this.lugares[a][b] = pass;
    }
}


