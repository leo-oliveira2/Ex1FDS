//data precip maxima minima horas_insol temp_media um_relativa vel_vento
public class RegistroDoTempo {
    private Datas data;
    private double precipitacao;
    private double tempMaxima;
    private double tempMinima;
    private double horasInsolacao;
    private double temperaturaMedia;
    private double umidadeRelativaDoAr;
    private double velocidadeDoVento;
    
    public RegistroDoTempo(Datas data, double precipitacao, double tempMaxima, double tempMinima,
            double horasInsolacao, double temperaturaMedia, double umidadeRelativaDoAr, double velocidadeDoVento) {
        this.data = data;
        this.precipitacao = precipitacao;
        this.tempMaxima = tempMaxima;
        this.tempMinima = tempMinima;
        this.horasInsolacao = horasInsolacao;
        this.temperaturaMedia = temperaturaMedia;
        this.umidadeRelativaDoAr = umidadeRelativaDoAr;
        this.velocidadeDoVento = velocidadeDoVento;
    }

    public Datas getData(){
        return this.data;
    }

    public String getDataStr(){
        return data.toString();
    }

    public int getDia() {
        return data.getDia();
    }

    public void setDia(int dia) {
        data.setDia(dia);
    }

    public int getMes() {
        return data.getMes();
    }

    public void setMes(int mes) {
        data.setMes(mes);
    }

    public int getAno() {
        return data.getAno();
    }

    public void setAno(int ano) {
        data.setAno(ano);
    }

    public double getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(double precipitacao) {
        this.precipitacao = precipitacao;
    }

    public double getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(double tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public double getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(double tempMinima) {
        this.tempMinima = tempMinima;
    }

    public double getHorasInsolacao() {
        return horasInsolacao;
    }

    public void setHorasInsolacao(double horasInsolacao) {
        this.horasInsolacao = horasInsolacao;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public double getUmidadeRelativaDoAr() {
        return umidadeRelativaDoAr;
    }

    public void setUmidadeRelativaDoAr(double umidadeRelativaDoAr) {
        this.umidadeRelativaDoAr = umidadeRelativaDoAr;
    }

    public double getVelocidadeDoVento() {
        return velocidadeDoVento;
    }

    public void setVelocidadeDoVento(double velocidadeDoVento) {
        this.velocidadeDoVento = velocidadeDoVento;
    }

    @Override
    public String toString() {
        return "RegistroDoTempo [ano=" + data.getAno() + ", dia=" + data.getDia() + ", horasInsolacao=" + horasInsolacao + ", mes=" + data.getMes()
                + ", precipitacao=" + precipitacao 
                + ", temperatura Maxima=" + tempMaxima + ", temperatura Minima=" + tempMinima
                + ", temperaturaMedia=" + temperaturaMedia + ", umidadeRelativaDoAr=" + umidadeRelativaDoAr
                + ", velocidadeDoVento=" + velocidadeDoVento + "]";
    }    
}
