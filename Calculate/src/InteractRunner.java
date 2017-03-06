import  java.util.Scanner;

public class InteractRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try{
            Calculator calc = new Calculator();
            String exit ="no";
            while (!exit.equals("yes")){
                System.out.println("Enter");
                String first = reader.next();

                System.out.println("Sign");
                String sign = reader.next();

                System.out.println("Enter");
                String two = reader.next();


                switch(sign){
                    case "+": calc.add(Integer.valueOf(first),Integer.valueOf(two)); break;
                    case "-": calc.minus(Integer.valueOf(first),Integer.valueOf(two)); break;
                    case "*": calc.umnojenie(Integer.valueOf(first),Integer.valueOf(two)); break;
                    case "/": calc.div(Integer.valueOf(first),Integer.valueOf(two)); break;
                }
                System.out.println("Result="+calc.getResult());
                System.out.println("exit yes/no");
                calc.clear();
                exit=reader.next();
            }
        }finally {
            reader.close();
        }

    }
}
