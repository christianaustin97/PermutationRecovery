package permutationrecovery;
import java.util.*;

public class PermutationRecovery {
    public static void main(String[] args) {              
        
        Scanner input = new Scanner(System.in);        
        
        int n;//size of permutation        
        System.out.println("Please enter the size of your permutation n: ");
        n = input.nextInt();
        
        //this array contains out current, always-updated "guess" for the original permutation. 
        int[] permutation = new int[n];
        for (int i=0; i<n; i++){
            permutation[i]=0; //initialize all to 0
        }
        
        //get inputs from user
        int[] permutationSubscripts = new int[n];
        System.out.println("For 1 to n, please enter a_1 followed by 'Enter',\n\tthen a_2 followed by 'Enter'... ");
        for (int j=0; j<n; j++){
            permutationSubscripts[j] = input.nextInt();
        }
        System.out.println("Permutation subscripts:\n"+Arrays.toString(permutationSubscripts)+"\n");
        System.out.println("Thank you!\n");
        
        //This comment was inserted randomly by the creator:
        //Christian Austin. Have a great day
        
        int index;
        for(int k=0; k<n; k++){
            index = getEmptySlot(permutation, (permutationSubscripts[k]+1)); //get the (k+1)th empty slot
            
            System.out.println("The (" + permutationSubscripts[k] + "+1)th empty slot is"
                    + " currently at index " + index);
            
            permutation[index] = k+1;//put k+1 in the (index+1)th empty slot  
             
            //System.out.println("Inserting " + (k+1) + " \n" + Arrays.toString(permutation) + "\n");           
        }   
        
        System.out.println("Here is your original permutation: ");
        System.out.println(Arrays.toString(permutation));
    }   
    
    public static int getEmptySlot(int[] array, int slot){
        int counter=0; 
        
        for(int j=0; j<array.length; j++){
            if(array[j]==0){ //if this one is empty
                if(slot==1)
                    return j;//if it's the first empty slot, return j
                else{
                    counter++;//we found another empty slot
                    if(counter==slot)
                        return j; //return the index of needed empty slot (ex, 4th empty slot might be at position j=7)
                }
            }                    
        }
        return -1;//if it wants an empty slot, but there isn't one, return -1. Something went wrong, probably the input was entered incorrectly   
    }   
}
