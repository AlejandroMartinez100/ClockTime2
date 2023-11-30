
/**
 * Name: Alejandro Martinez (martinez)
 * Course: CSCI 241 - Computer Science I
 * Section: 002 
 * Assignment: 9
 *
 * Project/Class Description:
 * (summarize ClockTime here)
 *
 * Known bugs:
 * None
 */
public class ClockTime
{
    // instance variables 
    private int hour;
    private int minute;
    private int second;

    //default constructor
    public ClockTime()
    {
        // initialise instance variables
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    //alternate constructor with error checking
    public ClockTime(int hour, int minute, int second)
    {    
        //error checking for seconds
        if (second > 59){ 
            minute += second / 60;
            second %= 60;}
        else if (second < 0){ 
            second = 0;    
        }

        //error checking for minutes
        if (minute > 59){ 
            hour += minute / 60;
            minute %= 60;}
        else if (minute < 0){ 
            minute = 0;    
        }

        //error checking for hours
        if (hour > 24){ 
            hour %= 24;}
        else if (hour < 0){ 
            hour = 0;    
        }

        // initialise instance variables
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //getter methods
    public int getHour(){ 
        return hour;
    }

    public int getMinute(){ 
        return minute;
    }

    public int getSecond(){ 
        return second;
    }

    //setter methods plus error checking
    public void setHour(int hour){ 
        if (hour >= 0 && hour <= 24){
            this.hour = hour;
        }
        else {
            System.out.println("Invalid hour input. Hour must" +
                "be between 0 and 24.");}
    }

    public void setMinute(int minute){ 
        if (minute >= 0 && minute <= 59){
            this.minute = minute;
        }
        else {
            System.out.println("Invalid minute input. minute must" +
                "be between 0 and 59.");}
    }

    public void setSecond(int second){ 
        if (second >= 0 && second <= 59){
            this.second = second;
        }
        else {
            System.out.println("Invalid second input. second must" +
                "be between 0 and 59.");}
    }

    //methods creating strings
    public String toString(){
        return String.format("%02d:"+
            "%02d:%02d",hour, minute, second);
    }

    public String toString12(){
        String period =(hour < 12) ? "A.M.":"P.M.";
        int displayHour =(hour == 0  || hour == 12)? 12 : hour % 12;
        return String.format("%02d:"+
            "%02d:%02d %s",displayHour, minute, second, period);
    }

    //method that advances the time by a given number of seconds
    public void advance(int seconds){
        if (seconds > 0){
            int totalSeconds = hour * 3600 + minute * 60 + second + seconds;
            hour =(totalSeconds / 3600) % 24;
            minute =(totalSeconds % 3600) / 60;
            second = totalSeconds % 60;
        }
    }

    //method that will check if both clocks have the same time
    public boolean equals(ClockTime otherTime){
        return this.hour == otherTime.getHour() 
        && this.minute == otherTime.getMinute()
        && this.second == otherTime.getSecond();
    }
}
