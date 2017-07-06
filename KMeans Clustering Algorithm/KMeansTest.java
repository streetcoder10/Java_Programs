package Viky_Programs;


/*
 * AUTHOR: VIKRAM GOPAL
 * TITLE : K_means Clustering Algorithm Test Class
 * CLASS : CS620 Applied Algorithm
 * PROF  : James Fuller 
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KMeansTest 
{
	public static void main(String[] args) throws IOException 
	/* I was'nt able to import the CSV file so I copied them to a 
	text file and separated the individual elements by commas.*/
	{
		ArrayList<double []> fisher_dataset =new  ArrayList<double[]>();
		FileInputStream myInputStream = null;
		BufferedReader myReader = null;
		KMeans my_Kmeans = new KMeans();

		myInputStream = new FileInputStream("Path to fisher_iris_data.txt");
		myReader = new BufferedReader(new InputStreamReader(myInputStream));
		String row_data = myReader.readLine();
		
		while(row_data!=null)
		{
			String[] colums = row_data.split(",");
			double [] data = new double[5]; 
			for(int j = 0;j < 5;j++)
			{
				data[j] = Double.parseDouble(colums[j]);

			}
			fisher_dataset.add(data);
			row_data = myReader.readLine();
		}

		my_Kmeans.KMeans_input_data(fisher_dataset);
		myReader.close();
	}
}
