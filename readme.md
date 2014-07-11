###################################################################################################

				Sentimental Analysis API

###################################################################################################

	Features 


- uses Vivek's sentimental tool .

- Provides an java API for http://sentiment.vivekn.com.

- Can be used either as a command line or in a program . 

###################################################################################################


	Usage 


- Either via command line : 

		java -jar Sentimental-analysis.jar "Today was a good day at work ! "

	
	Or 


- Can be used in java program :



		ArrayList<String> a=Sentimental_analysis.get_sentiment("Sample trial test : You bad ass !! ");
		System.out.println(a.get(0)); // prints the sentimental result (positive/negative/neutral)

		System.out.println(a.get(1)); // gives the percentage of accuracy of computation

	
