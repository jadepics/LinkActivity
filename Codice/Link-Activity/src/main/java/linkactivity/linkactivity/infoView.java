package linkactivity.linkactivity;

//Made on demo project Experim 2

public class infoView {
    private String s;
    private Integer i;

    public infoView(String descr, Integer num){
        System.out.println("eccomi4");
        setBeanName(descr);
        setBeanNum(num);
    }

    private void setBeanName(String descr) {
        this.s= descr;
    }
    public String getBeanName(){
        return s;
    }

    private void setBeanNum(Integer i){
        this.i=i;
    }
    public Integer getBeanNum(){
        return i;
    }
}
