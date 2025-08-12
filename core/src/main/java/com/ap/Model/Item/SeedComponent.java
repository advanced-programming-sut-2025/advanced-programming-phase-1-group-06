package com.ap.Model.Item;

import com.ap.Model.Season;

import java.util.List;
// I guess it makes sense to set apart seeds from crops, seeds only imply that this item can be used on hoed dirt and
// makes a planted crop object in that specified location
// this contains tree saplings too

class SeedComponent extends Component {

    public SeedComponent(){}

    private String cropId;

    public SeedComponent(String cropId, List<Season> seasons) {
        this.cropId = cropId;
    }

    // Getters
    public String getCropId() { return cropId; }

}
