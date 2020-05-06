public class Program {

    public static void main(String[] args){
        //Task1();
        //Task2();
    }

    public static void Task1(){
        int bottom = 10;
        int top = 10_000;
        int difference = 5_000;

        for (int i = bottom; i <= top; i++)
        {
            if (i > 1_000 && i < 10_000) {
                String newNumberAsString = "";
                int lastDigit = 0;
                int curNumber = i;

                while (i > 0) {
                    lastDigit = i % 10;
                    i /= 10;
                    if (i == 0)
                        break;
                }

                i = curNumber;
                int newNumberFirstPart = i % 1_000;
                newNumberAsString += newNumberFirstPart;
                newNumberAsString += lastDigit;

                int newNumber = Integer.parseInt(newNumberAsString);
                int currentDifference = Math.abs(curNumber - newNumber);

                if (currentDifference > difference) {
                    System.out.println(curNumber + " " + newNumber + " => " + curNumber + " - " + newNumber + " = " + currentDifference + " > " + difference);
                    //1667 6671 => 1667 - 6671 = 5004 > 5000
                }
            }
        }
    }

    public static void Task2(){
        int n = 6;

        //First part of the body
        for(int i = 1; i <= n; i++){

            for (int space = 0; space < i; space++){
                System.out.print(" ");
            }

            for(int j = i; j <= n; j++){
                System.out.print(j);//left side
            }

            for(int k = n; k >= i; k--){
                System.out.print(k);//right side
            }

            System.out.println();
        }


        //Second part of the body
        for (int i = n - 1; i > 0; i--){

            for (int space = 0; space < i; space++){
                System.out.print(" ");
            }

            for (int j = i; j <= n; j++){
                System.out.print(j);
            }
            
            for (int k = n; k >= i; k--){
                System.out.print(k);
            }

            System.out.println();
        }
    }
}