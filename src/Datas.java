public class Datas{

    private int dia;
    private int mes;
    private int ano;

    public Datas(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public void setDia(int d){
        this.dia = d;
    }

    public int getDia(){
        return this.dia;
    }
    public void setMes(int m){
        this.mes = m;
    }

    public int getMes(){
        return this.mes;
    }

    public void setAno(int a){
        this.ano = a;
    }

    public int getAno(){
        return this.ano;
    }

    public String toString(){
        return dia + "/" + mes + "/" + ano;
    }
}