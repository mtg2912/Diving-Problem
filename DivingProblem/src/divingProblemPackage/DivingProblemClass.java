package divingProblemPackage;
import javax.swing.*;
public class DivingProblemClass 
{
	public static void main(String[] args) 
	{
		double allScores [];
		allScores=new double [7];
		double score;
		score=0.0;

		allScores=inputAllScores();
		
		score=calculateScore(allScores);
		
		
		System.out.printf("Your final score is %.2f",score);
		
	}//end main

	public static double inputValidScore()
	{
		double score;
		score =0.0;

		do
		{
			score=Double.parseDouble(JOptionPane.showInputDialog(null, "Please input a score"));
			if (score<0.0||score>10.0)
			{
				System.out.println("Not a valid score. Please input a score between 0.0 and 10.0");
			}
		}while(score<0.0||score>10.0);
		
		return(score);
	}//end inputValidScore
	
	
	
	public static double[] inputAllScores()
	{
		double allScores[];
		allScores=new double [7];
		for(int cntr=0; cntr<allScores.length; cntr++)
		{
			allScores[cntr]=inputValidScore();
		}
		
		return(allScores);
		
	}//end inputAllScores


	public static double inputValidDegreeOfDifficulty()
	{
		double difficulty;
		
		do
		{
			difficulty=Double.parseDouble(JOptionPane.showInputDialog(null, "Please input the degree of difficulty value."));
		}while(difficulty<1.2||difficulty>3.8);
		
		return(difficulty);
		
	}//end inputValidDegreeOfDifficulty
	
	public static double calculateScore(double allScores[])
	{
		double score;
		double difficulty;
		score=0.0;
		difficulty=0.0;
		
		//sort the array from lowest to highest
		allScores=sortArray(allScores);
		
		//throw out highest and lowest scores and add all remaining scores
		for(int cntr=1;cntr<(allScores.length-1);cntr++)
		{
			score+=allScores[cntr];
		}
		
		//multiply by degree of difficulty
		difficulty=inputValidDegreeOfDifficulty();
		score*=difficulty;
		
		//multiply by 0.6
		score*=0.6;
		
		//return score
		return(score);
		
	}//end calculateScore
		
	public static double[] sortArray(double array[])
	{
		double temp;
		int i;
		int j;
		
		temp=0.0;
		
		for(i=0;i<array.length;i++)
		{
			for(j=0;j<array.length;j++)
			{
				if (array[i]<array[j])
				{
					temp=array[j];
					array[j]=array[i];
					array[i]=temp;
				}//end while
			}//end for j
		}//end for i
		
		return(array);
	}//end sortArray
	
}//end class