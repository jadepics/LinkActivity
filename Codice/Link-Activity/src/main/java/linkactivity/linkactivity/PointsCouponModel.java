package linkactivity.linkactivity;

public class PointsCouponModel {

    int cp1;
    int cp2;
    int cp3;
    int points;

    public PointsCouponModel(){}

    public PointsCouponModel(int cp1, int cp2, int cp3, int points){
        setPointsCouponModelCp1(cp1);
        setPointsCouponModelCp2(cp2);
        setPointsCouponModelCp3(cp3);
        setPointsCouponModelPoints(points);
    }

    public PointsCouponModel(int cp1, int cp2, int cp3){
        setPointsCouponModelCp1(cp1);
        setPointsCouponModelCp2(cp2);
        setPointsCouponModelCp3(cp3);
    }

    public PointsCouponModel(int points){
        setPointsCouponModelPoints(points);
    }



    public void setPointsCouponModelCp1(int cp1){
        this.cp1=cp1;
    }

    public int getPointsCouponModelCp1(){
        return cp1;
    }

    public void setPointsCouponModelCp2(int cp2){
        this.cp2=cp2;
    }

    public int getPointsCouponModelCp2(){
        return cp2;
    }

    public void setPointsCouponModelCp3(int cp3){
        this.cp3=cp3;
    }

    public int getPointsCouponModelCp3(){
        return cp3;
    }

    public void setPointsCouponModelPoints(int points){
        this.points=points;
    }

    public int getPointsCouponModelPoints(){
        return points;
    }


}
