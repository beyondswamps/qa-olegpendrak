package api.kuCoinApi;

public class TickerShort {
    private String name;
    private Float changeRate;

    public TickerShort(String name, Float changeRate) {
        this.name = name;
        this.changeRate = changeRate;
    }

    public Float getChangeRate() {
        return changeRate;
    }

    public String getName() {
        return name;
    }
}
