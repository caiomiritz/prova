import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        convertion();
    }

    public static void convertion(){
        text();
    }

    public static void text(){

        Scanner input = new Scanner(System.in);
        System.out.println("Por favor, digite quantas temperaturas irão ser transformadas: ");
        int quantity = input.nextInt();
        float[] temperatures = new float[quantity];
        float[] transTemp;

        int aux = 0;
        while(quantity > aux){
            System.out.println("Por favor digite uma temperatura: (caso for usar temperaturas fracionadas, por favor utilize ',' para separar os numeros)");
            temperatures[aux] = input.nextFloat();
            aux++;
        }

        System.out.println("Por favor, digite qual é a unidade destas temperaturas digitadas: (Celsius, kelvin ou Fahrenheit) ");
        int number = options(input.next());
        System.out.println("Por favor, digite qual é a unidade para ser transformada: (Celsius, Kelvin ou Fahrenheit) ");
        int number2 = options(input.next());

        System.out.println("As unidades passadas foram: ");
        for(int i=0; i<temperatures.length; i++){
            System.out.println(temperatures[i] +condition(number));
        }
        System.out.println("A média das temperaturas iniciais foi: " +initialMed(temperatures));


        transTemp = transformation(number, number2, temperatures);
        System.out.println("As transformações foram, respectivamente: ");
        for(int i=0; i<temperatures.length; i++){
            System.out.println(transTemp[i] +condition(number2));
        }
        System.out.println("A média das temperaturas transformadas foi: " +translMed(transTemp));
    }


    public static int options(String key){

        if(key.equals("Celsius"))
            return 1;
        else if(key.equals("Kelvin"))
            return 2;
        else if(key.equals("Fahrenheit"))
            return 3;
        else
            return 0;
    }
    public static String condition(int number){
        if(number == 1)
            return "Celsius";
        else if(number == 2)
            return "Kelvin";
        else if(number == 3)
            return "Fahrenheit";
        else
            return "Erro, por favor digite uma unidade de temperatura corretamente (de acordo com os exemplos).";
    }
    public static float[] transformation(int number,int number2, float[] temperatures){


        if(number==1 && number2==2 ){                       //Celsius para Kelvin
            for(int i=0; i<temperatures.length; i++){
                temperatures[i] += 273;
            }
        }
        else if(number==1 && number2==3 ){                 //Celsius para Fahrenheit
            for(int i=0; i<temperatures.length; i++){
                temperatures[i] = ((temperatures[i]*1.8f)+32);
            }
        }
        else if(number==2 && number2==1 ){               //Kelvin para Celsius
            for(int i=0; i<temperatures.length; i++){
                temperatures[i] -= 273;
            }
        }
        else if(number==2 && number2==3 ){              //Kelvin para Fahrenheit
            for(int i=0; i<temperatures.length; i++){
                temperatures[i] = (1.8f*(temperatures[i]-273)+32);
            }
        }
        else if(number==3 && number2==1 ){             //Fahrenheit para Celsius
            for(int i=0; i<temperatures.length; i++){
                temperatures[i] = (((temperatures[i]-32)*5)/9);
            }
        }
        else if(number==3 && number2==2 ){           //Fahrenheit para Kelvin
            for(int i=0; i<temperatures.length; i++){
                temperatures[i] = ((temperatures[i]+459.67f)*(5/9f));
            }
        }
    return temperatures;
    }
    public static float initialMed (float[] temperatures){
        float aux = 0;

        for(int i=0; i<temperatures.length; i++){
            aux += temperatures[i];
        }

        return (aux/temperatures.length);
    }
    public static float translMed (float[] transTemp){
        float aux = 0;

        for(int i=0; i<transTemp.length; i++){
            aux += transTemp[i];
        }

        return (aux/transTemp.length);
    }

}