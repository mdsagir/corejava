package com.greenjava.preethi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test07 {
    public static void main(String[] args) throws IOException {

        List<Country> countries = new ArrayList<>();
        String path = "/Users/sagir/Desktop/filesystem/country.txt";
        Stream<String> lines = Files.lines(Paths.get(path));
        List<String> collect = lines.collect(Collectors.toList());
        for (String string : collect) {
            Country country = new Country();
            String[] str = string.split(" ");
            country.setCountry(str[0]);
            country.setPopulation(Long.parseLong(str[1]));
            country.setArea(Long.parseLong(str[2]));
            countries.add(country);
        }

        Collections.sort(countries, Comparator.comparing(Country::getArea));
        System.out.println("((( Highest Area " + countries.get(countries.size() - 1));
        Collections.sort(countries, Comparator.comparing(Country::getPopulation));
        System.out.println("((( Highest Population "+countries.get(countries.size() - 1));


    }

    static class Country {
        private String country;
        private long population;
        private long area;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }

        public long getArea() {
            return area;
        }

        public void setArea(long area) {
            this.area = area;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "country='" + country + '\'' +
                    ", population=" + population +
                    ", area=" + area +
                    '}';
        }
    }
}
