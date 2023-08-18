public class App {
    public static void main(String[] args) {
        ConsultasRepository crv = new ConsultasRepository("poa_temps.txt");
        Consultas consultas = new Consultas(crv);
        consultas.carregaDados();
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consultas.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        consultas.datasEmQueChouveuMaisDe(90)
            .forEach(System.out::println);
    }
}
