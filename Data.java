import java.lang.Math;
import java.util.*;

//Java generic class with generic data types D1 and D2 which take only numeric values.
public class Data<D1 extends Number, D2 extends Number> 
{
    //Method to return the minimum value of the passed array.
    public float minimum_val(D1 arr[])
    {
        //Initialize min with first element of array.  
        float min = arr[0].floatValue();  

        //Loop through the array to find the minimum element. 
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i].floatValue() < min)
            {
                min = arr[i].floatValue();
            }
        }

        return min; 
    }

    //Method to return the maximum value of the passed array.
    public float maximum_val(D1 arr[])
    {
        //Initialize max with first element of array.  
        float max = arr[0].floatValue();  

        //Loop through the array to find the maxmimum element. 
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i].floatValue() > max)
            {
                max = arr[i].floatValue();
            }
        }

        return max; 
    }

    //Method to return the mean value of the passed array.
    public float mean(D1 arr[], D2 n)
    {
        float sum = 0.0f;
        
        //Looping through the array and calculating the sum of the elements.
        for(int i = 0; i < n.intValue(); i++)
        {
            sum = sum + arr[i].floatValue();
        }  

        return sum/n.floatValue();

    }

    //Method to return the median value of the passed array.
    public float median(D1[] arr, D2 n)
    {    
        Arrays.sort(arr);
 
        //Checking for the even or odd case.
        if (n.intValue() % 2 != 0)
        {
            return (float)arr[n.intValue() / 2];
        }
        else
        {
            return (arr[(n.intValue() - 1) / 2].floatValue() + arr[n.intValue() / 2].floatValue()) / 2;
        }
    }

    //Method to return the mode value of the passed array.
    public float mode(D1 arr[], D2 n)
    {
        //To store the mode.
        float maxValue = 0;

        int maxCount = 0;
        int i, j;
        int count = 0;

        //Looping through the array to find the count and the value with most count/mode.
        for (i = 0; i < n.intValue(); ++i) 
        {
            for (j = 0; j < n.intValue(); ++j)
            {
                if (arr[j] == arr[i])
                ++count;
            }
            if (count > maxCount)
            {
                maxCount = count;
                maxValue = arr[i].floatValue();
            }
        }

        return maxValue; 
    }
    
    public void frequency(D1 arr[], D2 n)
    {
		Arrays.sort(arr);
        //Store all numeric elements and their frequencies in dictionary
        Map<Float, Float> ob = new HashMap<Float, Float>();
            
        for(int i = 0; i < n.intValue(); i++)
        {
            if(ob.containsKey(arr[i]))
            {
                ob.put(arr[i].floatValue(), ob.get(arr[i]) + 1.0f);
            }
            else
            {
                ob.put(arr[i].floatValue(), 1.0f);
            }
        }
         
        //Print elements and their frequencies in the sorted array
        for(int i = 0; i < n.intValue(); i++)
        {
           
            //Conditional statement to check and Print 
			//only if the element is not already printed before
            if(ob.get(arr[i]) != 0.0f)
            {
                System.out.println(arr[i]+": "+ob.get(arr[i]));
                ob.put(arr[i].floatValue(), 0.0f);
            }           
        }  
    }

    //Method to return the trimmed mean value of the passed array.
    public float trimmed_mean(D1 arr[], D2 n)
    {
        //Array to store the passed array except the min and max value..
        float trim_arr [] = new float[n.intValue()-2];

        float sum = 0;
        Arrays.sort(arr);

        //Looping through the arrays to assign all the values
        //of the passed array to trim_arr except min and max value of arr.
        for(int i = 1; i < n.intValue()-1; i++)
        {
            trim_arr [i-1] = arr[i].floatValue();
        }
        for(int j = 0; j < trim_arr.length; j++)
        {
            sum = sum + trim_arr[j];
        }

        return sum / (n.floatValue()-2);
    }

    //Method to return the first quartile of the passed array.
    public float first_quartile(D1 arr[], D2 n)
    {
        //Stores the median of the passed array.
        int median_val;

        Arrays.sort(arr);

        //Checking for the even or odd case and storing the index value.
        if(n.intValue() % 2 != 0)
        {
            median_val = n.intValue() / 2;
        }
        else
        {
            median_val =(n.intValue() - 1) / 2 + (n.intValue() / 2) / 2;
        }

        //Checking for the even or odd case and returning the value for the respective index.
        if(median_val % 2 != 0)
        {
            return (float)arr[median_val / 2];
        }
        else
        {
            return (arr[(median_val - 1) / 2].floatValue() + arr[median_val / 2].floatValue()) / 2;
        }
    }

    //Method to return the third quartile of the passed array.
    public float third_quartile(D1 arr[], D2 n)
    {
        //Stores the median of the passed array.
        int median_val;

        Arrays.sort(arr);

        //Checking for the even or odd case and storing the index value.
        if(n.intValue() % 2 != 0)
        {
            median_val = n.intValue() / 2;
        }
        else
        {
            median_val =(n.intValue() - 1) / 2 + (n.intValue() / 2) / 2;
        }

        //Checking for the even or odd case and returning the value for the respective index.
        if(median_val % 2 == 0)
        {
            return (float)arr[(median_val / 2) + median_val + 1];
        }
        else
        {
            return (arr[((median_val - 1) / 2) + median_val + 1].floatValue() + arr[(median_val / 2) + median_val + 1].floatValue()) / 2;
        }
    }

    //Method to return the variance of the passed array.
    public float variance(D1 arr[], D2 n)
    {
        float sum = 0.0f;

        //Stores the squared difference.
        float sqrd_Diff = 0.0f;
     
        for(int i = 0; i < n.intValue(); i++)
        {
            sum = sum + arr[i].floatValue();
        }  
        float mean_val = sum/n.floatValue();
     
        // Computing the sum squared differences with mean.
        for (int i = 0; i < n.intValue(); i++)
        {
            sqrd_Diff += (arr[i].floatValue() - mean_val) * (arr[i].floatValue() - mean_val);
        }

        return sqrd_Diff / n.intValue();
    }

    //Method to return the standard deviation of the passed array.
    public float standard_deviation(D1 arr[], D2 n)
    {
        float sum = 0.0f;
        float summation = 0.0f;
        float square_root = 0.0f;
        float standard_Deviation = 0.0f;
     
        //Looping through the passed array to find the mean.
        for(int i = 0; i < n.intValue(); i++)
        {
            sum = sum + arr[i].floatValue();
        }  
        float mean_val = sum/n.floatValue();

        //Loop to find the summation value for finding the standard deviation.
        for (int i = 0; i < n.intValue(); i++) 
        {
            summation = (float)(summation + Math.pow((arr[i].floatValue() - mean_val), 2));    
        }
        
        square_root = summation / n.intValue();
        standard_Deviation = (float) Math.sqrt(square_root);
        return standard_Deviation;
    }

    //Method to return the covariance of the passed array.
    public float covariance(D1 arr1[], D2 arr2[])
    {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
        int n = arr2.length;
        float sum = 0.0f;

        //Creating objects for the generic class.
        Data<Float, Integer> ob1 = new Data<>();
        Data<Float, Integer> ob2 = new Data<>();

        //Storing the mean of the arrays in the floating variable.
        float mean_arr1 = ob1.mean((Float[]) arr1, n);
        float mean_arr2 = ob2.mean((Float[]) arr2, n);

        for(int i = 0; i < n; i++)
        {
            sum = sum + (arr1[i].floatValue() - mean_arr1) * (arr2[i].floatValue() - mean_arr2);
        }
        
        return sum / (n - 1);
    }

    //Method to return the correlation of the passed array.
    public float correlation(D1 arr1[], D2 arr2[])
    {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
        int n = arr2.length;

        float sum_1 = 0, sum_2 = 0, sum_1_2 = 0;
        float squareSum_1 = 0, squareSum_2 = 0;
       
        for (int i = 0; i < n; i++)
        {
            //sum of elements of array arr1.
            sum_1 = sum_1 + arr1[i].floatValue();
       
            //sum of elements of array arr2.
            sum_2 = sum_2 + arr2[i].floatValue();
       
            //sum of arr1[i] * arr2[i].
            sum_1_2 = sum_1_2 + arr1[i].floatValue() * arr2[i].floatValue();
       
            //sum of square of array elements arr1 and arr2.
            squareSum_1 = squareSum_1 + arr1[i].floatValue() * arr1[i].floatValue();
            squareSum_2 = squareSum_2 + arr2[i].floatValue() * arr2[i].floatValue();
        }
       
        //Using the correlation formula for calculating correlation coefficient.
        float corr = (float)(n * sum_1_2 - sum_1 * sum_2) / (float)(Math.sqrt((n * squareSum_1 - sum_1 * sum_1) * (n * squareSum_2 - sum_2 * sum_2)));
       
        return corr;
    }   
}


