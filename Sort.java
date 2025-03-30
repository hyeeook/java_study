public class Sort
{
	public static void main(String[] args)
	{
		int[] intArr = {4, 2, 9, 5, 0, 3, 8, 1, 6, 7};
		int tmpVal = 0;	//자리 교체를 위한 변수
		int tgtIdx = 0;	//최소(최대) 값의 인덱스
		
//		selectionSort(intArr, tgtIdx, tmpVal);	//선택 정렬
//		bubbleSort(intArr, tmpVal);				//버블 정렬
		insertionSort(intArr, tmpVal);			//삽입 정렬
	}
	
	//선택 정렬 : 최소(최대) 값을 선택하여 먼저 정렬 처리
	public static void selectionSort(int[] intArr, int tgtIdx, int tmpVal)
	{
		
		for(int i=0; i<intArr.length; i++)
		{
			tgtIdx = i;	//맨 앞의 인덱스를 최소 값의 인덱스로 임시 지정
			
			for(int j=i+1; j<10; j++)	//맨 앞의 인덱스의 다음 인덱스부터 반복문을 돌며 크기 비교
			{
				if(intArr[j] < intArr[tgtIdx])	//현재의 최소 값보다 더 작은 값이 있는 경우
				{
					tgtIdx = j;	//최소 값의 인덱스를 변경
				}
			}
			
			//정렬 처리
			tmpVal = intArr[i];
			intArr[i] = intArr[tgtIdx];
			intArr[tgtIdx] = tmpVal;
		}
		
		printResultOfSort(intArr, "선택 정렬");	//정렬 결과 출력
	}
	
	//버블 정렬 : 바로 옆의 값과 크기를 비교하여 정렬 처리
	public static void bubbleSort(int[] intArr, int tmpVal)
	{
		for(int i=0; i<intArr.length; i++)
		{
			for(int j=0; j<intArr.length-i-1; j++)
			{
				if(intArr[j] > intArr[j+1])
				{
					tmpVal = intArr[j];
					intArr[j] = intArr[j+1];
					intArr[j+1] = tmpVal;
				}
			}
		}
		
		printResultOfSort(intArr, "버블 정렬");
	}
	
	//삽입 정렬 : 적당한 자리에 넣어서 정렬 처리
	public static void insertionSort(int[] intArr, int tmpVal)
	{
		for(int i=1; i<intArr.length; i++)
		{
			for(int j=i; j>0; j--)
			{
				if(intArr[j] < intArr[j-1])
				{
					tmpVal = intArr[j];
					intArr[j] = intArr[j-1];
					intArr[j-1] = tmpVal;
				}
			}
		}
		
		printResultOfSort(intArr, "삽입 정렬");
	}
	
	//정렬 결과 출력
	public static void printResultOfSort(int[] intArr, String sortMethod)
	{
		String outputSort = "";
		
		for(int i=0; i<intArr.length; i++)
		{
			outputSort += " " + intArr[i]; 
		}
		
		System.out.println(sortMethod);
		System.out.print(outputSort.trim());
		System.out.println();
		System.out.println();
	}
}
