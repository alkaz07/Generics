public class AComp extends A implements Comparable<AComp>{
    public AComp(int value) {
        super(value);
    }

    @Override
    public int compareTo(AComp other) {
        return this.value-other.value;
    }
}
