package np4j;

import java.lang.Math;
import java.util.ArrayList;

public class Array {
    private ArrayList<ArrayList<Double>> array;
    private int[] shape;
    public Array(ArrayList<ArrayList<Double>> array){
        this.array = array;
        shape = new int[2];
        shape[0] = array.size();
        shape[1] = array.get(0).size();
    }
    public static Array sum(Array a, Array b){
        if(a.shape[0] != b.shape[0] || a.shape[1] != b.shape[1]){
            throw new Error("Shapes don't match");
        }
        ArrayList<ArrayList<Double>> out = new ArrayList<ArrayList<Double>>();

        for (int i = 0; i < a.shape[0]; i++) {
            ArrayList<Double> temp = new ArrayList<Double>();
            for (int j = 0; j < a.shape[1]; j++) {
                temp.add(a.array.get(i).get(j)+b.array.get(i).get(j));
            }
            out.add(temp);
        }
        
        return new Array(out);
        
    }
    public static Array exp(Array inpt){
        ArrayList<ArrayList<Double>> out = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < inpt.shape[0]; i++) {
            ArrayList<Double> temp = new ArrayList<Double>();
            for (int j = 0; j < inpt.shape[1]; j++) {
                temp.add(Math.exp(inpt.array.get(i).get(j)));
            }
            out.add(temp);
        }
        return new Array(out);
    }

    public static Array rep(int rows, int cols, double in){
        ArrayList<ArrayList<Double>> out = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Double> temp = new ArrayList<Double>();
            for (int j = 0; j < cols; j++) {
                temp.add(in);
            }
            out.add(temp);
        }
        return new Array(out);
    }
    public static Array rand(int rows, int cols){
        ArrayList<ArrayList<Double>> out = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Double> temp = new ArrayList<Double>();
            for (int j = 0; j < cols; j++) {
                temp.add(Math.random());
            }
            out.add(temp);
        }
        return new Array(out);
    }
    public String toString() {
        String out = "";
        out+="[\n";
        for (ArrayList<Double> row : this.array) {
            out+="[";
            for (double d : row) {
                out+=d;
                out+=",";
            }
            out+="],\n";
        }
        out+="]";
        return out;
    }
}
