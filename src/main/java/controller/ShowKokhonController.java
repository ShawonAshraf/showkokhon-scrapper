package controller;

import model.Location;
import model.RawData;
import parser.CineplexDataParser;
import parser.Parser;
import scraper.CineplexScraper;
import scraper.Scraper;
import utility.JSONHelper;

import java.util.ArrayList;

public class ShowKokhonController {
    private Scraper cineplexScraper;
    private Parser cineplexParser;

    public ShowKokhonController() {
        cineplexScraper = new CineplexScraper();
        cineplexParser = new CineplexDataParser();
    }


    public ArrayList<RawData> scrapCineplexData() {
        // scrap
        var scrappedData = cineplexScraper.scrap();
        return scrappedData;
    }

    public ArrayList<Location> parseScrappedData(ArrayList<RawData> scrapedData) {
        // parse
        var parsedData = cineplexParser.parse(scrapedData);
        return parsedData;
    }

    public String getDataAsJSON() {
        // convert to json
        var scrapedData = scrapCineplexData();
        var parsedData = parseScrappedData(scrapedData);
        var jsonString = JSONHelper.parseObjectToJSONString(parsedData);

        return jsonString;
    }
}
