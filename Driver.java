import java.lang.Math;
import java.util.*;

//Driver class which contains the driver/main method.
class Driver
{
    //Main method to pass the predefined arrays and execute the functions.
    public static void main(String [] args)
    {
        //The two arrays on which all the statistical calculations are to be performed.
        Float[] arr1 = {65.21f, 65.96f, 65.26f, 65.96f, 65.76f, 65.96f, 64.22f};
        int n = arr1.length;
  
        Float[] arr2 = {65.25f, 62.39f, 61.70f, 60.64f, 60.64f, 61.70f, 60.64f}; 
        int m = arr2.length;

        //Object creation and method call for the maximum and minimum values of the arrays.
        Data<Float, ?> minimum = new Data<>();
        Data<Float, ?> maximum = new Data<>();

        float min_val1 = minimum.minimum_val((Float[]) arr1);
        float max_val1 = maximum.maximum_val((Float[]) arr1);
        float min_val2 = minimum.minimum_val((Float[]) arr2);
        float max_val2 = maximum.maximum_val((Float[]) arr2);

        System.out.println("Minimum value of array 1: "+min_val1);
        System.out.println("Maximum value of array 1: "+max_val1);  
        System.out.println("Minimum value of array 2: "+min_val2);
        System.out.println("Maximum value of array 2: "+max_val2);  
		
        //Object creation and method call for the Mean values of the arrays.
        Data<Float, Integer> ob1 = new Data<>();
        Data<Float, Integer> ob2 = new Data<>();

        float mean_val1 = ob1.mean((Float[]) arr1, n);
        float mean_val2 = ob2.mean((Float[]) arr2, m);

        System.out.println("Mean of array 1: "+mean_val1);
        System.out.println("Mean of array 2: "+mean_val2);
        
        //Object creation and method call for the median values of the arrays.
        Data<Float, Integer> medn1 = new Data<>();
        Data<Float, Integer> medn2 = new Data<>();

        float median_val1 = medn1.median((Float[]) arr1, n);
        float median_val2 = medn2.median((Float[]) arr2, m);

        System.out.println("Median of array 1: "+median_val1);
        System.out.println("Median of array 2: "+median_val2);   
        
        //Object creation and method call for the mode values of the arrays.
        Data<Float, Integer> mo1 = new Data<>();
        Data<Float, Integer> mo2 = new Data<>();

        float mode_val1 = mo1.mode((Float[]) arr1, n);
        float mode_val2 = mo2.mode((Float[]) arr2, m);

        System.out.println("Mode of array 1: "+mode_val1);
        System.out.println("Mode of array 2: "+mode_val2);

		//Object creation and method call for the frequency values of the arrays.
		Data<Float, Integer> frq1 = new Data<>();
        Data<Float, Integer> frq2 = new Data<>();

		System.out.println("Frequency of elements of array 1: ");
        frq1.frequency((Float[]) arr1, n);
		System.out.println("Frequency of elements of array 2: ");
        frq2.frequency((Float[]) arr2, m);

        //Object creation and method call for the trimmed mean of the arrays.
        Data<Float, Integer> trim1 = new Data<>();
        Data<Float, Integer> trim2 = new Data<>();

        float trim_mn1 = trim1.trimmed_mean((Float[]) arr1, n);
        float trim_mn2 = trim2.trimmed_mean((Float[]) arr2, m);

        System.out.println("Trimmed mean of array 1: "+trim_mn1);
        System.out.println("Trimmed mean of array 2: "+trim_mn2);

        //Object creation and method call for the first quartile of the arrays.
        Data<Float, Integer> q1_ob1 = new Data<>();
        Data<Float, Integer> q1_ob2 = new Data<>();

        float first_Q1 = q1_ob1.first_quartile((Float[]) arr1, n);
        float second_Q1 = q1_ob2.first_quartile((Float[]) arr2, m);

        System.out.println("First Quartile of array 1: "+first_Q1);
        System.out.println("First Quartile of array 2: "+second_Q1);

        //Object creation and method call for the third quartile of the arrays.
        Data<Float, Integer> q3_ob1 = new Data<>();
        Data<Float, Integer> q3_ob2 = new Data<>();

        float first_Q3 = q3_ob1.third_quartile((Float[]) arr1, n);
        float second_Q3 = q3_ob2.third_quartile((Float[]) arr2, m);

        System.out.println("Third Quartile of array 1: "+first_Q3);
        System.out.println("Third Quartile of array 2: "+second_Q3);

        //Printing out the inter quartile range(Q3-Q1).
        System.out.println("Inter Quartile Range for array 1: "+(first_Q3-first_Q1));
        System.out.println("Inter Quartile Range for array 2: "+(second_Q3-second_Q1)); 

        //Object creation and method call for the variance of the arrays.
        Data<Float, Integer> var_ob1 = new Data<>();
        Data<Float, Integer> var_ob2 = new Data<>();

        float var1 = var_ob1.variance((Float[]) arr1, n);
        float var2 = var_ob2.variance((Float[]) arr2, m);

        System.out.println("The Variance of array 1: "+var1);
        System.out.println("The Variance of array 2: "+var2);

        //Object creation and method call for standard deviation arrays.
        Data<Float, Integer> sdob1 = new Data<>();
        Data<Float, Integer> sdob2 = new Data<>();

        float st_dv1 = sdob1.standard_deviation((Float[]) arr1, n);
        float st_dv2 = sdob2.standard_deviation((Float[]) arr2, m);

        System.out.println("The Standard Deviation of array 1: "+st_dv1);
        System.out.println("The Standard Deviation of array 2: "+st_dv2);
		
		//Object creation and method call for the covariance and correlation of the arrays
        //only if the two arrays are of the same size else an exception will be raised.
        Data<Float, Float> cov = new Data<>();
        Data<Float, Float> cor = new Data<>(); 
        
        try
        {
			if (m != n)
			{
				//Calling the user defined exception.
				throw new Data_size_Exception();
			}
			System.out.println("Covariance: "+cov.covariance(arr1, arr2));
			System.out.println("Correlation: "+cor.correlation(arr1, arr2));
        }
        catch(Data_size_Exception e)
        {
			System.out.println("Data objects are of different size.");
			System.out.println("The arrays must have the same number of elements for covariance and correlation.");
        }

    }
}