package com.company;

public class DigitalResource {
    private static int counter = 0;

    protected int id;
    protected Subject subject;
    protected int timeForCreation;
    protected int additionalTime;

    public DigitalResource(Subject subject, int timeForCreation){
        this.id = ++counter;
        this.subject = subject;
        this.timeForCreation = timeForCreation;
        if(subject == Subject.MATHEMATICS)
            additionalTime = 2;
        else if(subject == Subject.BIOLOGY)
            additionalTime = 3;
        else if(subject == Subject.GEOGRAPHY)
            additionalTime = 5;
    }

    public double totalTime(){
        return this.timeForCreation + this.additionalTime;
    }

    public boolean isSubjectMath(){
        if (this.subject == Subject.MATHEMATICS)
            return true;

        return false;
    }

    public DigitalResource slowerCreation(DigitalResource digitalResource1, DigitalResource digitalResource2){
        if (digitalResource2.totalTime() > digitalResource1.totalTime()){
            return digitalResource2;
        }

        return digitalResource1;
    }

    public Subject getSubject(){
        return this.subject;
    }

    @Override
    public String toString() {
        return "DigitalResource{id=" + this.id +
                ", subject=" + this.subject +
                ", timeForCreation=" + this.timeForCreation +
                ", additionalTime=" + this.additionalTime +
                ", totalTime=" + this.totalTime() +
                '}';
    }
}
