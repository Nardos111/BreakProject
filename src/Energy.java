public class Energy extends GraphPoint{
    long energyPointID;
    int energyLevel;

    Energy(int x, int y) {
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
