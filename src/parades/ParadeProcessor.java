package parades;

public class ParadeProcessor {

	private char[] word1;
	private char[] word2;
	private int[] last1;
	private int[] last2;
	private int[][] matrixSize;
	private int[][] matrixRule;

	public ParadeProcessor(char[] w1,char[]  w2) {
		this.word1 = w1;
		this.word2 = w2; 
		last1 = new int[w1.length];
		last2 = new int[w2.length];
		createMatriesx();
	}

	public char findAt(int pos, char[] word) {
		return word[pos];
	}

	public void insertRule(int i, int j) {
		
	}
	
	public String getFinalWord() {
		int i = 0;
		int j = 0;
		int wordLenth = 0;
		String word = "";
		while (wordLenth < getMaxWordLength())
				if (matrixRule[i][j] == 1) {
					word += findAt(i, word1);
					//System.out.println(word);
					wordLenth++;
					i+=1;
					j+=1;
				}
				else if (matrixRule[i][j] == 2) {
					j+=1;
				}
				else if(matrixRule[i][j] == 3){
					i+=1;
				}
				else if(matrixRule[i][j] == 4) {
					/*
					if(matrixRule[i+1][j] == 4) {
						i++;
					}
					else if(matrixRule[i][j+1] == 4) {
						j++;
					}
					*/
					
					
					if(findAt(i, word1) < findAt(j, word2)) {
						if(last1[i] > j )
							j++;
						else if (last2[j] > i)
							i++;
						else {
							i++;
							j++;
						}
					}
					else{
						if(last2[j] > i )
							i++;
						else if(last1[i] > j) 
							j++;
						else {
							i++;
							j++;
						}
							
					}
					
					
					/*
					if(last1[i] > j )
						j++;
					else if (last2[j] > i)
						i++;
					else {
						i++;
						j++;
					}
					*/
					
				}
				else
					System.out.println("error");
				
		
					return word;
	}
	
	public int getMaxWordLength() {
		return matrixSize[0][0];
	}
	
	public void printMatrixSize() {
		System.out.print(" ");
		System.out.println(word2);
		for (int i = 0 ; i < word1.length ; i++) {
			System.out.print(findAt(i, word1));
			for (int j = 0 ; j < word2.length ; j++)		
				System.out.print(matrixSize[i][j]);
			System.out.println("");
		}
	}
	
	public void printMatrixRule() {
		System.out.print(" ");
		System.out.println(word2);
		for (int i = 0 ; i < word1.length ; i++) {
			System.out.print(findAt(i, word1));
			for (int j = 0 ; j < word2.length ; j++)		
				System.out.print(matrixRule[i][j]);
			System.out.println("");
		}
		
	}

	
	public int maxOf(char a, char b) {
		if (a<=b)
			return 2;
		else 
			return 3;
	}


	public void createMatriesx(){
		//Matrix has size length w1 + length w2
		matrixSize = new int [word1.length+1][word2.length+1];
		matrixRule= new int [word1.length+1][word2.length+1];

		for (int i = word1.length -1 ; i >=0 ; i--) {
			for (int j = word2.length -1 ; j >=0 ; j--) {
				
				if (findAt(i , word1) == findAt(j, word2)) {
					if (last1[i] < j)
						last1[i]=j;
					if (last2[j] < i)
						last2[j]=i;
					matrixSize[i][j]= 1+ matrixSize[i+1][j+1];
					matrixRule[i][j]=1;
				}
				
				else {
					
					if (matrixSize[i][j+1] > matrixSize[i+1][j]) {
						matrixSize[i][j]= matrixSize[i][j+1];
						matrixRule[i][j]= 2;
					}
					
					else if (matrixSize[i][j+1] < matrixSize[i+1][j]) {
						matrixSize[i][j]= matrixSize[i+1][j];
						matrixRule[i][j]= 3;
					}
					
					else {
						matrixSize[i][j]= matrixSize[i+1][j];
						matrixRule[i][j]= 4;
						//matrixRule[i][j]= maxOf( findAt(i, word1),  findAt(j, word2));
						//matrixSize[i][j]= matrixSize[i+1][j];
					}
						
				}
			}
		}

		//printMatrixSize();
		
	}
	
	
	
	
	

}
