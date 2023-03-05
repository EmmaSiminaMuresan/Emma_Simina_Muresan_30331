package LAB1;

public class ex1 {
    public static void main(String[] args) {
        int a = 2, b = 5, c = 4, d = -1;

        int sum_real = a+c;
        int sum_img = b+d;
        int prod_real = a*c - b*d;
        int prod_img = a*d + b*c;

        if(sum_img > 0)
            System.out.println("Sum = " + sum_real + " + "+ sum_img + "i");
        else
            System.out.println("Sum = " + sum_real + sum_img + "i");
        if(prod_img > 0)
            System.out.println("Prod = " + prod_real + " + " + prod_img + "i");
        else
            System.out.println("Prod = " + prod_real  + prod_img + "i");
    }
}
