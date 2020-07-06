class Driver extends Personal {
    private static float bonusForHarmful = 50f;
    public Driver(int id, String name, int base) {
        super(id, name, base);
    }

    @Override
    public float moneyForWorktime() {
        float bonus = 0;
        bonus = (float) worktime / 40 * bonusForHarmful;
        return super.moneyForWorktime() + bonus;
    }
}

class Cleaner extends Personal{
    private static float partlyWork_k = 0.6f;
    public Cleaner(int id, String name, int base) {
        super(id, name, base);
    }

    @Override
    public float moneyForWorktime() {
        return super.moneyForWorktime() * partlyWork_k;
    }
}
