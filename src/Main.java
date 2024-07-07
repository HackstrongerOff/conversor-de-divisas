import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lecturaMoneda = new Scanner(System.in);
        Scanner lecturaAConverir = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        // Array para las monedas
        String[] monedas = {"USD", "COP", "CNY", "JPY", "RUB", "ARS", "BOB", "BRL", "VES", "UYU"};
        // Formatea con cuatro decimales
        DecimalFormat formatDecimal = new DecimalFormat("#.####");

        String text = """
                ************************************************
                *             Resultado conversion             *
                * ---------------------------------------------*
                * Moneda base: %s                             *
                * Moneda de cambio: %s                        *
                * ---------------------------------------------*
                * Valor conversion: %s %s
                ************************************************
                """;

        System.out.println("""
                ************************************************
                *             Conversor de Divisas             *
                ************************************************
                ::   Seleccione divisa que desea convertir    ::
                :: —----------------------------------------- ::
                :: 1 :: USD - Dólar estadounidense
                :: 2 :: COP - Peso colombiano
                :: 3 :: CNY	- Yuan Chino
                :: 4 :: JPY	- Yen Japones
                :: 5 :: RUB	- Rublo Ruso
                :: 6 :: ARS - Peso argentino
                :: 7 :: BOB - Boliviano boliviano
                :: 8 :: BRL - Real brasileño
                :: 9 :: VES	- Bolívar Soberano
                :: 10 : UYU	- Peso Uruguayo
                :: —----------------------------------------- ::
                :: 0 :: Salir
                ************************************************
                """);

        while(true){
            System.out.println("""
                :: —----------------------------------------- ::
                :: Seleccione moneda base:                    ::
                :: —----------------------------------------- ::
                """);
            int captaMoneda1 = Integer.parseInt(lecturaMoneda.nextLine());

                if (captaMoneda1 == 0){
                    System.out.println("Saliendo de la aplicacion.");
                    break;
                }

                if (captaMoneda1 < 1 || captaMoneda1 > monedas.length){
                    System.out.println("Seleccion invalida. Selecciona otra opcion");
                    //break;
                } else {

            // Obtener la moneda seleccionada
            String opcionSeleccionada1 = monedas[captaMoneda1 - 1];
            System.out.println("Moneda seleccionada: "+opcionSeleccionada1);

            System.out.println("""
                :: —----------------------------------------- ::
                :: Seleccione moneda a convertir:             ::
                :: —----------------------------------------- ::
                """);

            int captaMoneda2 = Integer.parseInt(lecturaAConverir.nextLine());

                if (captaMoneda2 < 1 || captaMoneda2 > monedas.length) {
                    System.out.println("Seleccion invalida. Selecciona otra opcion");
                } else {
                    // Obtener la moneda seleccionada
                    String opcionSeleccionada2 = monedas[captaMoneda2 - 1];
                    System.out.println("\nMoneda seleccionada: "+opcionSeleccionada2);

                    Moneda moneda = consulta.buscaMoneda(opcionSeleccionada1);
                    System.out.printf((text) + "%n",
                            opcionSeleccionada1,
                            opcionSeleccionada2,
                            formatDecimal.format(moneda.conversion_rates().get(opcionSeleccionada2)),
                            opcionSeleccionada2);
                }
            }
        }
    }
}
