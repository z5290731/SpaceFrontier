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

    private Integer quizAnswerNumber;

    private String quizBackgroundImage;

    public JourneyQuiz(Integer quizNumber, String quizQuestion, String quizOption1, String quizOption2, String quizOption3, String quizOption4, Integer quizAnswerNumber, String quizBackgroundImage) {
        this.quizNumber = quizNumber;
        this.quizQuestion = quizQuestion;
        this.quizOption1 = quizOption1;
        this.quizOption2 = quizOption2;
        this.quizOption3 = quizOption3;
        this.quizOption4 = quizOption4;
        this.quizAnswerNumber = quizAnswerNumber;
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

    public Integer getQuizAnswerNumber() {
        return quizAnswerNumber;
    }

    public void setQuizAnswerNumber(Integer quizAnswerNumber) {
        this.quizAnswerNumber = quizAnswerNumber;
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
                quizArray.add(new JourneyQuiz(1,"What is Mercury closest to?","Sun","Earth","Pluto","Venus",1,"c"));
                quizArray.add(new JourneyQuiz(2,"What was the reasoning behind naming the planet Mercury?","The Romans named it after the Messenger God Mercurius","Ancient Greeks named it after the word for Twinkling","Scientists discovered it contained the element Mercury","It was named after the Latin phrase for the god Hermes",1,"c"));
                quizArray.add(new JourneyQuiz(3,"How many earth days does Mercury take to complete an orbit?","176 Days","631 Days","88 Days","47 Days",3,"c"));
                quizArray.add(new JourneyQuiz(4,"How cold are nights on Mercury?","427 Degrees","(173) Degrees","(280) Degrees","45 Degrees",2,"c"));
                quizArray.add(new JourneyQuiz(5,"Who recorded the earliest known observation of Mercury","Babylonians","Ancient Egyptians","Ancient China","Assyrians",4,"c"));
                quizArray.add(new JourneyQuiz(6,"How much percent of the planet does Mercury's core occupy?","17%","55%","63%","26%",1,"c"));
                quizArray.add(new JourneyQuiz(7,"What did the Mariner 10 Mission discover about Mercury?","Mercury has rotating clouds","Mercury has a tenuous atmosphere","Mercury has a large magnesium core","Mercury does not have a magnetic core",2,"c"));
                quizArray.add(new JourneyQuiz(8,"Does Mercury have water on its surface?","No, it is too hot to retain water","No, water used to be a part of the planets creation","Yes, ice has been discovered at Mercury's poles","Yes, Mercury's craters have pools of water",3,"c"));
                quizArray.add(new JourneyQuiz(9,"How long is a day on Mercury","58 days 15 Hours 30 Minutes","0 Days 23 Hours 59 Minutes","23 Days 13 Hours 34 Minutes","87 Days 23 Hours 30 Minutes",1,"c"));
                quizArray.add(new JourneyQuiz(10,"What is the next spcaecraft to visit Mercury in 2025?","Voyager 4","Mariner 25","MESSENGER","BepiColombo",4,"c"));

                break;

            case "Venus":

                quizArray.add(new JourneyQuiz(1,"What is the average surface temperature of Venus?","464 Degrees","9000 Degrees","264 Degrees","373 Degrees",1,"c"));
                quizArray.add(new JourneyQuiz(2,"What was the first spacecraft that landed on Venus?","Venera 1","Meriner 2","Venera 7","Magellan",3,"c"));
                quizArray.add(new JourneyQuiz(3,"What is the most abundant element in Venus' atmosphere?","Water","Sulfure Dioxide","Nitrogen","Carbon Dioxide",4,"c"));
                quizArray.add(new JourneyQuiz(4,"How long does Venus take to complete an orbit?","365 Days","225 Days","200 Days","150 Days",2,"c"));
                quizArray.add(new JourneyQuiz(5,"What Roman god was Venus named after?","Roman Goddess of Love and Beauty","Roman God of War","Roman God of Thunder","Roman God of Sea",1,"c"));
                quizArray.add(new JourneyQuiz(6,"Why is Venus often considered Earth's sister planet?","It has an atmosphere like Earth","It is the closest to the Sun","It has similar temperatures to Earth","It has a similar size to Earth",4,"c"));
                quizArray.add(new JourneyQuiz(7,"What is 80% of Venus covered with?","Impact Craters","Lava Flows","Volcanic Plains","Mountain Ridges",3,"c"));
                quizArray.add(new JourneyQuiz(8,"What is the largest Volcano on Venus called?","Olympus Mons","Maat Mons","Magellan Mons","Atanua Mons",2,"c"));
                quizArray.add(new JourneyQuiz(9,"How many moons does Venus have?","3","0","1","4",2,"c"));
                quizArray.add(new JourneyQuiz(10,"What type of orbit does Venus have?","Rectangular","Circular","Hyperbolic","Elliptical",4,"c"));


                break;

            case "Earth":


                quizArray.add(new JourneyQuiz(1,"What does Earth's atmopshere mostly consist of?","Nitrogen","Ozone","Oxygen","Krypton",1,"c"));
                quizArray.add(new JourneyQuiz(2,"When was the Earth formed?","2021 years ago","4.1 billion years ago","4.5 billion years ago","6.9 Million years ago",3,"c"));
                quizArray.add(new JourneyQuiz(3,"How much of the Earth is covered in water?","90%","29.2%","10%","70.8%",4,"c"));
                quizArray.add(new JourneyQuiz(4,"What is Earth's largest artifical satellite?","Moon","International Space Station","Mir","Hubble Space Telescope",2,"c"));
                quizArray.add(new JourneyQuiz(5,"Who was the first human to orbit Earth?","Yuri Gagarin","Han Solo","Vladimir Komarov","Alan Shepard",1,"c"));
                quizArray.add(new JourneyQuiz(6,"What is Earth's largest tectonic plate?","African Plate","North American Plate","Antarctic Plate","Pacific Plate",4,"c"));
                quizArray.add(new JourneyQuiz(7,"How was the moon created?","The Big Bang","Large asteroid was captured by Earth's orbit","Earth collided with a protoplanet called Theia","Earth's orbit captured a small planet",3,"c"));
                quizArray.add(new JourneyQuiz(8,"What is the highest point on Earth?","K2","Mount Everest","Olympus Mons","Mount Rushmore",2,"c"));
                quizArray.add(new JourneyQuiz(9,"What is Earth's inner core made of?","Gold","Iron","Silver","Uranium",2,"c"));
                quizArray.add(new JourneyQuiz(10,"When did the last ice age end?","2500 years ago","45,000 years ago","200 years ago","11,700 years ago",4,"c"));

                break;

            case "Mars":

                break;

            case "Jupiter":
                break;

            case "Saturn":
                break;

            case "Uranus":
                break;

            case "Neptune":

                break;

        }
        return quizArray;
    }
}
