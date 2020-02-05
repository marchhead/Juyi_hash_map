package me.baijuyi.hashmap;

public class NaiveHashMapTest {
    public static void main(String[] args) {
        NaiveHashMap map = new NaiveHashMap(9);
        Vampire v1 = new Vampire(3,"Juyi",'M',1000,1000,1000,1000);
        Vampire v2 = new Vampire(12,"Yindi",'F',1000,1000,1000,1000);
        Vampire v3 = new Vampire(1,"Yue",'M',1200,1000,1000,1000);
        Vampire v4 = new Vampire(9,"Jimmy",'M',900,900,1200,1000);
        Vampire badGuy = new Vampire(99,"Satan",'X',90000000,90000000,12000000,10000);
        map.put(v1);
        map.put(v2);
        map.put(v3);
        map.put(v4);
        map.put(badGuy);

        System.out.println("The total vampires are " + map.size());

        System.out.println("*******************Display the map*******************");
        System.out.println(map);

        System.out.println("*******************Get Each Vampire *******************");
        System.out.println(map.get(3));
        System.out.println(map.get(12));
        System.out.println(map.get(1));
        System.out.println(map.get(9));

        System.out.println("*******************Increase Yindi's power*******************");
        Vampire yd = map.get(12);
        yd.setPower(yd.getPower()+1000);
        System.out.println(map.get(12));

        System.out.println("*******************Update Jimmy*******************");
        Vampire newJimmy = new Vampire(9,"Hang",'M',900,900,1200,1000);
        map.put(newJimmy);
        System.out.println(map.get(9));

        System.out.println("*******************Remove Bad Guy*******************");
        map.reomove(99);
        System.out.println(map.get(99));

        System.out.println("*******************Display the final map *******************");
        System.out.println(map);
        System.out.println("The total vampires are " + map.size());
    }
}
