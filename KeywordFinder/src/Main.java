import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        String Mainurl = "http://www.coxeadvisors.net";
        Glavno glavno = new Glavno();


        ArrayList<String> keywords = new ArrayList<>();

        keywords.add("social impact");
        keywords.add("esg");
        keywords.add("sri");
        keywords.add("impact investing");
        keywords.add("social responsibility");
        keywords.add("sustainability");
        keywords.add("green");
        keywords.add("environment");

        keywords.add("municipal bonds");
        keywords.add("munis");
        keywords.add("municipal debt");
        keywords.add("tax-extempt");
        keywords.add("government bonds");
        keywords.add("tax-free");
        keywords.add("state government");
        keywords.add("local government");


        glavno.zadatak("p", Mainurl, Mainurl, keywords);
        glavno.zadatak("h1", Mainurl, Mainurl, keywords);
        glavno.zadatak("h2", Mainurl, Mainurl, keywords);
        glavno.zadatak("h3", Mainurl, Mainurl, keywords);
        glavno.zadatak("h4", Mainurl, Mainurl, keywords);
        glavno.zadatak("h5", Mainurl, Mainurl, keywords);
        glavno.zadatak("h6", Mainurl, Mainurl, keywords);
        ArrayList<String> urls = glavno.zadatak("a", Mainurl, Mainurl, keywords);

        for (String url : urls) {
            glavno.zadatak("p", url, Mainurl, keywords);
            glavno.zadatak("h1", url, Mainurl, keywords);
            glavno.zadatak("h2", url, Mainurl, keywords);
            glavno.zadatak("h3", url, Mainurl, keywords);
            glavno.zadatak("h4", url, Mainurl, keywords);
            glavno.zadatak("h5", url, Mainurl, keywords);
            glavno.zadatak("h6", url, Mainurl, keywords);
            glavno.zadatak("a", url, Mainurl, keywords);
        }
    }
}
