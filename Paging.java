import java.util.Scanner;

public class Paging {

    static final int MEMORY_SIZE = 100;  
    static final int PAGE_SIZE = 10;    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numFrames = MEMORY_SIZE / PAGE_SIZE;

        System.out.print("Enter the number of pages: ");
        int numPages = scanner.nextInt();

        if (numPages > MEMORY_SIZE) {
            System.out.println("The number of pages exceeds total memory size.");
            return;
        }

        int[] pageTable = new int[numPages];
        for (int i = 0; i < numPages; i++) {
            pageTable[i] = -1; 
        }

        int[] memory = new int[MEMORY_SIZE];
        for (int i = 0; i < MEMORY_SIZE; i++) {
            memory[i] = -1; 
        }

        for (int i = 0; i < numPages && i < numFrames; i++) {
            pageTable[i] = i;  
            memory[i] = i;     
        }

        System.out.println("\nPage Table (Page -> Frame):");
        for (int i = 0; i < numPages; i++) {
            System.out.println("Page " + i + " -> Frame " + pageTable[i]);
        }

        System.out.print("\nEnter a logical address (page number and offset): ");
        int logicalPage = scanner.nextInt();
        int offset = scanner.nextInt();

        if (logicalPage >= numPages) {
            System.out.println("Invalid page number.");
        } else {
            int frameNumber = pageTable[logicalPage];
            if (frameNumber == -1) {
                System.out.println("Page not loaded in memory.");
            } else {
                int physicalAddress = frameNumber * PAGE_SIZE + offset;
                if (offset >= PAGE_SIZE) {
                    System.out.println("Invalid offset.");
                } else {
                    System.out.println("Physical address: " + physicalAddress);
                }
            }
        }

        System.out.println("\nNumber of frames in memory: " + numFrames);

        scanner.close();
    }
}
