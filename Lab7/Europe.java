import java.util.ArrayList;

public class Europe {

    public static class Country {
        private String country;
        Country() {}
        Country(String country) { this.country = country; }
        public String getCountry() { return this.country; }
        public void setCountry(String country) { this.country = country; }
        @Override
        public String toString() { return "Country - " + country; }
    }

    public class HistoryChange{
        Country country;
        int year;
        String description;

        public HistoryChange(){
            country = new Country();
            year = 0;
            description = "";
        }

        public HistoryChange(String country, int year, String description){
            this.country = new Country(country);
            this.year = year;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Year - " + year + ", " + this.country.toString() + ".\n" +
                    "Description: " + description + ".";
        }
    }

    private ArrayList<HistoryChange> history;

    public String getFirstHistory(){
        if (history.size() > 0)
            return "(Not anonymous)" + history.get(0).toString();
        return "(Not anonymous)";
    }

    Europe(){
        history = new ArrayList<HistoryChange>();
    }
    public ArrayList<HistoryChange> getHistory() { return this.history; }
    public void add(String country, int year, String description){
        history.add(new HistoryChange(country, year, description));
    }

    public ArrayList<String> getAllHistory(){
        ArrayList<String> allHistory = new ArrayList<>();
        for(int i = 0; i < this.history.size(); i++)
            allHistory.add(history.get(i).toString());
        return allHistory;
    }
    public ArrayList<String> getHistoryByYear(int year){
        ArrayList<String> historyByYear = new ArrayList<String>();
        for(int i = 0; i < history.size(); i++) {
            if(history.get(i).year == year)
                historyByYear.add(history.get(i).toString());
        }
        return historyByYear;
    }
    public ArrayList<Integer> getAllYears(){
        ArrayList<Integer> years = new ArrayList<Integer>();
        for(int i = 0; i < history.size(); i++) {
            years.add(history.get(i).year);
        }
        return years;
    }
    public ArrayList<String> getAllCountries(){
        ArrayList<String> countries = new ArrayList<String>();
        for(int i = 0; i< history.size(); i++) {
            countries.add(history.get(i).country.country);
        }
        return countries;
    }
}