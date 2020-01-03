package cfca.xfraud.api.test;

public class TestMap {
    public static void main(String[] args) {
        String str = "/location/list/room/1";
        System.out.println(str);
        if(str.startsWith("/location/list/room/")) {
            String[] split = str.split("/location/list/room/");
            System.out.println(split[1]);
        }
    }
}
