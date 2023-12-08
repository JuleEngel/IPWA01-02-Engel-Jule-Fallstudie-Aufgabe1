import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emission {
    @Id
    private String country;

    private String year2018;
    private String year2019;
    private String year2020;
    private String year2021;

    public Emission() {

    }

    public Emission(String country, String year2018, String year2019, String year2020, String year2021) {
            this.country = country;
            this.year2018 = year2018;
            this.year2019 = year2019;
            this.year2020 = year2020;
            this.year2021 = year2021;
    }


    public String getCountry() {
            return country;
    }

    public void setCountry(String country) {
            this.country = country;
    }

    public String getYear2018() {
            return year2018;
    }

    public void setYear2018(String year2018) {
            this.year2018 = year2018;
    }

    public String getYear2019() {
            return year2019;
    }

    public void setYear2019(String year2019) {
            this.year2019 = year2019;
    }

    public String getYear2020() {
            return year2020;
    }

    public void setYear2020(String year2020) {
            this.year2020 = year2020;
    }

    public String getYear2021() {
            return year2021;
    }

    public void setYear2021(String year2021) {
            this.year2021 = year2021;
    }
}