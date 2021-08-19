package memoryAllocation;
import  java.util.*;


class memory{
	  
	void fisrtFit(int block[], int m, int process[],  int n) {
		 
		// Stores block id of the 
        // block allocated to a process
        int allocation[] = new int[n];
       // boolean used[];
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++) {
    		visited[i] = false;
        }
    	
      
        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
      
        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (block[j] >= process[i])
                {
                	
                    // allocate block number j to p[i] process
                    allocation[i] = j;
      
                    // Reduce available memory in this block.
                    //block[j] -= process[i];
                    
                   block[j]=0;
      
                    break;
                	}
                	
                
                
            }
        }
      
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++)
        {
            System.out.print(" " + (i+1) + "\t\t" + 
                             process[i+1] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
		
	}
	
	void bestFit(int block[], int m, int process[],  int n) {
		

        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[n];
       
        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
       
     // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i=0; i<n; i++)
        {
            // Find the best fit block for current process
            int bestIdx = -1;
            for (int j=0; j<m; j++)
            {
                if (block[j] >= process[i])
                {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (block[bestIdx] > block[j])
                        bestIdx = j;
                }
            }
       
            // If we could find a block for current process
            if (bestIdx != -1)
            {
                // allocate block j to p[i] process
                allocation[i] = bestIdx;
       
                // Reduce available memory in this block.
                block[bestIdx] -= process[i];
                
               // block[bestIdx]=0;
            }
        }
       
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++)
        {
            System.out.print("   " + (i+1) + "\t\t" + process[i+1] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    
		
	}
	
	void worstFit(int block[], int m, int process[],  int n) {
		
		  // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[n];
       
        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
       
        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i=0; i<n; i++)
        {
            // Find the best fit block for current process
            int wstIdx = -1;
            for (int j=0; j<m; j++)
            {
                if (block[j] >= process[i])
                {
                    if (wstIdx == -1)
                        wstIdx = j;
                    else if (block[wstIdx] < block[j])
                        wstIdx = j;
                }
            }
       
            // If we could find a block for current process
            if (wstIdx != -1)
            {
                // allocate block j to p[i] process
                allocation[i] = wstIdx;
       
                // Reduce available memory in this block.
                block[wstIdx] -= process[i];
                //block[wstIdx] =0;
            }
        }
       
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++)
        {
            System.out.print("   " + (i+1) + "\t\t" + process[i+1] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
		
	}
	
}





public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		memory M=new memory();
		
		  int[] block=new int[10];
		  int[] process=new int[10];
		  int m,n,id1,id2;
			
			System.out.println("Enter the number of memory blocks available: ");
			m=sc.nextInt();
			for(int i=0;i<m;i++) {
				System.out.println("Enter the block id");
				id1=sc.nextInt();
				System.out.println("Enter the size of block "+id1+" in KB");
				block[id1]=sc.nextInt();
			}
		
			System.out.println("Enter number of processes available: ");
			n=sc.nextInt();
			for(int j=0;j<n;j++) {
				System.out.println("Enter the process id");
				id2=sc.nextInt();
				System.out.println("Enter the size of process "+id2+" in KB");
				process[id2]=sc.nextInt();
			}
		
		
		int no;
		do{
			System.out.println("\n*********************");
			System.out.println("MENU:\n1. FIRST FIT STRATEGY\n2. BEST FIT STRATEGY\n3. WORST FIT STRATEGY\n4. EXIT ");
			System.out.println("*********************");
			System.out.println("\nEnter your choice: ");
			no=sc.nextInt();
			

			switch(no){
			case 1:
				M.fisrtFit(block,m,process,n);
			break;
			
			case 2:
				M.bestFit(block, m, process, n);
			break;
			
			case 3:
				M.worstFit(block, m, process, n);
			break;
			
			case 4:
			break;
			
			default:
				System.out.println("INVALID CHOICE!");
			break;
				
			}
			}while(no!=4);	
	}

}
