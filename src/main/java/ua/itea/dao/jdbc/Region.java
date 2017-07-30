package ua.itea.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dada.mazza on 10.07.2017.
 */
public class Region {
    private List<String> regions = new ArrayList<>();

    public Region() {
        regions.add("");
        regions.add("Kyiv");
        regions.add("Lviv");
        regions.add("Donetsk");
        regions.add("Odessa");
    }

    public Region(List<String> regions) {
        this.regions = regions;
    }

    public List<String> getRegions() {
        return regions;
    }
}
