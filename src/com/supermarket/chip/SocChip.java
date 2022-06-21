package com.supermarket.chip;

import java.util.Arrays;

public class SocChip extends Chip {
    private boolean[] isCpuWorked;
    private boolean[] isMemoryWorked;

    public SocChip(String name, String id, int count, double soldPrice, double purchasePrice) {
        super(name, id, count, soldPrice, purchasePrice);
    }

    public SocChip() {
        super();
    }

    @Override
    public void runChipTest() {
        super.isTested = true;
        System.out.println("测试中...");
        super.isWorked = new boolean[super.count];
        isMemoryWorked = new boolean[super.count];
        isCpuWorked = new boolean[super.count];
        int workedCount = 0;
        int workedCpuCount = 0, workedMemoryCount = 0;
        for (int i = 0; i < isWorked.length; i++) {

            isCpuWorked[i] = Math.random() < 0.7;
            isMemoryWorked[i] = Math.random() < 0.7;
            super.isWorked[i] = isCpuWorked[i] && isMemoryWorked[i];

            if (isWorked[i]) {
                workedCount++;
            } else {
                workedCpuCount += isCpuWorked[i] ? 1 : 0;
                workedMemoryCount += isMemoryWorked[i] ? 1 : 0;
            }
        }
        super.yield = (double) workedCount / super.count;
        System.out.format("测试完成，此soc良率%.2f%%,最易损部分是%s\n",
                yield * 100, workedCpuCount > workedMemoryCount ? "CPU" : "Memory");
    }

}
