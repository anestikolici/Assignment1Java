import java.util.Locale;

public class CovidData {

    private String isc_code, continent, location, date;
    private double tc, nc, ncs, td,nd,nds,rr,nt,tt, si, population, ma, ndpc;


    public CovidData(String isc_code, String continent, String location, String date, String tc, String nc, String ncs, String td, String nd, String nds, String rr, String nt, String tt, String si, String population, String ma) {

        this.isc_code = isc_code;
        this.continent = continent;
        this.location = location;
        this.date = date;
        this.tc = parseString(tc);
        this.nc = parseString(nc);
        this.ncs = parseString(ncs);
        this.td = parseString(td);
        this.nd = parseString(nd);
        this.nds = parseString(nds);
        this.rr = parseString(rr);
        this.nt = parseString(nt);
        this.tt = parseString(tt);
        this.si = parseString(si);
        this.population = parseString(population);
        this.ma = parseString(ma);
        this.ndpc= this.nd/this.nc;
    }

    private double parseString(String x){

        if(x.equals("")) return 0;
        else return Double.parseDouble(x);

    }

    public double getBy(String by){
        by=by.toLowerCase(Locale.ROOT);

        switch (by){
            case "nc":
                return nc;
            case "ncs":
                return ncs;
            case "nd":
                return nd;
            case "nds":
                return nds;
            case "nt":
                return nt;
            case "ndpc":
                return ndpc;
            default:
                System.out.println("Invalid STAT, result data is WRONG");
                return 0;

        }
    }

    public String getDisplay(String display){

        display=display.toLowerCase(Locale.ROOT);

        return switch (display) {
            case "country" -> location;
            case "continent" -> continent;
            case "date" -> date;
            default -> "Invalid DISPLAY argument";
        };
    }



    public String getIsc_code() {
        return isc_code;
    }

    public void setIsc_code(String isc_code) {
        this.isc_code = isc_code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTc() {
        return tc;
    }

    public void setTc(double tc) {
        this.tc = tc;
    }

    public double getNc() {
        return nc;
    }

    public void setNc(double nc) {
        this.nc = nc;
    }

    public double getNcs() {
        return ncs;
    }

    public void setNcs(double ncs) {
        this.ncs = ncs;
    }

    public double getTd() {
        return td;
    }

    public void setTd(double td) {
        this.td = td;
    }

    public double getNd() {
        return nd;
    }

    public void setNd(double nd) {
        this.nd = nd;
    }

    public double getNds() {
        return nds;
    }

    public void setNds(double nds) {
        this.nds = nds;
    }

    public double getRr() {
        return rr;
    }

    public void setRr(double rr) {
        this.rr = rr;
    }

    public double getNt() {
        return nt;
    }

    public void setNt(double nt) {
        this.nt = nt;
    }

    public double getTt() {
        return tt;
    }

    public void setTt(double tt) {
        this.tt = tt;
    }

    public double getSi() {
        return si;
    }

    public void setSi(double si) {
        this.si = si;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getMa() {
        return ma;
    }

    public void setMa(double ma) {
        this.ma = ma;
    }

    public double getNdpc() {
        return ndpc;
    }

    public void setNdpc(double ndpc) {
        this.ndpc = ndpc;
    }

    public String toString() {
        return "CovidData{" +
                "isc_code='" + isc_code + '\'' +
                ", continent='" + continent + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", tc='" + tc + '\'' +
                ", nc='" + nc + '\'' +
                ", ncs='" + ncs + '\'' +
                ", td='" + td + '\'' +
                ", nd='" + nd + '\'' +
                ", nds='" + nds + '\'' +
                ", rr='" + rr + '\'' +
                ", nt='" + nt + '\'' +
                ", tt='" + tt + '\'' +
                ", si='" + si + '\'' +
                ", population='" + population + '\'' +
                ", ma='" + ma + '\'' +
                ", ndpc='" + ndpc + '\'' +
                '}';
    }



}
