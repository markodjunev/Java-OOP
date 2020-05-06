package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var dg1 = new DigitalResource(Subject.GEOGRAPHY, 3);
        var dg2 = new DigitalResource(Subject.BIOLOGY, 2);
        var vidClass1 = new VideoClass(Subject.BIOLOGY, 3, 50);
        var vidClass2 = new VideoClass(Subject.BIOLOGY, 2, 0);

        var ministry = new MinistryOfEducation();
        ministry.addDigitalResource(dg1);
        ministry.addDigitalResource(vidClass1);
        ministry.addDigitalResource(vidClass2);

        var faster = vidClass1.fasterCreation(vidClass1, vidClass2);
        var res = dg1.slowerCreation(dg1,dg2);
        //System.out.println(vidClass1.toString());
        //System.out.println(vidClass2.toString());
        ///System.out.println(faster.toString());
        //System.out.println(dg2.toString());

        //System.out.println(ministry.totalTimeCreation());
        //System.out.println(ministry.totalTimeCreation(Subject.GEOGRAPHY));

        vidClass1.increasePercentage(10);
        //System.out.println(vidClass1.getPercentage());
        //System.out.println(vidClass2.getPercentage());

    }
}

