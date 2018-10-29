package OopsDesignQuestions.Train;

import java.util.HashMap;
import java.util.Map;

public class Train {
    private String trainName;
    private long id;
    Map<Station, Double> stationsWithFares = new HashMap<Station, Double>();

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<Station, Double> getStationsWithFares() {
        return stationsWithFares;
    }

    public void setStationsWithFares(Map<Station, Double> stationsWithFares) {
        this.stationsWithFares = stationsWithFares;
    }

    public Train(String trainName, long id, Map<Station, Double> stationsWithFares) {
        this.trainName = trainName;
        this.id=id;
        this.stationsWithFares = stationsWithFares;
    }
}
