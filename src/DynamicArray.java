public class DynamicArray {
    //DECLARE VARIABLES AND ARRAY
    int array_size, array_last_index, index_count;
    int max_size = 1000;
    Integer [] array_numbers;

    ///CONSTRUCTOR
    DynamicArray(int array_size) {
        this.array_size = array_size;
        this.array_numbers = new Integer[array_size];
        this.array_last_index = array_size - 1;
        this.index_count = 0;
    }

    ///INSERT METHOD
    void add(int value) {
        //CHECK ARRAY IS EMPTY OR NOT
        if(array_numbers[array_last_index] != null) {
            //CRETE TEMPORARY ARRAY AND COPY ELEMENTS FORM EXITING ARRAY
            Integer[] temp_array_numbers = new Integer[array_size];
            for (int i = 0; i < array_size; i++) {
                temp_array_numbers[i] = array_numbers[i];
            }
            //RESIZE AND REASSIGN THE VALUES
            //RESIZE
            if(array_size < max_size)
                array_size = array_size * 2;
            else
                array_size = array_size + array_size/4;
            //REASSIGN
            array_numbers = new Integer[array_size];
            for (int i = 0; i < temp_array_numbers.length; i++) {
                array_numbers[i] = temp_array_numbers[i];
            }
            temp_array_numbers = null;
            array_last_index = array_size -1;
        }
        //INSERT THE VALUE
        array_numbers[index_count] = value;
        index_count++;

        /*
        //TRAVEL AND INSERT
        for (int i = 0; i < array_size; i++) {
            if(array_numbers[i] == null) {
                array_numbers[i] = value;
                return;
            }
        }
         */
    }

    /// REMOVE METHOD
    /// SEARCH METHOD
    /// UPDATE METHOD
    /// PRINT METHOD

    public static void main(String[] args) {

        DynamicArray array_one = new DynamicArray(5);
        array_one.add(30);
        array_one.add(4);
        array_one.add(5);
        array_one.add(6);
        array_one.add(7);
        array_one.add(55);
        array_one.add(30);
        array_one.add(4);
        array_one.add(5);
        array_one.add(6);
        array_one.add(7);
        array_one.add(55);

        for(Integer number: array_one.array_numbers)
            System.out.print(number + " ");

    }
}



//        //DECLARE AND INITIAL A INTEGER ARRAY
//        int memory_size = 10;
//        int [] array_numbers = new int[memory_size];
//
//        int size = 5;                                        //DECIDED SIZE OF ARRAY
//        int array_length = array_numbers.length;             //LENGTH OF ARRAY
//        int array_last_element_index = array_length - 1;     //INDEX OF LAST ELEMENT
//
//        //INITIAL VALUES INTO ARRAY
//        array_numbers[0] = 10;
//        array_numbers[1] = 20;
//        array_numbers[2] = 30;
//        array_numbers[3] = 40;
//        array_numbers[4] = 50;
//
//        System.out.print("Elements of Array: ");
//        for(int i=0; i<size; i++) {
//            System.out.print(array_numbers[i] +" ");
//        }
//
//        System.out.println();
//        System.out.println();
//
//        //UPDATE VALUE OF ARRAY
//        System.out.println("* Update Operation *");
//        int update_index = 2;
//        int update_value = 35;
//        array_numbers[update_index] = update_value;
//
//        System.out.print("Elements of Updated Array: ");
//        for(int i=0; i<size; i++) {
//            System.out.print(array_numbers[i] +" ");
//        }
//        System.out.println();
//        System.out.println();
//
//        //INSERT VALUE OF ARRAY
//        System.out.println("* Insert Operation *");
//        int insert_index = 2;
//        int insert_value = 25;
//        size++;
//        for(int i=size; i>=insert_index; i--) {
//            if(i == insert_index) {
//                array_numbers[insert_index] = insert_value;
//                break;
//            } else {
//                array_numbers[i] = array_numbers[i - 1];
//            }
//        }
//
//        System.out.print("Elements of Inserted Array: ");
//        for(int i=0; i<size; i++) {
//            System.out.print(array_numbers[i] +" ");
//        }
//        System.out.println();
//        System.out.println();
//
//        //DELETE VALUE OF ARRAY
//        System.out.println("* Delete Operation *");
//        int delete_index = 2;
//        for(int i=delete_index; i<=size; i++) {
//            array_numbers[i] = array_numbers[i+1];
//        }
//        size--;
//
//        System.out.print("Elements of Inserted Array: ");
//        for(int i=0; i<size; i++) {
//            System.out.print(array_numbers[i] +" ");
//        }
//        System.out.println();
//        System.out.println();
//
//        //SEARCH VALUE OF ARRAY
//        System.out.println("* Search Operation *");
//        int search_value = 35;
//        boolean found = false;
//        int search_index;
//        for(int i=0; i<size; i++) {
//            if(array_numbers[i] == search_value) {
//                found = true;
//                search_index = i;
//                break;
//            }
//        }
//        if(found)
//            System.out.println("Found the value");
//        else
//            System.out.println("The value is not here!");
//        System.out.println();
//
//        //PRINT THE ARRAY WAY 01
//        System.out.println("* Elements of Array *");
//        for(int i=0; i<array_length; i++) {
//            System.out.println("Index " +i +": " +array_numbers[i]);
//        }
//
//        /*
//        //PRINT THE ARRAY WAY 02
//        for(int number: array_numbers) {
//            System.out.println(array_numbers[number]);
//        }
//        */
//
