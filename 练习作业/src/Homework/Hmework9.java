import java.util.Scanner;

public class Hmework9 {
    public static void main(String args[]){
        new InputArray().print();
    }
}
class InputArray{
    private int araay[] = new int[20];
    private int flag;
    int i = 0;
    InputArray(){
        Scanner input = new Scanner(System.in);
        for(i=0;i<this.araay.length;i++){
            this.araay[i] = input.nextInt();

            if(this.araay[i] == -1){
                break;
            }
        }
        input.close();
        flag = i;
    }
    public void print(){
        for(int i=flag-1;i>=0;i--){
            System.out.print(this.araay[i]+" ");
        }
    }
}
