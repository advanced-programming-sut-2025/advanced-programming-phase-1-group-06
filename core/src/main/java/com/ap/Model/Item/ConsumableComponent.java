package com.ap.Model.Item;

import java.util.List;


public class ConsumableComponent extends Component {
//    public enum BuffType {
//        ENERGY,
//        FARMING,
//        FORAGING,
//        FISHING,
//        MINING
//    }


    public ConsumableComponent(){}


    public enum Buff {
        ENERGY_SHORT(3),
        ENERGY_LONG(5),
        FARMING(5),
        FORAGING_LONG(11),
        FORAGING_SHORT(5),
        FISHING_SHORT(5),
        FISHING_LONG(10),
        MINING(5);

        private int hours;

        Buff(int hours) {
            this.hours = hours;
        }

        public int getHours() {
            return hours;
        }
    }

    private int energyRestore;
    private List<String> buffs;
//    this.buffs = buffs != null ? buffs : new ArrayList<>();


    public ConsumableComponent(int energyRestore, List<String> buffs) {
        this.energyRestore = energyRestore;
    }

    public ConsumableComponent(int energyRestore) {
        this(energyRestore, null);
    }

    // Getters
    public int getEnergyRestore() { return energyRestore; }
    public List<String> getBuffs() { return buffs; }
}
