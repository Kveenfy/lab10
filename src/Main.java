import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // 1
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack2.push(6);
        stack2.push(7);
        System.out.println("Стек 1 " + stack1);
        System.out.println("Стек 2 " + stack2);
        Stack<Integer> booferStack = new Stack<>();
        booferStack.addAll(stack1);
        stack1.clear();
        stack1.addAll(stack2);
        stack2.clear();
        stack2.addAll(booferStack);
        System.out.println("Стек 1 " + stack1);
        System.out.println("Стек 2 " + stack2);
        // 2
        Map<String,Integer[]> points = new HashMap<>();
        points.put("A",new Integer[]{1,2});
        points.put("B",new Integer[]{5,11});
        points.put("C",new Integer[]{8,10});
        points.put("D",new Integer[]{2,6});
        points.put("E",new Integer[]{1,-5});
        points.put("F",new Integer[]{-1,-7});
        String[] maxPoints = new String[3];
        double maxRange = 0;

        for (String key1: points.keySet()){
            for (String key2: points.keySet()){
                double range =  Math.sqrt(Math.pow(points.get(key1)[0]-points.get(key2)[0],2) + Math.pow(points.get(key1)[1]-points.get(key2)[1],2));
                if (maxRange<range){
                    maxRange = range;
                    maxPoints[0] = key1;
                    maxPoints[1] = key2;
                }
            }
        }
        maxRange = 0;
        for (String key: points.keySet()){
            double range =  Math.sqrt(Math.pow(points.get(maxPoints[0])[0]-points.get(maxPoints[1])[0],2) + Math.pow(points.get(maxPoints[0])[1]-points.get(maxPoints[1])[1],2));
            range += Math.sqrt(Math.pow(points.get(maxPoints[0])[0]-points.get(key)[0],2) + Math.pow(points.get(maxPoints[0])[1]-points.get(key)[1],2));
            range += Math.sqrt(Math.pow(points.get(maxPoints[1])[0]-points.get(key)[0],2) + Math.pow(points.get(maxPoints[1])[1]-points.get(key)[1],2));
            if (maxRange<range){
                maxRange = range;
                maxPoints[2] = key;
            }
        }
        System.out.print("Максимальный периметр составляют эти точки: ");
        for (String key: maxPoints){
            System.out.print(key + " ");
        }

    }
}