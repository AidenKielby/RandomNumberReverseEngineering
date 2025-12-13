public class XorShift{
    public static int xorShiftInt(int seed){
        int s = seed;
        s ^= (s << 21);
        s ^= (s >>> 35);
        s ^= (s << 4);

        return s;
    }

    public static void main(String[] args){
        int seed = 1804289383;

        for (int index = 0; index < 10; index++) {
            seed = xorShiftInt(seed);

            System.out.println(seed);
        }
        
    }
}