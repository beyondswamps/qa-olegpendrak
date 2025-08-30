package api.kuCoinApi;

public class TickerData {

    private String symbol;
    private String symbolName;
    private String buy;
    private String sell;
    private String bestBidSize;
    private String bestAskSize;
    private String changeRate;
    private String changePrice;
    private String high;
    private String low;
    private String vol;
    private String volValue;
    private String last;
    private String averagePrice;
    private String takerFeeRate;
    private String makerFeeRate;
    private String takerCoefficient;
    private String makerCoefficient;
    private String lastSize;

    public TickerData() {
    }

    public TickerData(String symbol, String symbolName, String buy, String sell, String bestBidSize, String bestAskSize, String changeRate, String changePrice, String high, String low, String vol, String volValue, String last, String averagePrice, String takerFeeRate, String makerFeeRate, String takerCoefficient, String makerCoefficient, String lastSize, String open) {
        this.symbol = symbol;
        this.symbolName = symbolName;
        this.buy = buy;
        this.sell = sell;
        this.bestBidSize = bestBidSize;
        this.bestAskSize = bestAskSize;
        this.changeRate = changeRate;
        this.changePrice = changePrice;
        this.high = high;
        this.low = low;
        this.vol = vol;
        this.volValue = volValue;
        this.last = last;
        this.averagePrice = averagePrice;
        this.takerFeeRate = takerFeeRate;
        this.makerFeeRate = makerFeeRate;
        this.takerCoefficient = takerCoefficient;
        this.makerCoefficient = makerCoefficient;
        this.lastSize = lastSize;
        this.open = open;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    private String open;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getBestBidSize() {
        return bestBidSize;
    }

    public void setBestBidSize(String bestBidSize) {
        this.bestBidSize = bestBidSize;
    }

    public String getBestAskSize() {
        return bestAskSize;
    }

    public void setBestAskSize(String bestAskSize) {
        this.bestAskSize = bestAskSize;
    }

    public String getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(String changeRate) {
        this.changeRate = changeRate;
    }

    public String getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(String changePrice) {
        this.changePrice = changePrice;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getVolValue() {
        return volValue;
    }

    public void setVolValue(String volValue) {
        this.volValue = volValue;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getTakerFeeRate() {
        return takerFeeRate;
    }

    public void setTakerFeeRate(String takerFeeRate) {
        this.takerFeeRate = takerFeeRate;
    }

    public String getMakerFeeRate() {
        return makerFeeRate;
    }

    public void setMakerFeeRate(String makerFeeRate) {
        this.makerFeeRate = makerFeeRate;
    }

    public String getTakerCoefficient() {
        return takerCoefficient;
    }

    public void setTakerCoefficient(String takerCoefficient) {
        this.takerCoefficient = takerCoefficient;
    }

    public String getMakerCoefficient() {
        return makerCoefficient;
    }

    public void setMakerCoefficient(String makerCoefficient) {
        this.makerCoefficient = makerCoefficient;
    }

    public String getLastSize() {
        return lastSize;
    }

    public void setLastSize(String lastSize) {
        this.lastSize = lastSize;
    }
}
