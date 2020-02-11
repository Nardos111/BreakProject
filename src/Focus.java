public class Focus extends GraphPoint{
    long energyPointID;
    int energyLevel;

    Focus(int x, int y) {
        super(x, y);
        this.energyLevel = y;
    }

    public long getEnergyPointID() {
        return energyPointID;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
}
