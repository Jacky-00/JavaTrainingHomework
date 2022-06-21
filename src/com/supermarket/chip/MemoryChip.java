package com.supermarket.chip;

public class MemoryChip extends Chip {

    public MemoryChip(String name, String id, int count, double soldPrice, double purchasePrice) {
        super(name, id, count, soldPrice, purchasePrice);
    }

    public MemoryChip() {
        super();
    }

    @Override
    public void runChipTest() {
        super.isTested = true;
        System.out.println("测试中...");
        super.isWorked = new boolean[super.count];
        int workedCount = 0;
        for (int i = 0; i < isWorked.length; i++) {
            isWorked[i] = Math.random() < 0.6;
            if (isWorked[i]) {
                workedCount++;
            }
        }
        super.yield = (double) workedCount / super.count;
        System.out.format("测试完成，此Memory良率%.2f%%\n", yield * 100);
    }
}
