import java.io.*;

/**
 * Models hurricane information, including categories.  
 * Works with HurricaneOrganizer, provides object and comparison skeletons.
 * 
 * @author Susan King
 * @author Richa Bhattacharya
 * @version 01/11/17
 */
public class Hurricane
{
    //Instance variables
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;
    private int category;

    /**
     * Initializes a Hurricane object with no information.
     */
    public Hurricane( )
    {

    }

    /**
     * Initializes a Hurricane object with historical information.
     * 
     * @param year      year the hurricane took place
     * @param month     month when the hurricane took place
     * @param pressure  hurricane's pressure
     * @param speed     hurricane's speed in knots
     * @param name      hurricane's name
     */
    public Hurricane(int year, String month, 
    int pressure, int speed, String name)
    {
        this.year = year;
        this.pressure = pressure;
        this.speed = speed;
        this.month = month;
        this.name = name;
        this.category = determineCategory(speed);

    }

    /**
     * Based upon Saffir/Simpson Hurricane Scale, figures out
     * the category using wind speed in knots.
     * 
     * @param knots     wind speed in knots
     * @return Saffir/Simpson Hurricane Scale category
     */
    public int determineCategory(int knots)
    {
        if (knots >= 64 && knots <= 82)
        {
            return 1;
        }
        if (knots >= 83 && knots <= 95)
        {
            return 2;
        }
        if (knots >= 96 && knots <= 112)
        {
            return 3;
        }
        if (knots >= 113 && knots <= 136)
        {
            return 4;
        }
        if (knots >= 137)
        {
            return 5;
        }
        return 0;
    }

    //Getters

    /**
     * Returns the name of the hurricane
     * 
     * @return name of hurricane
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the month of the hurricane
     * 
     * @return month when hurricane occurs
     */
    public String getMonth()
    {
        return month;
    }

    /**
     * Returns the pressure of the hurricane
     * 
     * @return pressure of the hurricane
     */
    public int getPressure()
    {
        return pressure;
    }

    /**
     * Returns the speed at which the hurricane ocurred
     * 
     * @return the speed of the hurricane
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Returns the year when the hurricane occurred
     * 
     * @return year when the hurricane occurred
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the category of this hurricane based of the Saffir-Simpson scale
     * 
     * @return the category of the hurricane
     */
    public int getCategory()
    {
        return category;
    }

    /**
     * Prints the formatted information regarding the hurricanes 
     * from toString
     */
    public void print()
    {
        System.out.println(toString( ));
    }

    /**
     * Organizes the information of the hurricanes.
     * 
     * @return the formatted information
     */
    public String toString()
    {
        return String.format("%-4d %-5s %-15s %-5d %5d %5d ", 
            year, month, name, category, 
            speed, pressure);
    }

    /**
     * Compares the years when the parameter and this hurricane
     * ocurred
     * 
     * @param h the hurricane being compared 
     * 
     * @return 
     *          0 if they have the same year  
     *         <0 if the parameter hurricane has a higher year value
     *         >0 if the parameter hurricane has lower year value
     */
    public int compareYearTo(Hurricane h)
    {
        return this.getYear() - h.getYear();
    }

    /**
     *Compares two Hurricane's names lexographically
     *
     *@param h the hurricane being compared
     *
     *@return  value 0 if the parameter hurricane's name 
     *         is the same as this hurricane's name
     *         
     *         -1 if the parameter hurricane's name is lexographically 
     *         greater than this hurricane's name
     *         
     *         +1 if the parameter hurricane's name is 
     *         lexographically less than this hurricane's name
     *
     */
    public int compareNameTo(Hurricane h)
    {
        return this.name.compareTo(h.getName());
    }

    /**
     * Compares the pressures at which the parameter and this hurricane
     * ocurred
     * 
     * @param h the hurricane being compared 
     * 
     * @return 
     *          0 if they have the same pressure number 
     *         <0 if the parameter hurricane has a higher pressure value
     *         >0 if the parameter hurricane has lower pressure value
     */
    public int comparePressureTo(Hurricane h)
    {
        return this.getPressure() - h.getPressure();
    }

    /**
     * Compares the speeds at which the parameter and this hurricane
     * were travelling
     * 
     * @param h the hurricane being compared 
     * 
     * @return 
     *         0 if they have the same speed 
     *         <0 if the parameter hurricane has a higher speed value
     *         >0 if the parameter hurricane has lower speed value
     */
    public int compareSpeedTo(Hurricane h)
    {
        return this.getSpeed() - h.getSpeed();
    }

    /**
     * Compares the intensite of this hurricane and the parameter hurricane
     * based of the Saffir-Simpson Scale.
     * 
     * @param h the hurricane being compared 
     * 
     * @return 
     *          0 if they have the same category number 
     *         <0 if the parameter hurricane has a higher category value
     *         >0 if the parameter hurricane has lower category value
     */
    public int compareCategoryTo(Hurricane h)
    {
        return (category - h.getCategory());
    }
}














