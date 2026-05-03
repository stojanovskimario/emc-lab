package mk.ukim.finki.wp.emtlab.model.projection;

public interface CountryHostStatisticsProjection {
    Long getCountryId();

    String getCountryName();

    Long getHostCounter();
}
