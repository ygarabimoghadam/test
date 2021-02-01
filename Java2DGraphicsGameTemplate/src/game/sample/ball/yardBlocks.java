package game.sample.ball;

public class yardBlocks {
    private String name;
    private int life;
    private int hurt;
    private long bornTime;
    private int makeTime;
    private int locX;
    private int locy;
    private int count;
    public yardBlocks(){
         life=0;
         hurt=0;
         bornTime=0;
         makeTime=0;
         count=0;
         name="empty";
    }

    public String getName() {
        return name;
    }

    public long getBornTime() {
        return bornTime;
    }

    public int getHurt() {
        return hurt;
    }

    public int getLife() {
        return life;
    }

    public int getMakeTime() {
        return makeTime;
    }

    public int getLocX() {
        return locX;
    }

    public int getLocy() {
        return locy;
    }

    public int getCount() {
        return count;
    }

    public void setBornTime(long bornTime) {
        this.bornTime = bornTime;
    }

    public void setSunFlower(int x, int y, long bornTime, int life, int makeTime){
        name="flower";
        this.locX=x;
        this.locy=y;
        this.life=life;
        this.bornTime=bornTime;
        this.makeTime=makeTime;
    }
    public void setShooter(int x,int y,long bornTime,int life,int makeTime,int hurt){
        name="shooter";
        this.locX=x;
        this.locy=y;
        this.life=life;
        this.hurt=hurt;
        this.bornTime=bornTime;
        this.makeTime=makeTime;
    }
    public void setFShooter(int x,int y,long bornTime,int life,int makeTime,int hurt){
        name="fshooter";
        this.locX=x;
        this.locy=y;
        this.life=life;
        this.hurt=hurt;
        this.bornTime=bornTime;
        this.makeTime=makeTime;
    }
    public void setGiant(int x,int y,int life){
        name="giant";
        this.locX=x;
        this.locy=y;
        this.life=life;
    }
    public void decreasLife(int x){
        life=life-x;
    }
    public void increasCount(){
        count++;
    }
    public void decreasCount(){
        count--;
    }






}
