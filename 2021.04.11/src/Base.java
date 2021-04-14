class Base2 {
    public Base2(String s) {
        System.out.println("B");
    }

}
public class Base extends Base2{
    public Base(String s){
        super(s);
    }

}
