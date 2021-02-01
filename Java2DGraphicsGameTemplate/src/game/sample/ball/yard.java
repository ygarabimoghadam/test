package game.sample.ball;

import java.util.ArrayList;

public class yard {
   private yardBlocks[][] yard ;
    public  yard(){
       yard =new yardBlocks[5][9];
    }

    public yardBlocks[][] getYard() {
        return yard;
    }

    public int castLocx(int x){
        x = (x - 120) / 110;
        x = Math.max(x, 0);
        x = Math.min(x, 4);
        x= 120 + (x * 110);
        System.out.println("casttoy"+x);
        return x;
    }
    public int castToRow(int x){
        x = (x - 120) / 110;
        x = Math.max(x, 0);
        x = Math.min(x, 4);
        return x;
    }
    public int castLocy(int y){
        y = (y - 80)/87 ;
        y = Math.max(y, 0);
        y = Math.min(y, 8);
        y= 90 + 13 +(y * 87);
        System.out.println("casttox"+y);
        return y;
    }
    public int castToColumn(int y){
        y = (y - 80)/87 ;
        y = Math.max(y, 0);
        y = Math.min(y, 8);
        return y;
    }
    public boolean isEmpty(int x,int y){
        System.out.println("row"+x+"w"+y);
        if (yard[castToRow(x)][castToColumn(y)] == null){
            System.out.println("row"+castToRow(x)+"w"+castToColumn(y));
            return true;}
        else
            return false;
    }


    public void addSunFlowerL1(int x,int y){
    yardBlocks f =new yardBlocks();
    f.setSunFlower(castLocx(x),castLocy(y),System.currentTimeMillis(),50,20);
     yard[castToRow(x)][castToColumn(y)]=f;
    }

    public void addSunFlowerL2(int x,int y){
        yardBlocks f =new yardBlocks();
        f.setSunFlower(castLocx(x),castLocy(y),System.currentTimeMillis(),50,25);
        yard[castToRow(x)][castToColumn(y)]=f;
    }
    public void addShooter(int x,int y){
        yardBlocks s =new yardBlocks();
        s.setShooter(castLocx(x),castLocy(y),System.currentTimeMillis(),70,1,30);
        yard[castToRow(x)][castToColumn(y)]=s;
    }
    public void addFShooter(int x,int y){
        yardBlocks s =new yardBlocks();
        s.setFShooter(castLocx(x),castLocy(y),System.currentTimeMillis(),100,1,35);
        yard[castToRow(x)][castToColumn(y)]=s;
    }
    public void addGiant(int x,int y){
        yardBlocks g =new yardBlocks();
        g.setGiant(castLocx(x),castLocy(y),150);
        yard[castToRow(x)][castToColumn(y)]=g;
    }
    public yardBlocks getObject(int x,int y){
        return  yard[castToRow(x)][castToColumn(y)];
    }
    public yardBlocks getObjectOfBlock(int x,int y){
        return  yard[x][y];
    }
}
