package intervive.jvm.RunTimeDataAreas;

public class HeapOomMock {

    private static final int _1MB = 1024 * 1024;


    /** 对象优先在Eden分配
     * VM参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *
     *
     */
    public static void testAllocation() {
        byte[] allocation1;
        allocation1 = new byte[4 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
//        allocation4 = new byte[1 * _1MB]; // 出现一次Minor GC
    }

    public static void main(String[] args) {
        Integer s = 110;
        Integer seed = 9;
        Integer encStr = s ^ seed ^seed;
        System.out.println(encStr);
        System.out.println(encStr ^ seed);
    }
}
