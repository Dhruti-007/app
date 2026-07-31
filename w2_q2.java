class book {
  String ti;
  String au;
  double pr;
  
    void dis() {
        System.out.println("Title: " + ti);
        System.out.println("Author: " + au);
        System.out.println("Price: " + pr);
    }
}

public class w2_q2 {
    public static void main(String[] args) {
        book b1 = new book();
        b1.ti = "Animal Farm";
        b1.au = "George Orwell";
        b1.pr = 50.00;

        b1.dis();
    }
}
  
