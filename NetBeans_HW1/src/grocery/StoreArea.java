/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery;

/**
 *
 * @author black
 */
public class StoreArea {

    String areaID;
    String areaName;
    int aisleNum;
    String areaDescription;

    public StoreArea(String areaID, String areaName, int aisleNum, String areaDescription) {
        this.areaID = areaID;
        this.areaName = areaName;
        this.aisleNum = aisleNum;
        this.areaDescription = areaDescription;
    }

    public String getAreaID() {
        return this.areaID;
    }

    public void setAreaId(String areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getAisleNum() {
        return this.aisleNum;
    }

    public void setAisleNum(int aisleNum) {
        this.aisleNum = aisleNum;
    }

    public String getAreaDescription() {
        return this.areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

}
