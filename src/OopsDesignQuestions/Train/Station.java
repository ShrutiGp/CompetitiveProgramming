package OopsDesignQuestions.Train;

public class Station {
    private int id;
    private String name;

    public Station(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Station station = (Station) obj;
        if(id == station.id && name == station.name)
        return true;

        return false;
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }
}
