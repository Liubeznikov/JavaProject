import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Sqare {

    public static final int TL = 0;
    public static final int TR = 1;
    public static final int BL = 2;
    public static final int BR = 3;

    private int cornersValues[][] = new int[12][4];
    private int conf[] = new int[12];

    private String readPath;
    private String writePath;

    public Sqare(String readPath,String writePath){
        this.readPath = readPath;
        this.writePath = writePath;

    }

    public void calc(){
      setSqare();
      List<Integer> lst = new LinkedList<>();
      for(int i = 0;i<conf.length; i++ ){
          lst.add(i);
      }


      findConfiguration(lst,0);
    }

    public void findConfiguration(List<Integer> remaindParts, int deep  ){
        for(Integer rp : remaindParts){
            conf[deep] =  rp;
          if(checkCondition(deep)){
              if (deep == 11){
                 printSqare();
              }
              else{
                  List<Integer> nextCall = new LinkedList<>(remaindParts);
                  nextCall.remove(rp);
                  findConfiguration(nextCall,deep + 1);
              }
          }

        }
    }


    public boolean checkCondition(int sqareSeqNum){
        switch (sqareSeqNum){
            case 0:{
                return true;
            }
            case 1:{

                return (cornersValues[conf[0]][TR] + cornersValues[conf[1]][TL]  <= 10)
                        && (cornersValues[conf[0]][BR] + cornersValues[conf[1]][BL]<= 10);
            }
            case 2:{
                return (cornersValues[conf[0]][BL] + cornersValues[conf[2]][TR]  <= 10);
            }
            case 3:{
                return (cornersValues[conf[0]][BL] + cornersValues[conf[2]][TR] + cornersValues[conf[3]][TL] <= 10)
                        && (cornersValues[conf[0]][BR] + cornersValues[conf[1]][BL] + cornersValues[conf[3]][TR] <= 10)
                        && (cornersValues[conf[2]][BR] + cornersValues[conf[3]][BL]<= 10);
            }
            case 4:{
                return  (cornersValues[conf[0]][BR] + cornersValues[conf[1]][BL] + cornersValues[conf[3]][TR] + cornersValues[conf[4]][TL] == 10)
                        && (cornersValues[conf[3]][BR] + cornersValues[conf[4]][BL]<= 10)
                        && (cornersValues[conf[1]][BR] + cornersValues[conf[4]][TR]<= 10);
            }
            case 5:{
                return (cornersValues[conf[4]][BR] + cornersValues[conf[5]][BL]<= 10)
                        && (cornersValues[conf[1]][BR] + cornersValues[conf[4]][TR] + cornersValues[conf[5]][TL] <= 10);
            }
            case 6:{
                return (cornersValues[conf[2]][BL] + cornersValues[conf[6]][TL]<= 10)
                        && (cornersValues[conf[2]][BR] + cornersValues[conf[3]][BL] + cornersValues[conf[6]][TR] <= 10);
            }
            case 7:{
                return (cornersValues[conf[3]][BR] + cornersValues[conf[4]][BL] + cornersValues[conf[7]][TR] <= 10)
                        && (cornersValues[conf[2]][BR] + cornersValues[conf[3]][BL] + cornersValues[conf[6]][TR] + cornersValues[conf[7]][TL] == 10)
                        && (cornersValues[conf[6]][BR] + cornersValues[conf[7]][BL]<= 10);
            }
            case 8:{
                return (cornersValues[conf[4]][BR] + cornersValues[conf[5]][BL] + cornersValues[conf[8]][TR] <= 10)
                        && (cornersValues[conf[3]][BR] + cornersValues[conf[4]][BL] + cornersValues[conf[7]][TR] + cornersValues[conf[8]][TL] == 10)
                        && (cornersValues[conf[7]][BR] + cornersValues[conf[8]][BL]<= 10);
            }
            case 9:{
                return ( cornersValues[conf[5]][BR] + cornersValues[conf[9]][TR] <= 10)
                        && (cornersValues[conf[4]][BR] + cornersValues[conf[5]][BL] + cornersValues[conf[8]][TR] + cornersValues[conf[9]][TL] == 10)
                        && (cornersValues[conf[8]][BR] + cornersValues[conf[9]][BL]<= 10);
            }
            case 10:{
                return (cornersValues[conf[6]][BR] + cornersValues[conf[7]][BL] + cornersValues[conf[10]][TL]<= 10)
                        && (cornersValues[conf[7]][BR] + cornersValues[conf[8]][BL] + cornersValues[conf[10]][TR] <= 10);
            }
            case 11:{
                return (cornersValues[conf[8]][BR] + cornersValues[conf[9]][BL] + cornersValues[conf[11]][TR] <= 10)
                        && (cornersValues[conf[7]][BR] + cornersValues[conf[8]][BL] + cornersValues[conf[10]][TR] + cornersValues[conf[11]][TL] == 10)
                        && (cornersValues[conf[10]][BR] + cornersValues[conf[11]][BL]<= 10);
            }

        }
        return false;
    }


    public void setSqare(){
        try{
            FileInputStream fstream = new FileInputStream(readPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int sqareNum =0;
            while ((strLine = br.readLine()) != null){
                String rd[] = strLine.split(" ");
                int i =0;
                for(String str : rd){
                    cornersValues[sqareNum][i++] = Integer.parseInt(str);
                }
                sqareNum++;
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }

    }

    public void printSqare() {
            for (int i=0; i< 12; i++){
                for(int j =0; j< 4; j++){
                    System.out.print(cornersValues[conf[i]][j] + " ");
                }
                System.out.println();
            }
        System.out.println();
    }


    public void printSqareInFile() throws IOException
    {


            PrintWriter outputFile = new PrintWriter(
                new FileWriter(writePath, true));
        try {

            for (int i=0; i< 12; i++){
                for(int j =0; j< 4; j++){
                    outputFile.print(cornersValues[conf[i]][j] + " ");
                }
                outputFile.println("");
            }
            outputFile.println("");

        }
        finally {
            outputFile.close();
        }

    }


}
