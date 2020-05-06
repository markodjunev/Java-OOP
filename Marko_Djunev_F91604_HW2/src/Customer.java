public class Customer {

    public void book_Studio(Studio studio, double hours){
        double neededHours = studio.get_Available_Hours() - hours;
        if (neededHours >= 0){
            studio.reserve(hours);
        }
        else{
            System.out.println("The studio is busy for the next " + hours + "hours. Sorry!");
        }

    }

    public void compare_Directors_Age(MusicCompany firstCompany, MusicCompany secondCompany){
        if (firstCompany.get_Director_Age() < secondCompany.get_Director_Age()){
            System.out.println("The director of " + secondCompany.get_Name() + "is elder!");
        }
        else if (firstCompany.get_Director_Age() > secondCompany.get_Director_Age()){
            System.out.println("The director of " + firstCompany.get_Name() + "is elder!");
        }
        else{
            System.out.println("They have the same age!");
        }
    }
}
