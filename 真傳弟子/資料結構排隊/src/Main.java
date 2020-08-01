import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("請輸入商店名稱");
        Input();
        outcome();
    }

    public static void Input(){

        boolean boo = true;
        String [] store = sc.nextLine().split(" ");

        for (String s : store) {
            map.put(s, new ArrayList<>());
        }
        while(boo) {
            String[] judgement = sc.nextLine().split(" ");
            if (judgement.length != 1) {
                if (judgement[2].equals("R")) {
                    map.get(judgement[0]).remove(judgement[1]);
                } else if (judgement[2].equals("A")) {
                    map.get(judgement[0]).add(judgement[1]);
                }
            }else boo= false;
        }
        for (String s : store) {
            if (map.get(s).isEmpty()) map.get(s).add("沒有人在排隊");
        }
    }

    public static void outcome(){
        for(Object key :map.keySet()){
            System.out.println("商店名稱:"+key);
            System.out.println(" 隊伍:"+map.get(key));
        }
    }
}
