/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachesimulator;

/**
 *
 * @author parth
 */


import java.util.Scanner;



public class CacheSimulator {

    //initialize variable
    static int Read_Misses = 0;
    static int Read_Hits = 0;
    static int Write_Misses = 0;
    static int Write_Hits = 0;
    static int[][] Array_Stored_Memory;
    static int[][] Array_Stored_Cache;

    //method to initialize memory
    static int[][] InitializeMemory() {

        int array_stored_Memory[][] = {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
            {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35},
            {30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45},
            {40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55},
            {50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65},
            {60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75},
            {70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85},
            {80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95},
            {90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105},
            {100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115},
            {110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125},
            {120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135},
            {130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145},
            {140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155},
            {150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165}

        };
        return array_stored_Memory;
    }

    //method to initialize cache
    static int[][] InitializeCache() {

        int array_stored_Cache[][] = {
            {0, 1, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 1, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 1, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, -99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

        };

        return array_stored_Cache;
    }

    //Method to read from memory to cache
    static void ReadFromMemoryToCache(int block_Number, int offset, int valid_bit) {

        //increment read miss variable for counting
        Read_Misses++;

        //check value enter by user
        if (block_Number > 15 || block_Number < 0) {
            System.out.println("Enter Proper values");
            System.exit(0);
        }

        //check value enter by user
        if (offset > 15 || offset < 0) {
            System.out.println("Enter Proper values");
            System.exit(0);
        }

        //check value enter by user
        if (valid_bit > 1 || valid_bit < 0) {
            System.out.println("Enter Proper values");
            System.exit(0);
        }

        System.out.println("get_cpu_action(); action = READ, block :" + block_Number + ", offset :" + offset);
        System.out.println("cache read miss block [" + block_Number + "] offset[" + offset + "] [" + valid_bit + "]");

        int offSet_temp = 0;
        for (int counter = 0; counter < 16; counter++) {
            if (valid_bit == 0) {
                offSet_temp = offset * 2 + 1;
                Array_Stored_Cache[offSet_temp][counter + 3] = Array_Stored_Memory[block_Number][counter];
            } else {
                offSet_temp = offset * 2 + 0;
                Array_Stored_Cache[offSet_temp][counter + 3] = Array_Stored_Memory[block_Number][counter];
            }
        }
        Array_Stored_Cache[offSet_temp][2] = block_Number;
    }

    //method to write to memory
    static void WriteToMemory(int block_Number, int offSet, int value) {

        //increment write miss variable for counting
        Write_Misses++;

        //write value to memory
        Array_Stored_Memory[block_Number][offSet] = value;
    }

    //method to printing memory
    static void Print_Memory(int arr_M[][]) {

        System.out.println("Printing Memory...");
        System.out.println("=============================== Main Memorey ===============================");
        for (int counter_i = 0; counter_i < 16; counter_i++) {
            for (int counter_j = 0; counter_j < 16; counter_j++) {
                System.out.print(Array_Stored_Memory[counter_i][counter_j] + "  ");
            }
            System.out.println();
        }
    }

    //method  to print cache
    static void Print_Cache(int arr_C[][]) {

        System.out.println("Printing Cache...");
        System.out.println("=============================== Cache Memorey ===============================");

        for (int counter_i = 0; counter_i < 8; counter_i++) {
            for (int counter_j = 0; counter_j < 19; counter_j++) {

                if (counter_j == 0) {
                    System.out.print("Set = " + Array_Stored_Cache[counter_i][counter_j] + "  ");
                } else if (counter_j == 1) {
                    System.out.print("V = " + Array_Stored_Cache[counter_i][counter_j] + "  ");
                } else if (counter_j == 2) {
                    System.out.print("Tag = " + Array_Stored_Cache[counter_i][counter_j] + "  ");
                } else {
                    System.out.print(Array_Stored_Cache[counter_i][counter_j] + "  ");
                }
            }
            System.out.println();
        }
    }

    //method to printing cache write performance
    static void PrintCachePerformance() {
       
        System.out.println("Write Misses output: " + Write_Misses);
        System.out.println("Write Hits output : " + Write_Hits);
        System.out.println("Cache output ");
    }

    //method to printing cache read performance
    static void PrintCachePerform() {
         System.out.println("------------------------------------------------------------------------------");
        System.out.println("Read Misses output : " + Read_Misses);
        System.out.println("Read Hits output: " + Read_Hits);
    }

    static void Quit() {
        System.out.println("Quit....");
    }

    //main method
    public static void main(String[] args) {

        //initialize variable
        String choice_option;
        int block_Number;
        int offset;
        int valid_bit;
        int value;

        //initialize memory and cache
        Array_Stored_Memory = InitializeMemory();
        Array_Stored_Cache = InitializeCache();

        //print cache write performance
        PrintCachePerformance();

        //print memory and cache
        Print_Memory(Array_Stored_Memory);
        Print_Cache(Array_Stored_Cache);

        //print cache read performance
        PrintCachePerform();
        Print_Memory(Array_Stored_Memory);
        Print_Cache(Array_Stored_Cache);

        //initialize scanner object to read input from user
        Scanner scan_read = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Enter choice between [0] to [2]:");
            System.out.println("Enter [0] to read from memory:");
            System.out.println("Enter [1] to write to memory:");
            System.out.println("Enter [2] to quit:");

            //read choice enter by user
            choice_option = scan_read.nextLine();
            System.out.println("You entered string value: " + choice_option);

            if (choice_option.equals("0")) {

                System.out.println("Reading from Memory");

                //Get Block number from user
                System.out.println("Enter Block Number:[Values from 0 to 15]");
                block_Number = Integer.parseInt(scan_read.nextLine());

                //Get OffSet number from user
                System.out.println("Enter OffSet Number:[Values from 0 to 15]");
                offset = Integer.parseInt(scan_read.nextLine());

                //Get VoidBit number from user
                System.out.println("Enter ValidBit Number:[Value 0 or 1]");
                valid_bit = Integer.parseInt(scan_read.nextLine());

                ReadFromMemoryToCache(block_Number, offset, valid_bit);
                PrintCachePerformance();
                PrintCachePerform();
                Print_Memory(Array_Stored_Memory);
                Print_Cache(Array_Stored_Cache);

            } else if (choice_option.equals("1")) {

                System.out.println("Writing To Memory");
                //Getting inputs from user (Block number, Offset number and voideBit number)
                System.out.println("Enter Block No:[Values from 0 to 15]");
                block_Number = Integer.parseInt(scan_read.nextLine());

                System.out.println("Enter offSetNo No:[Values from 0 to 15]");
                offset = Integer.parseInt(scan_read.nextLine());

                System.out.println("Enter validBit No:[Value from 0 or 1]");
                value = Integer.parseInt(scan_read.nextLine());
                WriteToMemory(block_Number, offset, value);
                PrintCachePerformance();
                PrintCachePerform();
                Print_Memory(Array_Stored_Memory);
                Print_Cache(Array_Stored_Cache);

            } else if (choice_option.equals("2")) {

                System.out.println("Quitting");
                Quit();
                System.exit(0);

            } else {
                System.out.println("Enter proper choice or values");
            }
        }

    }
}
