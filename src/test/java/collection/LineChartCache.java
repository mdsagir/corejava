package collection;

import java.util.Objects;

public class LineChartCache {

    private String days;
    private String tickerId;
    private String tickerType;

    public LineChartCache() {
    }

    public LineChartCache(String days, String tickerId) {
        this.days = days;
        this.tickerId = tickerId;
    }

    public LineChartCache(String days, String tickerId, String tickerType) {
        this.days = days;
        this.tickerId = tickerId;
        this.tickerType = tickerType;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTickerId() {
        return tickerId;
    }

    public void setTickerId(String tickerId) {
        this.tickerId = tickerId;
    }

    public String getTickerType() {
        return tickerType;
    }

    public void setTickerType(String tickerType) {
        this.tickerType = tickerType;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineChartCache that = (LineChartCache) o;
        return Objects.equals(days, that.days) && Objects.equals(tickerId, that.tickerId) && Objects.equals(tickerType, that.tickerType);
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineChartCache)) return false;
        LineChartCache that = (LineChartCache) o;
        return getDays().equals(that.getDays()) && getTickerId().equals(that.getTickerId()) && getTickerType().equals(that.getTickerType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, tickerId, tickerType);
    }
}
