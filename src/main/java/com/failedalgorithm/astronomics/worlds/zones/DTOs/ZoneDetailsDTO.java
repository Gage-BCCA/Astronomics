package com.failedalgorithm.astronomics.worlds.zones.DTOs;

public class ZoneDetailsDTO {
    private int xCoord;
    private int yCoord;
    private String zoneType;
    private boolean isOccupied;
    private String occupiedType;
    private int plotsWithMetal;
    private int plotsWithStone;
    private int plotsWithWood;
    private int plotsWithFertileSoil;

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public String getZoneType() {
        return zoneType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getPlotsWithMetal() {
        return plotsWithMetal;
    }

    public int getPlotsWithStone() {
        return plotsWithStone;
    }

    public int getPlotsWithWood() {
        return plotsWithWood;
    }

    public int getPlotsWithFertileSoil() {
        return plotsWithFertileSoil;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setPlotsWithMetal(int plotsWithMetal) {
        this.plotsWithMetal = plotsWithMetal;
    }

    public void setPlotsWithStone(int plotsWithStone) {
        this.plotsWithStone = plotsWithStone;
    }

    public void setPlotsWithWood(int plotsWithWood) {
        this.plotsWithWood = plotsWithWood;
    }

    public void setPlotsWithFertileSoil(int plotsWithFertileSoil) {
        this.plotsWithFertileSoil = plotsWithFertileSoil;
    }

    public ZoneDetailsDTO() {}
}
