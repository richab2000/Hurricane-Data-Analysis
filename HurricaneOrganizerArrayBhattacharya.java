import java.io.*;
import java.util.*;

/**
 * Models hurricane information, works with Hurricane class
 * and the user to manipulate an array of hurricane data. 
 *
 * @author Susan King 
 * @author Richa Bhattacharya 
 * @version 01/11/17
 */
public class HurricaneOrganizerArrayBhattacharya
{
    //private instance variables
    private Hurricane [] hurricanes;

    /**
     * Constructor for the HurricanOrganizerArrayName class
     * 
     * @param filename is the name of the file being read
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    public HurricaneOrganizerArrayBhattacharya(String filename)throws IOException
    {
        readFile(filename);   
    }

    /**
     * Determines the length of the file passed as a parameter
     * 
     * @param filename is the name of the file 
     * 
     * @return return the length of the file
     * 
     * @throws IOException  if file with the hurricane information cannot be found
     */
    private static int determineFileLength(String filename) throws IOException
    {
        Scanner inFile = new Scanner(new File(filename));
        int counter = 0;

        while(inFile.hasNextLine())
        {
            counter++;
            inFile.nextLine();
        }
        inFile.close();
        return counter;
    }

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
        hurricanes = new Hurricane [determineFileLength(filename)];
        int hurYear, hurPressure, hurSpeed;
        String hurName, hurMonth;
        Scanner inFile = new Scanner(new File(filename));

        for(int i = 0; i < hurricanes.length; i++)
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
            hurricanes [i] = h;
        }
        inFile.close();
    }

    /**
     * Finds the highest wind speed values amongst all of the hurricanes 
     * in the array
     * 
     * @return the highest wind speed value
     */
    public int findMaxWindSpeed( )
    {
        int max = hurricanes[0].getSpeed();
        for (int i = 0; i < hurricanes.length; i ++ )
        {
            if (hurricanes[i].getSpeed() > max)
            {
                max = hurricanes[i].getSpeed();
            }
        }
        return max;
    }

    /**
     * Finds the highest pressure values amongst all of the hurricanes 
     * in the array
     * 
     * @return the highest pressure value
     */
    public int findMaxPressure( )
    {
        int max = hurricanes[0].getPressure();
        for (int i = 0; i < hurricanes.length; i ++ )
        {
            if (hurricanes[i].getPressure() > max)
            {
                max = hurricanes[i].getPressure();
            }
        }
        return max;
    }

    /**
     * Finds the lowest wind speed values amongst all of the hurricanes 
     * in the array
     * 
     * @return the lowest wind speed value
     */
    public int findMinWindSpeed( )
    {
        int min = hurricanes[0].getSpeed();
        for (int i = 0; i < hurricanes.length; i ++ )
        {
            if (hurricanes[i].getSpeed() < min)
            {
                min = hurricanes[i].getSpeed();
            }
        }
        return min;
    }

    /**
     * Finds the lowest pressure values amongst all of the hurricanes 
     * in the array
     * 
     * @return the lowest pressure value
     */
    public int findMinPressure( )
    {
        int min = hurricanes[0].getPressure();
        for (int i = 0; i < hurricanes.length; i ++ )
        {
            if (hurricanes[i].getPressure() < min)
            {
                min = hurricanes[i].getPressure();
            }
        }
        return min;
    }

    /**
     * Calculates the average wind speed value amongst all of the
     * hurricanes in the array
     * 
     * @return returns the value of the average
     */
    public double calculateAverageWindSpeed( )
    {
        double sum = 0;
        for (int i = 0; i <hurricanes.length; i ++ )
        {
            sum = sum + hurricanes[i].getSpeed();
        }
        return sum / hurricanes.length;
    }

    /**
     * Calculates the average pressure value amongst all of the
     * hurricanes in the array
     * 
     * @return returns the value of the average
     */
    public double calculateAveragePressure( )
    {
        double sum = 0;
        for (int i = 0; i <hurricanes.length; i ++ )
        {
            sum = sum + hurricanes[i].getPressure();
        }
        return sum/ hurricanes.length;
    }

    /**
     * Calculates the average category value amongst all of the
     * hurricanes in the array
     * 
     * @return returns the value of the average
     */
    public double calculateAverageCategory( )
    {
        double sum = 0;
        for (int i = 0; i <hurricanes.length; i ++ )
        {
            sum = sum + hurricanes[i].getCategory();
        }
        return sum/ hurricanes.length;
    }

    /**
     * Sorts ascending based upon the hurricanes' years,
     * The algorithm is selection sort.
     */
    public void sortYears()
    {
        int mindex = 0;
        for (int outer = 0; outer < hurricanes.length -1; outer ++)
        {
            mindex = outer;
            for (int inner = outer + 1; inner < hurricanes.length; inner++)
            {
                if (hurricanes[inner].compareYearTo(hurricanes[mindex]) < 0)
                {
                    mindex = inner;
                }
            }
            Hurricane temp = hurricanes[mindex];
            hurricanes[mindex] = hurricanes[outer];
            hurricanes[outer] = temp;
        }

    }

    /**
     * Lexicographically sorts hurricanes based on the hurricanes' name, 
     * using insertion sort.
     */
    public void sortNames()
    {
        for (int outer = 1; outer < hurricanes.length; outer ++)
        {
            Hurricane temp = hurricanes[outer];
            int index = outer - 1;
            while (index >=0 && temp.compareNameTo(hurricanes[index]) < 0)
            {
                hurricanes[index+1] = hurricanes[index];
                index --;
            }
            hurricanes[index+1] = temp;
        }
    }

    /**
     * Sorts descending based upon the hurricanes' categories,
     * using selection sort.
     */
    public void sortCategories()
    {
        int maxdex = 0;
        for (int outer = 0; outer < hurricanes.length -1; outer ++)
        {
            maxdex = outer;
            for (int inner = outer + 1; inner < hurricanes.length; inner++)
            {
                if (hurricanes[inner].compareCategoryTo(hurricanes[maxdex]) >0 )
                {
                    maxdex = inner;
                }
            }
            Hurricane temp = hurricanes[maxdex];
            hurricanes[maxdex] = hurricanes[outer];
            hurricanes[outer] = temp;
        }

    }  

    /**
     * Sorts descending based upon pressures using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        int len = hurricanes.length;
        int mid = len/2;
        sortPressuresHelper(0, mid);
        sortPressuresHelper(mid, len);
        int findex = 0;
        int sindex = mid;
        Hurricane [] sorted = new Hurricane [len];
        for (int index = 0; index < len; index ++)
        {
            if (findex >= mid)
            {
                sorted[index] = hurricanes[sindex];
                sindex ++;
            }
            else if (sindex >= len)
            {
                sorted[index] = hurricanes[findex];
                findex ++;
            }
            else if (hurricanes[findex].comparePressureTo(hurricanes[sindex]) >=0)
            {
                sorted[index] = hurricanes[findex];
                findex++;
            }
            else 
            {
                sorted[index] = hurricanes[sindex];
                sindex++;
            }

        }
        hurricanes = sorted;
    }

    /**
     * Sorts descending a portion of array based upon pressure, 
     * using selection sort.
     * 
     * @param   start   the first index to start the sort, inclusive
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
                if (hurricanes[inner].comparePressureTo(hurricanes[mindex]) >0)
                {
                    mindex = inner;
                }
            }
            Hurricane temp = hurricanes[mindex];
            hurricanes[mindex] = hurricanes[outer];
            hurricanes[outer] = temp;
        }

    }

    /**
     * Sorts ascending based upon wind speeds using a recursive merge sort. 
     * 
     * @param low   the lowest wind speed, included in the first half
     * @param high  the highest wind speed, included in the merge
     */
    public void sortWindSpeeds(int low, int high)
    {
        // base case
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
     * Merges two consecutive parts of an array, using wind speed as a criteria
     * and a temporary array.  The merge results in an ascending sort between
     * the two given indices.
     * 
     * @precondition the two parts are sorted ascending based upon wind speed
     * 
     * @param low   the starting index of one part of the array.
     *              This index is included in the first half.
     * @param mid   the starting index of the second part of the array.
     *              This index is included in the second half.
     * @param high  the ending index of the second part of the array.  
     *              This index is included in the merge.
     */
    private void mergeWindSpeedsSortHelper(int low, int mid, int high)
    {
        Hurricane [] merged = new Hurricane [high - low + 1];
        int findex = low;
        int sindex = mid;
        for (int index = 0; index <merged.length; index ++)
        {
            if (findex >= mid)
            {
                merged[index] = hurricanes[sindex];
                sindex ++;
            }
            else if (sindex > high)
            {
                merged[index] = hurricanes[findex];
                findex ++;
            }
            else if (hurricanes[findex].compareSpeedTo(hurricanes[sindex]) <= 0)
            {
                merged[index] = hurricanes[findex];
                findex++;
            }
            else 
            {
                merged[index] = hurricanes[sindex];
                sindex++;
            }

        }
        for (int index = 0; index < merged.length; index ++)
        {
            hurricanes [low + index ] = merged [index];
        }
    }

    /**
     * Sequential search for all the hurricanes in a given year.
     * 
     * @param   year    the year when a specific hurricane took place
     * @return  an array of objects in Hurricane that occured in
     *          the parameter year
     */
    public Hurricane [] searchYear(int year)
    {
        int counter = 0;
        for (int i = 0; i < hurricanes.length; i ++)
        {
            if (hurricanes[i].getYear() == year)
            {
                counter ++;
            }
        }
        int index = 0;
        Hurricane[] h = new Hurricane[counter];
        for (int i = 0 ; i <hurricanes.length; i ++)
        {
            if (hurricanes[i].getYear() ==year)
            {
                h[index] = hurricanes[i];
                index ++;
                
            }
        }
        return h;
    }     

    /**
     * Binary search for a hurricane name.
     * 
     * @param  name   hurricane name being search
     * @return a Hurricane array of all objects in hurricanes with specified name. 
     *         Returns null if there are no matches
     */
    public Hurricane[ ] searchHurricaneName(String name)
    {
        sortNames();
        return searchHurricaneNameHelper(name, 0, hurricanes.length - 1);
    }

    /**
     * Recursive binary search for a hurricane name.  This is the helper
     * for searchHurricaneName.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name  hurricane name to search for
     * @param   low   the smallest index that needs to be checked, both inclusive
     * @param   high  the highest index that needs to be checked, both inclusive
     * @return  a Hurricane array of all Hurricane objects with a specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] searchHurricaneNameHelper(String name, int low , int high)
    {
        // base case
        if (low > high)
        {
            return null;
        }
        int mid = (high + low)/2;
        
        //base case
        if (hurricanes[mid].getName().compareTo(name) == 0)
        {
            return retrieveMatchedNames (name, mid);
        }
        if (hurricanes[mid].getName().compareTo(name) > 0)
        {
            return searchHurricaneNameHelper(name, low, mid-1);
        }
        return searchHurricaneNameHelper(name, mid + 1, high);
    }

    /**
     * Supports Binary Search method to get the full range of matches.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name hurricane name being search for
     * @param   index  the index where a match was found
     * @return  a Hurricane array with objects from hurricanes with specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] retrieveMatchedNames (String name, int index)
    {
        int findex = index -1;
        while (findex >= 0 && hurricanes[findex].getName().compareTo(name) == 0)
        {
            findex --;
        }
        findex ++;
        int lindex = index + 1;
        while (lindex <hurricanes.length && hurricanes[lindex].getName().compareTo(name) ==0)
        {
            lindex ++;
        }
        lindex --;
        Hurricane [] matches = new Hurricane [ lindex - findex + 1];
        for (int i = 0; i < matches.length; i ++)
        {
            matches[i] = hurricanes[i + findex];
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
     * Prints the values stored in the array "hurricanes"
     */
    public void printHurricanes()
    {
        printHurricanes(hurricanes);
    }

    /**
     * Prints each of the hurricanes
     * 
     * @param hurs is an array of Hurricanes
     */
    public void printHurricanes(Hurricane [] hurs)
    {
        if(hurs == null || hurs.length == 0)
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
     * array.
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
            sortWindSpeeds(0, hurricanes.length - 1);
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
        HurricaneOrganizerArrayBhattacharya cane = 
            new HurricaneOrganizerArrayBhattacharya("hurricanedata.txt");
        boolean areWeDoneYet = false;
        while ( ! areWeDoneYet)
        {
            areWeDoneYet = cane.interactWithUser( );    
        }
    }
}
