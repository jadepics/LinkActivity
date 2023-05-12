package linkactivity.linkactivity;

public class PointsCouponBean {

    int cp1;
    int cp2;
    int cp3;
    int points;

    public PointsCouponBean(){}

    public PointsCouponBean(int cp1, int cp2, int cp3, int points){
        setPointsCouponBeanCp1(cp1);
        setPointsCouponBeanCp2(cp2);
        setPointsCouponBeanCp3(cp3);
        setPointsCouponBeanPoints(points);
    }


    public void setPointsCouponBeanCp1(int cp1){
        this.cp1=cp1;
    }

    public int getPointsCouponBeanCp1(){
        return cp1;
    }

    public void setPointsCouponBeanCp2(int cp2){
        this.cp2=cp2;
    }

    public int getPointsCouponBeanCp2(){
        return cp2;
    }

    public void setPointsCouponBeanCp3(int cp3){
        this.cp3=cp3;
    }

    public int getPointsCouponBeanCp3(){
        return cp3;
    }

    public void setPointsCouponBeanPoints(int points){
        this.points=points;
    }

    public int getPointsCouponBeanPoints(){
        return points;
    }


}
