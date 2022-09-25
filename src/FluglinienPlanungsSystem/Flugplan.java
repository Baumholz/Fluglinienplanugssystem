package FluglinienPlanungsSystem;

import java.util.Date;

public class Flugplan {

    public String startFlughafen;
    public String zielFlughafen;
    public String verwendeteAirline;
    public String verwendetesFlugzeug;
    public Date startDatum;
    public Date landeDatum;
    public double strecke;

    public Flugplan(String startFlughafen, String zielFlughafen, String verwendeteAirline, String verwndetsFlugzeug,double strecke,Date startDatum,Date landeDatum){

        this.startFlughafen = startFlughafen;
        this.zielFlughafen = zielFlughafen;
        this.verwendeteAirline = verwendeteAirline;
        this.verwendetesFlugzeug = verwndetsFlugzeug;
        this.strecke = strecke;
        this.startDatum = startDatum;
        this.landeDatum = landeDatum;

    }

}
