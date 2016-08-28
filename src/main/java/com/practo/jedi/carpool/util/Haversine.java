package com.practo.jedi.carpool.util;

public class Haversine {
  public static final double R = 6372.8; // In kilometers

  public static double haversine(double lat1, double lng1, double lat2, double lng2) {
    double latDiff = Math.toRadians(lat2 - lat1);
    double lngDiff = Math.toRadians(lng2 - lng1);
    lat1 = Math.toRadians(lat1);
    lat2 = Math.toRadians(lat2);

    double a = Math.pow(Math.sin(latDiff / 2), 2)
        + Math.pow(Math.sin(lngDiff / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
    double c = 2 * Math.asin(Math.sqrt(a));
    return R * c;
  }

}
