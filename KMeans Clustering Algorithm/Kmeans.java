package Viky_Programs;

/*
 * AUTHOR: VIKRAM GOPAL
 * TITLE : K_means Clustering Algorithm
 * CLASS : CS620 Applied Algorithm
 * PROF  : James Fuller 
 */

import java.util.*;
import java.io.*;

public class KMeans 
{
	public ArrayList<double[]> resultCentroids;
	public ArrayList<double[]> prevCentroids;
	public ArrayList<double[]> my_C1,my_C2,my_C3;
	public int setosa,verisicolor,virginica;

	public void initial()
	{
		my_C1 = new ArrayList<double[]>(); 
		my_C2 = new ArrayList<double[]>();
		my_C3 = new ArrayList<double[]>();
		resultCentroids = new ArrayList<double[]>();
		setosa = verisicolor=virginica= 0;
	}

	public void KMeans_input_data(ArrayList <double[]> input_cluster_data)
	{
		initial();
		initial_centroids(input_cluster_data);
		boolean stopping_state = false;
		int loop_count = 0;
		
		while(!stopping_state)
		{   
			my_C1.clear();
			my_C2.clear();
			my_C3.clear();

			for(int i = 0;i<input_cluster_data.size();i++)
			{

				double[] input_data = input_cluster_data.get(i);
				int matching_no = cluster_mapping(input_data);
				if(matching_no==0)my_C1.add(input_data);
				if(matching_no==1)my_C2.add(input_data);
				if(matching_no==2)my_C3.add(input_data);
			}

			double[] new_centroid1 = centroid_calculation(my_C1);
			double[] new_centroid2 = centroid_calculation(my_C2);
			double[] new_centroid3 = centroid_calculation(my_C3);

			resultCentroids.add(new_centroid1);
			resultCentroids.add(new_centroid2);
			resultCentroids.add(new_centroid3);

			stopping_state = centroid_check(prevCentroids,resultCentroids);

			prevCentroids = resultCentroids;
			loop_count++;
		}

		String Cstate1 = clusters_final(my_C1,"1 ");
		String Cstate2 = clusters_final(my_C2,"2 ");
		String Cstate3 = clusters_final(my_C3,"3 ");
		System.out.println("\n");
		System.out.println( "Count = "+loop_count);
		System.out.println(Cstate1);
		System.out.println(Cstate2);
		System.out.println(Cstate3);
	}

	public void initial_centroids(ArrayList<double[]> input_cluster_data)
	{
		prevCentroids = new ArrayList <double[]>();
		Random rn =new Random();
		int centroid1 = 0;
		int centroid2 = 0;
		int centroid3 = 0;

		boolean initialstate=true;
		while(initialstate)
		{
			centroid1 = rn.nextInt(input_cluster_data.size());
			centroid2 = rn.nextInt(input_cluster_data.size());
			centroid3 = rn.nextInt(input_cluster_data.size());
			if(centroid1!=centroid2&&centroid1!=centroid3&&centroid2!=centroid3)
			{
				initialstate=false;
			}
		}
		
		double[] centroid_dat1 = new double[5];
		double[] centroid_dat2 = new double[5];
		double[] centroid_dat3 = new double[5];

		centroid_dat1 = input_cluster_data.get(centroid1);
		centroid_dat2 = input_cluster_data.get(centroid2);
		centroid_dat3 = input_cluster_data.get(centroid3);

		prevCentroids.add(centroid_dat1);
		prevCentroids.add(centroid_dat2);
		prevCentroids.add(centroid_dat3);
	}

	public boolean centroid_check(ArrayList<double[]> prevcentroid,ArrayList<double[]> newcentroid)
	{
		int same_count = 0;
		for(int i=0;i<prevcentroid.size();i++)
		{
			double[] old = prevcentroid.get(i);
			double[] newcnetriod = newcentroid.get(i);
			if(old == newcnetriod)
			{
				same_count++;
			}
		}
		if(same_count==prevcentroid.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String clusters_final(ArrayList <double[]> input_cluster,String clusterstr)
	{
		int IRIS_Type = 0;

		String final_data = "";
		String return_data = "";
		int Setosa_S = 0,Versicolor_VC = 0,Virginica_VG = 0;
		int total_count = 0;
		for(int i = 0;i<input_cluster.size();i++)
		{
			double[] sample_data = input_cluster.get(i);
			IRIS_Type = (int) sample_data[0];
			if(IRIS_Type==0)
			{     
				if(i%10==0)
				{
					final_data +="\n";   
				}
				final_data +="S ";   

				Setosa_S ++;
			}
			if(IRIS_Type==1)
			{
				if(i%10==0)
				{
					final_data +="\n";   
				}
				final_data +="VE ";   
				Versicolor_VC ++;
			}
			if(IRIS_Type==2)
			{
				if(i%10==0)
				{
					final_data +="\n";   
				}
				final_data +="VI ";     
				Virginica_VG++;
			}
		}
		
		setosa += Setosa_S;
		verisicolor += Versicolor_VC;
		virginica += Virginica_VG;
		total_count = Setosa_S+Versicolor_VC+Virginica_VG;

		int max_type = -300;
		String IRIS_Type_str="";
		if(max_type<Setosa_S)
		{
			max_type = Setosa_S;
			IRIS_Type_str ="setosa";
		}
		if(max_type<Versicolor_VC)
		{  
			max_type = Versicolor_VC;
			IRIS_Type_str ="Versicolor";
		}
		if(max_type<Virginica_VG)
		{ 
			max_type = Virginica_VG;
			IRIS_Type_str = "Virginica";
		}
		
		System.out.println(final_data);
		System.out.println("Cluster has "+total_count+" membrs");
		return_data =  "Versiscolor "+Integer.toString(Versicolor_VC)+"  Virginica "
		+Integer.toString(Virginica_VG) +" Setosa " +Integer.toString( Setosa_S);
		System.out.println(IRIS_Type_str);
		return  return_data;	
	}

	public double [] centroid_calculation(ArrayList <double[]> input_cluster)
	{
		double[] centroid = new double[5];
		double pw=0.0,pl=0.0,sw=0.0,sl =0.0;
		for(int i = 0;i<input_cluster.size();i++)
		{ 
			double[] input_data = input_cluster.get(i);
			pw+=input_data[1];
			pl+=input_data[2];
			sw+=input_data[3];
			sl+=input_data[4];
		}

		if(input_cluster.size()==0)
		{
			pw = 0.0;
			pl = 0.0;
			sw = 0.0;
			sl = 0.0;
		}
		else
		{
			pw = pw/input_cluster.size();
			pl = pl/input_cluster.size();
			sw = sw/input_cluster.size();
			sl = sl/input_cluster.size();
		}
		centroid[1] = pw;
		centroid[2] = pl;
		centroid[3] = sw;
		centroid[4] = sl;
		return centroid;
	}

	public int cluster_mapping(double[] input_data)
	{
		double dist=100000,tempdist=0;
		int cluster_no = 0;
		for(int i = 0;i<3;i++)
		{
			double[] centroid = prevCentroids.get(i);
			double dist1 = Math.pow(centroid[1]-input_data[1],2);
			double dist2 = Math.pow(centroid[2]-input_data[2],2);
			double dist3 = Math.pow(centroid[3]-input_data[3],2);
			double dist4 = Math.pow(centroid[4]-input_data[4],2);
			tempdist =Math.sqrt(dist1+dist2+dist3+dist4); 
			if(dist>tempdist)
			{
				cluster_no = i;
				dist = tempdist;
			}
		}
		return cluster_no;
	}
}
