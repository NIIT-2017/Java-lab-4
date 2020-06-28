abstract class Personal extends Employee implements WorkTime{
    public int wtCalc(int time, int base) {
        return time*base;
    }
}