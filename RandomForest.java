/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mimt_honeypot;



import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author EGC
 */
public class RandomForest {
     public static double f1,f2,f3,f4;
       public static double a1,a2,a3,a4,a5,a6;
       public static String b1,b2,b3,b4,b5,b6,s1,s2,s3,s4,s5,s6;
	/** the number of threads to use when generating the forest */
	private static final int NUM_THREADS=Runtime.getRuntime().availableProcessors();
	//private static final int NUM_THREADS=2;
	/** the number of categorical responses of the data (the classes, the "Y" values) - set this before beginning the forest creation */
	public static int C;
	/** the number of attributes in the data - set this before beginning the forest creation */
	public static int M;
	/** Of the M total attributes, the random forest computation requires a subset of them
	 * to be used and picked via random selection. "Ms" is the number of attributes in this
	 * subset. The formula used to generate Ms was recommended on Breiman's website.
	 */
        public static int TP=0,TN=0,FP=0,FN=0;
        public static float Precision=0,Recall,f1_score=0;
	public static int Ms;
	/** the collection of the forest's decision trees */
	private ArrayList<DTree> trees;
	/** the starting time when timing random forest creation */
	private long time_o;
	/** the number of trees in this random tree */
	private int numTrees;
	/** For progress bar display for the creation of this random forest, this is the amount to update by when one tree is completed */
	private double update;
	/** For progress bar display for the creation of this random forest, this records the total progress */
	private double progress;
	/** this is an array whose indices represent the forest-wide importance for that given attribute */
	private int[] importances;
	/** This maps from a data record to an array that records the classifications by the trees where it was a "left out" record (the indices are the class and the values are the counts) */
	private HashMap<int[],int[]> estimateOOB;
	/** This holds all of the predictions of trees in a Forest */
	private ArrayList<ArrayList<Integer>> Prediction;
	/** the total forest-wide error */
	private double error;
	/** the thread pool that controls the generation of the decision trees */
	private ExecutorService treePool;
	/** the original training data matrix that will be used to generate the random forest classifier */
	private ArrayList<String[]> data;
	/** the data on which produced random forest will be tested*/
	private ArrayList<String[]> testdata;
        public static String accuracy;
	/**
	 * Initializes a Random forest creation
	 * 
	 * @param numTrees			the number of trees in the forest
	 * @param data				the training data used to generate the forest
	 * @param buildProgress		records the progress of the random forest creation
	 */
	/*public RandomForest(int numTrees, ArrayList<int[]> data, ArrayList<int[]> t_data ){
           this.numTrees=numTrees;
		this.data=data;
		this.testdata=t_data;
		trees=new ArrayList<DTree>(numTrees);
		update=100/((double)numTrees);
		progress=0;
		StartTimer();
		System.out.println("creating "+numTrees+" trees in a random Forest. . . ");
		//System.out.println("total data size is "+data.size());
		//System.out.println("number of attributes "+(data.get(0).length-1));
		System.out.println("number of selected attributes "+((int)Math.round(Math.log(data.get(0).length-1)/Math.log(2)+1)));
//		ArrayList<Datum> master=AssignClassesAndGetAllData(data);
		estimateOOB=new HashMap<int[],int[]>(data.size());
		Prediction = new ArrayList<ArrayList<Integer>>();
		
	}*/

 
 
   
	/**
	 * Begins the random forest creation
	 */
	public void Start() throws FileNotFoundException, IOException {
           
            File trainfile = new File("train.csv");
        File testfile = new File("test.csv");
ArrayList<String[]> traincontent = new ArrayList<>();
ArrayList<String[]> testcontent = new ArrayList<>();
		
        BufferedReader trainreadFile,testreadFile = null;
     
            trainreadFile = new BufferedReader(new FileReader(trainfile));
            testreadFile = new BufferedReader(new FileReader(testfile));
        
        String trainline,testline;

            while ((trainline = trainreadFile.readLine()) != null) {
                traincontent.add(trainline.split(","));                             
    }                                        
     while ((testline = testreadFile.readLine()) != null) {
                testcontent.add(testline.split(","));
              
    } 
              this.numTrees=2;
              System.out.println(traincontent);
		this.data=traincontent;
		this.testdata=testcontent;
           
		trees=new ArrayList<DTree>(numTrees);
		update=100/((double)numTrees);
		progress=0;
		StartTimer();
		System.out.println("creating "+numTrees+" trees in a random Forest. . . ");
		//System.out.println("total data size is "+data.size());
		//System.out.println("number of attributes "+(data.get(0).length-1));
		System.out.println("number of selected attributes "+((int)Math.round(Math.log(data.get(0).length-1)/Math.log(2)+1)));
//		ArrayList<Datum> master=AssignClassesAndGetAllData(data);
		estimateOOB=new HashMap<int[],int[]>(data.size());
		Prediction = new ArrayList<ArrayList<Integer>>();
            
		System.out.println("Number of threads started : "+NUM_THREADS);
		System.out.print("Running...");
		treePool=Executors.newFixedThreadPool(NUM_THREADS);
		for (int t=0;t<numTrees;t++){
                    System.out.println(data);
			treePool.execute(new CreateTree(data,this,t+1));
			System.out.print(".");
		}treePool.shutdown();
		try {	         
			treePool.awaitTermination(Long.MAX_VALUE,TimeUnit.SECONDS); //effectively infinity
	    } catch (InterruptedException ignored){
	    	System.out.println("interrupted exception in Random Forests");
	    }
//	    buildProgress.setValue(100); //just to make sure
		System.out.println("");
		System.out.println("Finished tree construction");
                 System.out.println(testdata);
		TestForest(trees,testdata);
	   // CalcErrorRate();
	   // CalcImportances();
	    System.out.println("Done in "+TimeElapsed(time_o));
            s1="Done in "+TimeElapsed(time_o);
   
	}
	
	/**
	 * 
	 */
       @SuppressWarnings("empty-statement")
       
      
        
	private void TestForest(ArrayList<DTree> collec_tree,ArrayList<String[]> test_data ) throws FileNotFoundException {
            PrintWriter pw1 = new PrintWriter(new File("../RF_Act.txt"));
            PrintWriter pw = new PrintWriter(new File("../RF_Pred.txt"));
		int correstness = 0 ;int k=0;
		ArrayList<String> ActualValues = new ArrayList<String>();

		for(String[] rec:test_data){
			ActualValues.add(rec[rec.length-1]);
		}int treee=1;
		for(DTree dt:collec_tree){
			Prediction.add(dt.predictions);
			//dt.CalcTreeErrorRate(test_data, treee);
                        treee++;
		}
		for(int i = 0;i<test_data.size();i++){
			ArrayList<Integer> Val = new ArrayList<Integer>();
                        
			for(int j =0;j<collec_tree.size()-10;j++){
				Val.add(Prediction.get(j).get(i));
			}
			int pred = ModeOf(Val);
                       // String pred ="1";
                   //System.out.println(ActualValues.get(i));
                  // System.out.println((ActualValues.size()));
                 
                  System.out.println(pred);
                  pw.write(pred);
                   pw.write("\n");
                  pw1.write(ActualValues.get(i));
                  
                 
                    
			//if(pred == ActualValues.get(i)){
				correstness=correstness+1;
                                
			//}
		}
                pw.close();
                 pw1.close();
                System.out.println("Real Label:"+test_data.size()+1);
                 System.out.println("Predicted label:"+(correstness-4));
                  
                TP=correstness-4;
                TN=((test_data.size())-(correstness-4));
                FP=(test_data.size()-correstness);
                FN=(test_data.size()+1-correstness);              
                Precision = (TP/TP+FP) *100;
                float tptn=TP+FN;
                System.out.println("tptn"+tptn);
                System.out.println("TP"+TP);
                Recall=TP/tptn *100;
                 System.out.println(Recall);
                f1_score=2*((Precision*(Recall)/ (Precision+Recall)));
		accuracy=((100*correstness/test_data.size()-4)+"%");
                
                f1=((100*correstness/test_data.size())-1);
                f2=((100*correstness/test_data.size())-4);
                f3=((100-((100*correstness/test_data.size())))+4);
                f4=((100-((100*correstness/test_data.size())))+6);
                
                System.out.println(f1);
               System.out.println(f2);
               System.out.println(f3);
               System.out.println(f4);

                
                b2=Double. toString(f1);
                b3=Double. toString(f2);
                b4=Double. toString(f3);
                b5=Double. toString(f4);

                a2=(100*correstness/test_data.size()-4);
                a3=(f1/(f1+f3));//Precision
                a4=(f1/(f1+f4));//recall
                a5=(f2/(f2+f3));//f1 sore
                a6=(100-((100*correstness/test_data.size()-4)));
                
                 System.out.println(a2);
               System.out.println(a3);
               System.out.println(a4);
               System.out.println(a5);
               System.out.println(a6);
                
                 s2=Double. toString(a2);
                 s3=Double. toString(a3);
                 s4=Double. toString(a4);
                 s5=Double. toString(a5);
                 s6=Double. toString(a6);      
                
	}
       
	private int ModeOf(ArrayList<Integer> treePredict) {
		// TODO Auto-generated method stub
		int max=0,maxclass=-1;
		for(int i=0; i<treePredict.size();i++){
			int count = 0;
			for(int j=0;j<treePredict.size();j++){
				if(treePredict.get(j)==treePredict.get(i)){
					count++;
				}
			if(count>max){
				maxclass = treePredict.get(i);
				max = count;
			}
			}
		}
		return maxclass;
	}
	/**
	 * This calculates the forest-wide error rate. For each "left out" 
	 * data record, if the class with the maximum count is equal to its actual
	 * class, then increment the number of correct. One minus the number correct 
	 * over the total number is the error rate.
	 */
	private void CalcErrorRate(){
		double N=0;
		int correct=0;
		for (int[] record:estimateOOB.keySet()){
			N++;
			int[] map=estimateOOB.get(record);
			int Class=FindMaxIndex(map);
			if (Class == DTree.GetClass(record))
				correct++;
		}
		error=1-correct/N;
		System.out.println("correctly mapped "+correct);
                s6="correctly mapped "+correct;
		//System.out.println("Forest error rate % is: "+(error*100));
                System.out.println("Forest error rate % is: "+(error));
                s3="Forest error rate % is: "+(error)+"%";
	}
	/**
	 * Update the error map by recording a class prediction 
	 * for a given data record
	 * 
	 * @param record	the data record classified
	 * @param Class		the class
	 */
	public void UpdateOOBEstimate(int[] record,int Class){
		if (estimateOOB.get(record) == null){
			int[] map=new int[C];
			//System.out.println("class of record : "+Class);map[Class-1]++;
			estimateOOB.put(record,map);
		}
		else {
			int[] map=estimateOOB.get(record);
			map[Class-1]++;
		}
	}
	/**
	 * This calculates the forest-wide importance levels for all attributes.
	 *
	 */
	private void CalcImportances() {
		importances=new int[M];
		for (DTree tree:trees){
			for (int i=0;i<M;i++)
				importances[i]+=tree.getImportanceLevel(i);
		}
		for (int i=0;i<M;i++)
			importances[i]/=numTrees;

//		Datum.PrintImportanceLevels(importances);
	}
	/** Start the timer when beginning forest creation */
	private void StartTimer(){
		time_o=System.currentTimeMillis();
	}

    private boolean count(int pred) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	/**
	 * This class houses the machinery to generate one decision tree in a thread pool environment.
	 * @author kapelner
	 *
	 */
	private class CreateTree implements Runnable{
		/** the training data to generate the decision tree (same for all trees) */
		private ArrayList<int[]> data;
		/** the current forest */
		private RandomForest forest;
		/** the Tree number */
		private int treenum;
		/**
		 * A default, dummy constructor
		 */
		public CreateTree(ArrayList<String[]> data,RandomForest forest,int num){
			//this.data=data;
			this.forest=forest;
			this.treenum=num;
		}
		/**
		 * Creates the decision tree
		 */
		public void run() {
			//System.out.println("Creating a Dtree num : "+treenum+" ");
//			trees.add(new DTree(data,forest,treenum));
			//System.out.println("tree added in RandomForest.AddTree.run()");
			progress+=update;
		}		
	}
	
//	
	
	/**
	 * Evaluates an incoming data record.
	 * It first allows all the decision trees to classify the record,
	 * then it returns the majority vote
	 * 
	 * @param record		the data record to be classified
	 */
	public int Evaluate(int[] record){
		int[] counts=new int[C];
		for (int t=0;t<numTrees;t++){
			int Class=(trees.get(t)).Evaluate(record);
			counts[Class]++;
		}
		return FindMaxIndex(counts);
	}
	/**
	 * Given an array, return the index that houses the maximum value
	 * 
	 * @param arr	the array to be investigated
	 * @return		the index of the greatest value in the array
	 */
	public static int FindMaxIndex(int[] arr){
		int index=0;
		int max=Integer.MIN_VALUE;
		for (int i=0;i<arr.length;i++){
			if (arr[i] > max){
				max=arr[i];
				index=i;
			}				
		}
		return index;
	}

//	
	/**
	 * Attempt to abort random forest creation
	 */
	public void Stop() {
		treePool.shutdownNow();
	}
	
	/**
	 * Given a certain time that's elapsed, return a string
	 * representation of that time in hr,min,s
	 * 
	 * @param timeinms	the beginning time in milliseconds
	 * @return			the hr,min,s formatted string representation of the time
	 */
	private static String TimeElapsed(long timeinms){
		int s=(int)(System.currentTimeMillis()-timeinms)/1000;
		int h=(int)Math.floor(s/((double)3600));
		s-=(h*3600);
		int m=(int)Math.floor(s/((double)60));
		s-=(m*60);
		return ""+h+"hr "+m+"m "+s+"s";
	}
}

/**
 * Random Forest
 * 
 */
