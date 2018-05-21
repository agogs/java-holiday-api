package com.github.agogs.holidayapi.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.github.agogs.holidayapi.model.QueryParams.APIParameters.*;

public class QueryParams {

    private Map<String, Object> params;

    public QueryParams() {
        params = new HashMap<>();
    }

    public QueryParams key(String key) {
        params.put(API_KEY.toString(), key);
        return this;
    }

    public QueryParams country(Country country) {
        params.put(COUNTRY.toString(), country.code());
        return this;
    }

    public QueryParams year(int year) {
        params.put(YEAR.toString(), year);
        return this;
    }

    public QueryParams month(int month) {
        params.put(MONTH.toString(), month);
        return this;
    }

    public QueryParams day(int day) {
        params.put(DAY.toString(), day);
        return this;
    }

    public QueryParams previous(boolean previous) {
        params.put(PREVIOUS.toString(), previous);
        return this;
    }

    public QueryParams upcoming(boolean upcoming) {
        params.put(UPCOMING.toString(), upcoming);
        return this;
    }

    public QueryParams isPublic(boolean _public) {
        params.put(PUBLIC.toString(), _public);
        return this;
    }

    public QueryParams format(Format format) {
        params.put(FORMAT.toString(), format.value);
        return this;
    }

    public QueryParams pretty(boolean pretty) {
        params.put(PRETTY.toString(), pretty);
        return this;
    }

    public String queryString() {

        if (params.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = it.next();
            builder.append(e.getKey()).append("=").append(e.getValue());
            if (it.hasNext()) {
                builder.append("&");
            }
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return queryString();
    }

    public enum APIParameters {
        API_KEY("key"),
        COUNTRY("country"),
        YEAR("year"),
        MONTH("month"),
        DAY("day"),
        PREVIOUS("previous"),
        UPCOMING("upcoming"),
        PUBLIC("public"),
        FORMAT("format"),
        PRETTY("pretty");

        private String param;

        APIParameters(String param) {
            this.param = param;
        }

        @Override
        public String toString() {
            return param;
        }
    }

    public enum Country {
        ARGENTINA("AR"),
        ANGOLA("AO"),
        AUSTRIA("AT"),
        AUSTRALIA("AU"),
        ARUBA("AW"),
        Åland_Islands("AX"),
        Bosnia_and_Herzegovina("BA"),
        BELGIUM("BE"),
        BULGARIA("BG"),
        BOLIVIA("BO"),
        BRAZIL("BR"),
        The_Bhamas("BS"),
        CANADA("CA"),
        SWITZERLAND("CH"),
        CHINA("CN"),
        COLOMBIA("CO"),
        Costa_Rica("CR"),
        CUBA("CU"),
        Czech_Republic("CZ"),
        GERMANY("DE"),
        DENMARK("DK"),
        Dominican_Republic("DO"),
        ECUADOR("EC"),
        SPAIN("ES"),
        FINLAND("FI"),
        FRANCE("FR"),
        United_Kingdom("GB"),
        ENGLAND("GB-ENG"),
        Northern_Ireland("GB-NIR"),
        SCOTLAND("GB-SCT"),
        WALES("GB-WLS"),
        GREECE("GR"),
        GUATEMALA("GT"),
        Hong_Kong("HK"),
        HONDURAS("HN"),
        CROATIA("HR"),
        HUNGARY("HU"),
        INDONESIA("ID"),
        IRELAND("IE"),
        INDIA("IN"),
        ISRAEL("IL"),
        ICELAND("IS"),
        ITALY("IT"),
        JAPAN("JP"),
        KAZAKHSTAN("KZ"),
        LESOTHO("LS"),
        LUXEMBOURG("LU"),
        MADAGASCAR("MG"),
        MARTINIQUE("MQ"),
        MALTA("MT"),
        MAURITIUS("MU"),
        MEXICO("MX"),
        MOZAMBIQUE("MZ"),
        NIGERIA("NG"),
        NETHERLANDS("NL"),
        NORWAY("NO"),
        PERU("PE"),
        PAKISTAN("PK"),
        PHILIPPINES("PH"),
        POLAND("PL"),
        Puerto_Rico("PR"),
        PORTUGAL("PT"),
        PARAGUAY("PY"),
        RéUNION("RE"),
        ROMANIA("RO"),
        RUSSIA("RU"),
        SEYCHELLES("SC"),
        SWEDEN("SE"),
        SINGAPORE("SG"),
        SLOVENIA("SI"),
        Sao_Tome_and_Principe("ST"),
        SLOVAKIA("SK"),
        TUNISIA("TN"),
        TURKEY("TR"),
        UKRAINE("UA"),
        United_States("US"),
        URUGUAY("UY"),
        VENEZUELA("VE"),
        South_Africa("ZA"),
        ZIMBABWE("ZW");

        private String country;

        Country(String country) {
            this.country = country;
        }

        public String code() {
            return this.country;
        }
    }

    public enum Format {
        STRING("string"),
        CSV("csv"),
        JSON("json"),
        PHP("php"),
        TSV("tsv"),
        YAML("yaml"),
        XML("xml");

        private String value;

        Format(String value) {
            this.value = value;
        }

        public String format() {
            return this.value;
        }

    }
}
