import java.io.*;
import java.util.*;

/**
 * Models hurricane information, works with Hurricane class
 * and the user to manipulate an arraylist of hurricane data. 
 *
 * @author Susan King 
 * @author Richa Bhattacharya 
 * @version 02/07/17
 */
public class HurricanesOrganizerArrayListBhattacharya
{
    //private instance variables
    private ArrayList <Hurricane> hurricanes;

    /**
     * Constructor for the HurricanOrganizerArrayName class
     * 
     * @param filename is the name of the file being read
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public HurricanesOrganizerArrayListBhattacharya(String filename)throws IOException
    {
        readFile(filename);   
    }

    //HOW TO RECODE THIS 
    /**
     * Reads the file given in the parameter by storing 
     * all of the infomation regarding the hurricanes from the file.
     * 
     * @param filename is the name of the of file to be read
     * 
     * @throws IOException if file cannot be read / hurricane
     * infomation cannot be found
     */
    public void readFile(String filename) throws IOException
    {
        hurricanes = new ArrayList <Hurricane>();
        int hurYear, hurPressure, hurSpeed;
        String hurName, hurMonth;
        Scanner inFile = new Scanner(new File(filename));

        while (inFile.hasNext())
        {
            hurYear = inFile.nextInt();
            hurMonth = inFile.next();
            hurPressure = inFile.nextInt();
            hurSpeed = inFile.nextInt();
            String tempName = inFile.nextLine();
            hurName = "";
            for(int k = 0; k < tempName.length(); k++)
            {
                char c = tempName.charAt(k);
                if(('a' <= c && c <= 'z') || ('A' <= c && c <='Z'))
                    hurName += c;
            }
            Hurricane h = new Hurricane(hurYear, hurMonth, hurPressure, hurSpeed, hurName);
            hurricanes.add(h);
        }
        inFile.close();
    }

    /**
     * Finds the highest wind speed values amongst all of the hurricanes 
     * in the Array List
     * 
     * @return the highest wind speed value
     */
    public int findMaxWindSpeed( )
    {
        int max = hurricanes.get(0).getSpeed();
        for (int i = 0; i < hurricanes.size(); i ++ )
        {
            if (hurricanes.get(i).getSpeed() > max)
            {
                max = hurricanes.get(i).getSpeed();
            }
        }
        return max;
    }

    /**
     * Finds the highest pressure values amongst all of the hurricanes 
     * in the Array List
     * 
     * @return the highest pressure value
     */
    public int findMaxPressure( )
    {
        int max = hurricanes.get(0).getPressure();
        for (int i = 0; i < hurricanes.size(); i ++ )
        {
            if (hurricanes.get(i).getPressure() > max)
            {
                max = hurricanes.get(i).getPressure();
            }
        }
        return max;
    }

    /**
     * Finds the lowest wind speed values amongst all of the hurricanes 
     * in the Array List
     * 
     * @return the lowest wind speed value
     */
    public int findMinWindSpeed( )
    {
        int min = hurricanes.get(0).getSpeed();
        for (int i = 0; i < hurricanes.size(); i ++ )
        {
            if (hurricanes.get(i).getSpeed() < min)
            {
                min = hurricanes.get(i).getSpeed();
            }
        }
        return min;
    }

    /**
     * Finds the lowest pressure values amongst all of the hurricanes 
     * in the Array List
     * 
     * @return the lowest pressure value
     */
    public int findMinPressure( )
    {
        int min = hurricanes.get(0).getPressure();
        for (int i = 0; i < hurricanes.size(); i ++ )
        {
            if (hurricanes.get(i).getPressure() < min)
            {
                min = hurricanes.get(i).getPressure();
            }
        }
        return min;
    }

    /**
     * Calculates the average wind speed value amongst all of the
     * hurricanes in the Array List
     * 
     * @return returns the value of the average
     */
    public double calculateAverageWindSpeed( )
    {
        double sum = 0;
        for (int i = 0; i <hurricanes.size(); i ++ )
        {
            sum = sum + hurricanes.get(i).getSpeed();
        }
        return sum / hurricanes.size();
    }

    /**
     * Calculates the average pressure value amongst all of the
     * hurricanes in the Array List
     * 
     * @return returns the value of the average
     */
    public double calculateAveragePressure( )
    {
        double sum = 0;
        for (int i = 0; i <hurricanes.size(); i ++ )
        {
            sum = sum + hurricanes.get(i).getPressure();
        }
        return sum/ hurricanes.size();
    }

    /**
     * Calculates the average category value amongst all of the
     * hurricanes in the Array List
     * 
     * @return returns the value of the average
     */
    public double calculateAverageCategory( )
    {
        double sum = 0;
        for (int i = 0; i <hurricanes.size(); i ++ )
        {
            sum = sum + hurricanes.get(i).getCategory();
        }
        return sum/ hurricanes.size();
    }

    /**
     * Sorts ascending based upon the hurricanes' years,
     * The algorithm is selection sort.
     */
    public void sortYears()
    {
        int mindex = 0;
        for (int outer = 0; outer < hurricanes.size() -1; outer ++)
        {
            mindex = outer;
            for (int inner = outer + 1; inner < hurricanes.size(); inner++)
            {
                if (hurricanes.get(inner).compareYearTo(hurricanes.get(mindex)) < 0)
                {
                    mindex = inner;
                }
            }
            Hurricane temp = hurricanes.get(mindex);
            hurricanes.set(mindex, hurricanes.get(outer));
            hurricanes.set(outer,temp);
        }

    }

    /**
     * Lexicographically sorts hurricanes based on the hurricanes' name, 
     * using insertion sort.
     */
    public void sortNames()
    {
        for (int outer = 1; outer < hurricanes.size(); outer ++)
        {
            Hurricane temp = hurricanes.get(outer);
            int index = outer - 1;
            while (index >=0 && temp.compareNameTo(hurricanes.get(index)) < 0)
            {
                hurricanes.set(index+1,hurricanes.get(index));
                index --;
            }
            hurricanes.set(index+1, temp);
        }
    }

    /**
     * Sorts descending based upon the hurricanes' categories,
     * using selection sort.
     */
    public void sortCategories()
    {
        int maxdex = 0;
        for (int outer = 0; outer < hurricanes.size() -1; outer ++)
        {
            maxdex = outer;
            for (int inner = outer + 1; inner < hurricanes.size(); inner++)
            {
                if (hurricanes.get(inner).compareCategoryTo(hurricanes.get(maxdex)) >0 )
                {
                    maxdex = inner;
                }
            }
            Hurricane temp = hurricanes.get(maxdex);
            hurricanes.set(maxdex, hurricanes.get(outer));
            hurricanes.set(outer, temp);
        }

    }  

    /**
     * Sorts descending based upon pressures using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        int len = hurricanes.size();
        int mid = len/2;
        sortPressuresHelper(0, mid);
        sortPressuresHelper(mid, len);
        int findex = 0;
        int sindex = mid;
        ArrayList <Hurricane> sorted = new ArrayList <Hurricane>();
        for (int index = 0; index <len; index ++)
        {
            if (findex >= mid)
            {
                sorted.add(hurricanes.get(sindex));
                sindex ++;
            }
            else if (sindex >= len)
            {
                sorted.add(hurricanes.get(findex));
                findex ++;
            }
            else if (hurricanes.get(findex).comparePressureTo(hurricanes.get(sindex)) >=0)
            {
                sorted.add(hurricanes.get(findex));
                findex++;
            }
            else 
            {
                sorted.add(hurricanes.get(sindex));
                sindex ++;
            }
        }
        hurricanes = sorted;
    }

    /**
     * Sorts descending a portion of Array List based upon pressure, 
     * using selection sort.
     * 
     * @param   start   the first index to start the sort, included
     * @param   end     one past the last index to sort; hence, end position
     *                  is excluded in the sort
     */
    private void sortPressuresHelper (int start, int end)
    {
        for (int outer = start; outer < end-1; outer ++)
        {
            int mindex = outer;
            for (int inner = outer + 1; inner < end; inner ++)
            {
                if (hurricanes.get(inner).comparePressureTo(hurricanes.get(mindex)) >0)
                {
                    mindex = inner;
                }
            }
            Hurricane temp = hurricanes.get(mindex);
            hurricanes.set(mindex,hurricanes.get(outer));
            hurricanes.set(outer,temp);
        }

    }

    /**
     * Sorts ascending based upon wind speeds using a recursive merge sort. 
     * 
     * @param low   the lowest wind speed, included
     * @param high  the highest wind speed, included
     */
    public void sortWindSpeeds(int low, int high)
    {
        //base case
        if (high ==low)
        {
            return;
        }
        int mid = (low + high) /2;
        sortWindSpeeds(low, mid);
        sortWindSpeeds(mid +1, high);
        mergeWindSpeedsSortHelper(low, mid + 1, high);
    }

    /**
     * Merges two consecutive parts of an Array List, using wind speed as a criteria
     * and a temporary Array List.  The merge results in an ascending sort between
     * the two given indices.
     * 
     * @precondition the two parts are sorted ascending based upon wind speed
     * 
     * @param low   the starting index of one part of the Array List.
     *              This index is included in the first half.
     * @param mid   the starting index of the second part of the Array List.
     *              This index is included in the second half.
     * @param high  the ending index of the second part of the Array List.  
     *              This index is included in the merge.
     */
    private void mergeWindSpeedsSortHelper(int low, int mid, int high)
    {
        ArrayList <Hurricane> merged = new ArrayList <Hurricane>();
        int findex = low;
        int sindex = mid;
        for (int index = 0; index < high-low+1; index ++)
        {
            if (findex >= mid)
            {
                merged.add(index,hurricanes.get(sindex));
                sindex ++;
            }
            else if (sindex > high)
            {
                merged.add(index, hurricanes.get(findex));
                findex ++;
            }
            else if (hurricanes.get(findex).compareSpeedTo(hurricanes.get(sindex)) <= 0)
            {
                merged.add(index, hurricanes.get(findex));
                findex++;
            }
            else 
            {
                merged.add(index,hurricanes.get(sindex));
                sindex++;
            }
        }
        for (int index = 0; index < merged.size(); index ++)
        {
            hurricanes.set(low + index, merged.get(index));
        }
    }

    /**
     * Sequential search for all the hurricanes in a given year.
     * 
     * @param   year    the year when a specific hurricane took place
     * @return  an Array List of objects in Hurricane that occured in
     *          the parameter year
     */
    public ArrayList<Hurricane> searchYear(int year)
    {
        int index = 0;
        ArrayList<Hurricane> h = new ArrayList<Hurricane>();
        for (int i = 0 ; i <hurricanes.size(); i ++)
        {
            if (hurricanes.get(i).getYear() ==year)
            {
                h.add(hurricanes.get(i));
                index ++;

            }
        }
        return h;
    }     

    /**
     * Binary search for a hurricane name.
     * 
     * @param  name   hurricane name being search
     * @return a Hurricane Array List of all objects in hurricanes with specified name. 
     *         Returns null if there are no matches
     */
    public ArrayList<Hurricane>  searchHurricaneName(String name)
    {
        sortNames();
        return searchHurricaneNameHelper(name, 0, hurricanes.size() - 1);
    }

    /**
     * Recursive binary search for a hurricane name.  This is the helper
     * for searchHurricaneName.
     * 
     * @precondition  the Array List must be presorted by the hurricane names
     * 
     * @param   name  hurricane name to search for
     * @param   low   the smallest index that needs to be checked, inclusive
     * @param   high  the highest index that needs to be checked, inclusive
     * @return  a Hurricane Array List of all Hurricane objects with a specified name. 
     *          Returns null if there are no matches
     */
    private ArrayList<Hurricane> searchHurricaneNameHelper(String name, int low , int high)
    {
        //base case
        if (low > high)
        {
            return null;
        }
        int mid = (high + low)/2;
        //base case
        if (hurricanes.get(mid).getName().compareTo(name) == 0)
        {
            return retrieveMatchedNames (name, mid);
        }
        if (hurricanes.get(mid).getName().compareTo(name) > 0)
        {
            return searchHurricaneNameHelper(name, low, mid-1);
        }
        return searchHurricaneNameHelper(name, mid + 1, high);
    }

    /**
     * Supports Binary Search method to get the full range of matches.
     * 
     * @precondition  the Array List must be presorted by the hurricane names
     * 
     * @param   name hurricane name being search for
     * @param   index  the index where a match was found
     * @return  a Hurricane Array List with objects from hurricanes with specified name. 
     *          Returns null if there are no matches
     */
    private ArrayList <Hurricane> retrieveMatchedNames (String name, int index)
    {
        int findex = index -1;
        while (findex >= 0 && hurricanes.get(findex).getName().compareTo(name) == 0)
        {
            findex --;
        }
        findex ++;
        int lindex = index + 1;
        while (lindex <hurricanes.size() && hurricanes.get(lindex).getName().compareTo(name) ==0)
        {
            lindex ++;
        }
        lindex --;
        ArrayList<Hurricane> matches = new ArrayList<Hurricane>();
        int length = lindex - findex + 1;
        for (int i = 0; i < length; i ++)
        {
            matches.add(hurricanes.get(i + findex));
        }
        return matches;
    }

    /**
     * Prints the header for each hurricane which consists of
     * headers for all of the instance variables of each hurricane.
     */
    public void printHeader()
    {
        System.out.println("\n\n");
        System.out.printf("%-4s %-5s %-15s %-5s %-5s %-5s \n", 
            "Year", "Mon.", "Name", "Cat.", "Knots", "Pressure");
    }

    /**
     * Prints the values stored in the Array List "hurricanes"
     */
    public void printHurricanes()
    {
        printHurricanes(hurricanes);
    }

    /**
     * Prints each of the hurricanes
     * 
     * @param hurs is an Array List of Hurricanes
     */
    public void printHurricanes(ArrayList<Hurricane> hurs)
    {
        if(hurs == null || hurs.size() == 0)
        {
            System.out.println("\nVoid of hurricane data.");
            return;
        }
        printHeader();
        for(Hurricane h: hurs)
        {
            System.out.println(h);
        }
    }

    /**
     * Prints the menu which gives all the possible options.
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Print all hurricane data \n" +
            "\t 2 - Print maximum and minimum data \n" +
            "\t 3 - Print averages \n" +
            "\t 4 - Sort hurricanes by year \n" +
            "\t 5 - Sort hurricanes by name \n" +
            "\t 6 - Sort hurricanes by category, descending \n" +
            "\t 7 - Sort hurricanes by pressure, descending \n" +
            "\t 8 - Sort hurricanes by speed \n" + 
            "\t 9 - Search for hurricanes for a given year \n" +
            "\t10 - Search for a given hurricane by name \n" +
            "\t11 - Quit \n");
    }

    /**
     * Prints the max and min values of the wind speed and 
     * the pressure
     */
    public void printMaxAndMin( )
    {
        System.out.println("Maximum wind speed is " + 
            findMaxWindSpeed( ) +
            " knots and minimum wind speed is " + 
            findMinWindSpeed( ) + " knots.");
        System.out.println("Maximum pressure is " + 
            findMaxPressure( ) +
            " and minimum pressure is " + 
            findMinPressure( ) + ".");
    }

    /**
     * Prints the average values of wind speed, 
     * pressure, and category value for the hurricanes in the 
     * Array List.
     */
    public void printAverages( )
    {
        System.out.printf("Average wind speed is %5.2f knots. \n" , 
            calculateAverageWindSpeed( ));
        System.out.printf("Average pressure is %5.2f. \n" , 
            calculateAveragePressure( ));
        System.out.printf("Average category is %5.2f. \n" , 
            calculateAverageCategory( ));
    }

    /**
     * Asks the user which option they have chosen and further 
     * executes the corresponding method.
     * 
     * @return whether or not the program has been terminated or 
     * in other words, the state of "done"
     */
    public boolean interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        printMenu();
        int choice = in.nextInt();
        // clear the input buffer
        in.nextLine();

        if(choice == 1)
        {
            printHurricanes( ); 
        }
        else if (choice == 2)
        {
            printMaxAndMin( );
        }
        else if (choice == 3)
        {
            printAverages( );
        }
        else if(choice == 4)
        {
            sortYears();
            printHurricanes( );
        }
        else if(choice == 5)
        {
            sortNames();
            printHurricanes( );
        }
        else if(choice == 6)
        {
            sortCategories();
            printHurricanes( );
        }
        else if(choice == 7)
        {
            sortPressures();
            printHurricanes( );
        }
        else if(choice == 8)
        {
            sortWindSpeeds(0, hurricanes.size() - 1);
            printHurricanes( );
        }
        else if(choice == 9)
        {
            System.out.print("\n\tWhich year do you want to search for?\n\t");
            int year = in.nextInt();
            printHurricanes(searchYear(year));
        }
        else if(choice == 10)
        {
            System.out.print("\n\tWhich name do you want to search for?\n\t");
            String name = in.next();
            printHurricanes(searchHurricaneName(name));
        }
        else if (choice == 11)
        {
            done = true;
        }  
        return done;
    }

    /**
     * Continues to run the program until the user clicks 11
     * signifying they are done with the program. At this point,
     * the program is exitted.
     * 
     * @param args  user's information from the command line
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public static void main (String [] args) throws IOException
    {
        HurricanesOrganizerArrayListBhattacharya cane = 
            new HurricanesOrganizerArrayListBhattacharya("hurricanedata.txt");
        boolean areWeDoneYet = false;
        while ( ! areWeDoneYet)
        {
            areWeDoneYet = cane.interactWithUser( );    
        }
    }
}
