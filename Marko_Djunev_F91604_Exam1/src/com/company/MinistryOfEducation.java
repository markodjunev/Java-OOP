package com.company;

import java.util.ArrayList;
import java.util.List;

public class MinistryOfEducation {
    private List<DigitalResource> digitalResources;

    public MinistryOfEducation(){
        this.digitalResources = new ArrayList<>();
    }

    public void addDigitalResource(DigitalResource digitalResource){
        this.digitalResources.add(digitalResource);
    }

    public double totalTimeCreation(){
        double sum = 0;

        for (DigitalResource digitalResource:this.digitalResources) {
            sum+=digitalResource.totalTime();
        }

        return sum;
    }

    public double totalTimeCreation(Subject subject){
        double sum = 0;

        for (DigitalResource digitalResource:this.digitalResources) {
            if(digitalResource.getSubject() == subject)
                sum+=digitalResource.totalTime();
        }

        return sum;
    }
}
