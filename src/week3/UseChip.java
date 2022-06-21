package week3;

import com.supermarket.chip.*;

public class UseChip {
    public static void main(String[] args) {
        MemoryChip memoryChip =new MemoryChip("memory芯片", "memory001", 200, 200,150);
        SocChip socChip=new SocChip("soc芯片","soc001",50,500,300);

        memoryChip.describe();

        memoryChip.runChipTest();
        memoryChip.describe();

        socChip.runChipTest();
        socChip.describe();

    }
}
