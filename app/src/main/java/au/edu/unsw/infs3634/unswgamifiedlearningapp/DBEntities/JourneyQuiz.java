package au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class JourneyQuiz {

    @PrimaryKey
    @NonNull
    private Integer quizNumber;

    private String quizQuestion;

    private String quizOption1;

    private String quizOption2;

    private String quizOption3;

    private String quizOption4;

    private String quizAnswer;

    private String quizBackgroundImage;

    public JourneyQuiz(Integer quizNumber, String quizQuestion, String quizOption1, String quizOption2, String quizOption3, String quizOption4, String quizAnswer, String quizBackgroundImage) {
        this.quizNumber = quizNumber;
        this.quizQuestion = quizQuestion;
        this.quizOption1 = quizOption1;
        this.quizOption2 = quizOption2;
        this.quizOption3 = quizOption3;
        this.quizOption4 = quizOption4;
        this.quizAnswer = quizAnswer;
        this.quizBackgroundImage = quizBackgroundImage;
    }

    public Integer getQuizNumber() {
        return quizNumber;
    }

    public void setQuizNumber(Integer quizNumber) {
        this.quizNumber = quizNumber;
    }

    public String getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(String quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    public String getQuizOption1() {
        return quizOption1;
    }

    public void setQuizOption1(String quizOption1) {
        this.quizOption1 = quizOption1;
    }

    public String getQuizOption2() {
        return quizOption2;
    }

    public void setQuizOption2(String quizOption2) {
        this.quizOption2 = quizOption2;
    }

    public String getQuizOption3() {
        return quizOption3;
    }

    public void setQuizOption3(String quizOption3) {
        this.quizOption3 = quizOption3;
    }

    public String getQuizOption4() {
        return quizOption4;
    }

    public void setQuizOption4(String quizOption4) {
        this.quizOption4 = quizOption4;
    }

    public String getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswerN(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }

    public String getQuizBackgroundImage() {
        return quizBackgroundImage;
    }

    public void setQuizBackgroundImage(String quizBackgroundImage) {
        this.quizBackgroundImage = quizBackgroundImage;
    }

    public static ArrayList<JourneyQuiz> getJourneyQuiz(String planetName) {
        ArrayList<JourneyQuiz> quizArray = new ArrayList<>();
        switch(planetName) {
            case "Mercury":

                quizArray.add(new JourneyQuiz(1,"What is Mercury closest to?","Sun","Earth","Pluto","Venus","Sun","c"));
                quizArray.add(new JourneyQuiz(2,"What was the reasoning behind naming the planet Mercury?","The Romans named it after the Messenger God Mercurius","Ancient Greeks named it after the word for Twinkling","Scientists discovered it contained the element Mercury","It was named after the Latin phrase for the god Hermes","The Romans named it after the Messenger God Mercurius","c"));
                quizArray.add(new JourneyQuiz(3,"How many earth days does Mercury take to complete an orbit?","176 Days","631 Days","88 Days","47 Days","88 Days","c"));
                quizArray.add(new JourneyQuiz(4,"How cold are nights on Mercury?","427 Degrees","(173) Degrees","(280) Degrees","45 Degrees","(173) Degrees","c"));
                quizArray.add(new JourneyQuiz(5,"Who recorded the earliest known observation of Mercury","Babylonians","Ancient Egyptians","Ancient China","Assyrians","Assyrians","c"));
                quizArray.add(new JourneyQuiz(6,"How much percent of the planet does Mercury's core occupy?","17%","55%","63%","26%","17%","c"));
                quizArray.add(new JourneyQuiz(7,"What did the Mariner 10 Mission discover about Mercury?","Mercury has rotating clouds","Mercury has a tenuous atmosphere","Mercury has a large magnesium core","Mercury does not have a magnetic core","Mercury has a tenuous atmosphere","c"));
                quizArray.add(new JourneyQuiz(8,"Does Mercury have water on its surface?","No, it is too hot to retain water","No, water used to be a part of the planets creation","Yes, ice has been discovered at Mercury's poles","Yes, Mercury's craters have pools of water","Yes, ice has been discovered at Mercury's poles","c"));
                quizArray.add(new JourneyQuiz(9,"How long is a day on Mercury","58 days 15 Hours 30 Minutes","0 Days 23 Hours 59 Minutes","23 Days 13 Hours 34 Minutes","87 Days 23 Hours 30 Minutes","58 days 15 Hours 30 Minutes","c"));
                quizArray.add(new JourneyQuiz(10,"What is the next spcaecraft to visit Mercury in 2025?","Voyager 4","Mariner 25","MESSENGER","BepiColombo","BepiColombo","c"));



                break;

            case "Venus":

                quizArray.add(new JourneyQuiz(1,"What is the average surface temperature of Venus?","464 Degrees","9000 Degrees","264 Degrees","373 Degrees","464 Degrees","c"));
                quizArray.add(new JourneyQuiz(2,"What was the first spacecraft that landed on Venus?","Venera 1","Meriner 2","Venera 7","Magellan","Venera 7","c"));
                quizArray.add(new JourneyQuiz(3,"What is the most abundant element in Venus' atmosphere?","Water","Sulfure Dioxide","Nitrogen","Carbon Dioxide","Carbon Dioxide","c"));
                quizArray.add(new JourneyQuiz(4,"How long does Venus take to complete an orbit?","365 Days","225 Days","200 Days","150 Days","225 Days","c"));
                quizArray.add(new JourneyQuiz(5,"What Roman god was Venus named after?","Roman Goddess of Love and Beauty","Roman God of War","Roman God of Thunder","Roman God of Sea","Roman Goddess of Love and Beauty","c"));
                quizArray.add(new JourneyQuiz(6,"Why is Venus often considered Earth's sister planet?","It has an atmosphere like Earth","It is the closest to the Sun","It has similar temperatures to Earth","It has a similar size to Earth","It has a similar size to Earth","c"));
                quizArray.add(new JourneyQuiz(7,"What is 80% of Venus covered with?","Impact Craters","Lava Flows","Volcanic Plains","Mountain Ridges","Volcanic Plains","c"));
                quizArray.add(new JourneyQuiz(8,"What is the largest Volcano on Venus called?","Olympus Mons","Maat Mons","Magellan Mons","Atanua Mons","Maat Mons","c"));
                quizArray.add(new JourneyQuiz(9,"How many moons does Venus have?","3","0","1","4","1","c"));
                quizArray.add(new JourneyQuiz(10,"What type of orbit does Venus have?","Rectangular","Circular","Hyperbolic","Elliptical","Elliptical","c"));


                break;

            case "Earth":

                quizArray.add(new JourneyQuiz(1,"What does Earth's atmopshere mostly consist of?","Nitrogen","Ozone","Oxygen","Krypton","Nitrogen","c"));
                quizArray.add(new JourneyQuiz(2,"When was the Earth formed?","2021 years ago","4.1 billion years ago","4.5 billion years ago","6.9 Million years ago","4.5 billion years ago","c"));
                quizArray.add(new JourneyQuiz(3,"How much of the Earth is covered in water?","90%","29.2%","10%","70.8%","70.8%","c"));
                quizArray.add(new JourneyQuiz(4,"What is Earth's largest artifical satellite?","Moon","International Space Station","Mir","Hubble Space Telescope","International Space Station","c"));
                quizArray.add(new JourneyQuiz(5,"Who was the first human to orbit Earth?","Yuri Gagarin","Han Solo","Vladimir Komarov","Alan Shepard","Yuri Gagarin","c"));
                quizArray.add(new JourneyQuiz(6,"What is Earth's largest tectonic plate?","African Plate","North American Plate","Antarctic Plate","Pacific Plate","Pacific Plate","c"));
                quizArray.add(new JourneyQuiz(7,"How was the moon created?","The Big Bang","Large asteroid was captured by Earth's orbit","Earth collided with a protoplanet called Theia","Earth's orbit captured a small planet","Earth collided with a protoplanet called Theia","c"));
                quizArray.add(new JourneyQuiz(8,"What is the highest point on Earth?","K2","Mount Everest","Olympus Mons","Mount Rushmore","Mount Everest","c"));
                quizArray.add(new JourneyQuiz(9,"What is Earth's inner core made of?","Gold","Iron","Silver","Uranium","Iron","c"));
                quizArray.add(new JourneyQuiz(10,"When did the last ice age end?","2500 years ago","45,000 years ago","200 years ago","11,700 years ago","11,700 years ago","c"));


                break;

            case "Mars":

                break;

            case "Jupiter":

                quizArray.add(new JourneyQuiz(1,"How many moons does Jupiter have?","14","35","79","8","79","c"));
                quizArray.add(new JourneyQuiz(2,"What is the Great Red Spot on Jupiter?","A volcano","A crater","A storm","An ocean","A storm","c"));
                quizArray.add(new JourneyQuiz(3,"How long does it take light from the sun to reach Jupiter?","43 minutes","79 minutes","17 minutes","159 minutes","43 minutes","c"));
                quizArray.add(new JourneyQuiz(4,"What are clouds composed of on Jupiter?","Ammonia","Sulfure Dioxide","Water","All of the above","All of the above","c"));
                quizArray.add(new JourneyQuiz(5,"Which direction does the Great Red Spot rotate?","It frequently changes direction","It doesn't rotate","Clockwise","Counter-clockwise","Counter-clockwise","c"));
                quizArray.add(new JourneyQuiz(6,"Which of Jupiter's moons is believed to have a massive subsurface ocean?","Ganymede","Europa","Io","Callisto","Europa","c"));
                quizArray.add(new JourneyQuiz(7,"What are Jupiter's rings made of?","Liquid Hydrogen","Ice","Dust","Gas","Dust","c"));
                quizArray.add(new JourneyQuiz(8,"Jupiter is the ____ planet in the Solar System?","Brightest","Fastest spinning","Darkest","Slowest spinning","Fastest spinning","c"));
                quizArray.add(new JourneyQuiz(9,"Which of Jupiter's moons has about 400 active volcanos?","Ganymede","Io","Europa","Callisto","Io","c"));
                quizArray.add(new JourneyQuiz(10,"How often does Jupiter change seasons?","Every 30 years","Every 30 hours","Jupiter doesn't have seasons","Every week","Jupiter doesn't have seasons","c"));



                break;

            case "Saturn":

                quizArray.add(new JourneyQuiz(1,"Saturn is named after the Roman god of....?","Night","War","Agriculture","Wisdom","Agriculture","c"));
                quizArray.add(new JourneyQuiz(2,"How fast are the winds on Saturn?","1100 MPH","1500 MPH","700 MPH","300 MPH","1100 MPH","c"));
                quizArray.add(new JourneyQuiz(3,"Saturn is the only planet in our Solar System...","That has rings","That has an elliptical orbit","That rotates clockwise","That would float in water","That would float in water","c"));
                quizArray.add(new JourneyQuiz(4,"What is Satun's biggest moon?","Goliath","Phoebe","Titan","Enceladus","Titan","c"));
                quizArray.add(new JourneyQuiz(5,"Saturn is the ____ planet?","Biggest","Oldest","Flattest","Coldest","Flattest","c"));
                quizArray.add(new JourneyQuiz(6,"How long is a day on Saturn?","About 45 Earth days","About 10 hours","About 45 hours","About 10 Earth days","About 10 hours","c"));
                quizArray.add(new JourneyQuiz(7,"Who was the first to observe Saturn's rings?","Christiaan Huygens","Galileo Galilei","Tycho Brahe","Copernicus","Galileo Galilei","c"));
                quizArray.add(new JourneyQuiz(8,"What is the most prominent element in Saturn's atmosphere?","Hydrogen","Ammonia","Helium","Methane","Hydrogen","c"));
                quizArray.add(new JourneyQuiz(9,"What did the Cassini probe in 2006 discover?","A previously undiscovered planetary ring","Geysers on one of Saturn's moons","Seas on one of Saturn's moons","All of the above","All of the above","c"));
                quizArray.add(new JourneyQuiz(10,"What does it rain on Saturn?","Acid","Diamonds","Glass","Iron","Diamonds","c"));

                break;

            case "Uranus":

                quizArray.add(new JourneyQuiz(1,"Who discovered Uranus?","Gerard Kuiper","Pervical Lowell","William Herschel","James Watt","William Herschel","c"));
                quizArray.add(new JourneyQuiz(2,"After whom are the moons of Uranus named after?","Kings of England","Presidents of USA","Characters from writings of William Shakespeare","Characters from writings of George Bernard Shaw","Characters from writings of William Shakespeare","c"));
                quizArray.add(new JourneyQuiz(3,"Uranus has more than 25 known moons, which of these is the largest moon?","Cressida","Umbriel","Oberon","Titania","Titania","c"));
                quizArray.add(new JourneyQuiz(4,"Uranus appears blue because....?","The ice composition reflecting against the Sun","Methane in its atmosphere reflecting against the Sun's light","The rock surface is stained blue","The shadow of its moons cause it to appear blue","Methane in its atmosphere reflecting against the Sun's light","c"));
                quizArray.add(new JourneyQuiz(5,"Which of these gases is the atmopshere NOT predominantly composed of?","Methane","Helium","Hydrogen","Argon","Argon","c"));
                quizArray.add(new JourneyQuiz(6,"How long is a year on Uranus?","30.6 Earth Years","8.4 Earth Years","84.3 Earth Years","306.1 Earth Years","84.3 Earth Years","c"));
                quizArray.add(new JourneyQuiz(7,"Uranus was the first planet to be....?","Formed in the Solar System","Discovered with a telescope","Discovered using mathematics","Observed by ancient astronomers","Discovered with a telescope","c"));
                quizArray.add(new JourneyQuiz(8,"What is unique about Uranus?","It's still shrinking","It would float in water","It spins on its side","It has a two-tone moon","It spins on its side","c"));
                quizArray.add(new JourneyQuiz(9,"How many rings does Uranus have?","0 Rings","13 Rings","11 Rings","7 Rings","13 Rings","c"));
                quizArray.add(new JourneyQuiz(10,"What did Voyager 2 discover when it visited Uranus?","11 New Moons","Active Volcanoes","Great Dark Spot","Giant Geysers","11 New Moons","c"));



                break;

            case "Neptune":

                quizArray.add(new JourneyQuiz(1,"When was Neptune discovered?","1844","1942","1848","1846","1846","c"));
                quizArray.add(new JourneyQuiz(2,"What was the first probe to explore Neptune?","Pioneer 10","Ulysses","Voyager 2","Galileo","Voyager 2","c"));
                quizArray.add(new JourneyQuiz(3,"Compared to Earth's gravity, what is the gravitational pull of Neptune?","4.22 times lesser than Earth","1.17 times greater than Earth","3.41 times greater than Earth","5.39 times lesser than Earth","1.17 times greater than Earth","c"));
                quizArray.add(new JourneyQuiz(4,"Neptune’s interior, like that of Uranus, is primarily composed of what?","Ice and Rock","Only Rock","Ice and Metal","Rock and Metal","Ice and Rock","c"));
                quizArray.add(new JourneyQuiz(5,"Which of Neptune's moons is the largest?","Proteus","Nereid","Triton","Despina","Triton","c"));
                quizArray.add(new JourneyQuiz(6,"How many Earth years does it take for Neptune to make a single revolution around the Sun?","12 Years","264 Years","84 Years"," 165 Years","165 Years","c"));
                quizArray.add(new JourneyQuiz(7,"Who discovered Neptune?","William Herschel","John Couch Adams","John Flamsteed","Issac Newton","John Couch Adams","c"));
                quizArray.add(new JourneyQuiz(8,"What is the main component of Neptune's atmosphere?","Hydrogen","Methane","Helium","Ethane","Hydrogen","c"));
                quizArray.add(new JourneyQuiz(9,"What is the length of a day on Neptune?","29 Hours","16 Hours","24 Hours","3 Hours","16 Hours","c"));
                quizArray.add(new JourneyQuiz(10,"What is the outermost ring of Neptune?","Adams","Galatea","Leverrier","Galle","Adams","c"));




                break;

        }
        return quizArray;
    }
}
