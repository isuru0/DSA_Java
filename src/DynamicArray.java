import java.util.Objects;

public class DynamicArray {
    ///DECLARE VARIABLES AND ARRAY
    int array_size, array_last_index;
    int max_size = 1000;
    Integer [] array_numbers;

    ///CONSTRUCTOR
    DynamicArray(int array_size) {
        this.array_size = array_size;
        this.array_numbers = new Integer[array_size];
        this.array_last_index = array_size - 1;
    }

    ///INSERT METHOD
    //EXTEND THE ARRAY
    void extendArray() {
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
    //INSERT IN ORDER
    void add(Integer value) {
        //TRAVEL AND INSERT
        for (int i = 0; i < array_size; i++) {
            if(array_numbers[i] == null) {
                array_numbers[i] = value;
                return;
            }
            else if(i == array_last_index) { //( && array_numbers[i] != null)
                int array_last_index_next = array_size;
                extendArray();
                array_numbers[array_last_index_next] = value;
                return;
            }
        }
    }
    //INSERT USING INDEX
    void add(int index, Integer value) {
        //FIND EXTEND SIZE
        int extend_size;
        if(array_size < max_size)
            extend_size = array_size * 2;
        else
            extend_size = array_size + array_size/4;
        //CHECK THE INDEX IS IN THE CURRENT ARRAY SIZE
        if(index < array_size) {
            if(array_numbers[index] == null) {
                array_numbers[index] = value;
                return;
            } else {
                System.out.println("The index is already filled.");
                return;
            }
        } else if(index < extend_size){
            for (int i = 0; i < array_size; i++) {
                if(array_numbers[i] == null) {
                    System.out.println("Current array still not full, please fill it.");
                    return;
                } else if(i == array_last_index) {
                    extendArray();
                    array_numbers[index] = value;
                    return;
                }
            }
        }
    }

    /// REMOVE METHOD
    void remove(){}

    /// SEARCH METHOD
    //SEARCH FOR VALUE IN GIVEN INDEX -> PRINT RESULT
    void searchIndexOf(int index) {
        System.out.println("Value of index " + index + ": " + array_numbers[index]);
    }
    //SEARCH FOR VALUE IN GIVEN INDEX -> GET RESULT
    public int getSearchIndexOf(int index) {
        return array_numbers[index];
    }
    //SEARCH FOR INDEX IN GIVEN VALUE -> PRINT RESULT
    void searchValueOf(Integer value) {
        System.out.print("Index of value " +value+ ": ");
        for(int i = 0; i < array_size; i++) {
            if(Objects.equals(value, array_numbers[i]))
                System.out.print(i + " ");
        }
        System.out.println();
    }
    //SEARCH FOR INDEX IN GIVEN VALUE -> GET RESULT
    Integer[] getSearchValueOf(Integer value) {
        int search_count = 0;
        Integer[] result = new Integer[array_size];
        for(int i = 0; i < array_size; i++) {
            if(Objects.equals(value, array_numbers[i])) {
                search_count++;
                result[search_count - 1] = i;
            }
        }
        return result;
    }

    /// UPDATE METHOD
    void update(){}

    /// PRINT METHOD
    //FIND CURRENT ARRAY SIZE
    int currentSize() {
        int array_current_size = 0;
        for (int i = array_last_index; i >= 0; i--) {
            if(array_numbers[i] != null) {
                array_current_size = i + 1;
                break;
            }
        }
        return array_current_size;
    }
    //PRINT CURRENT ARRAY
    void print() {
        System.out.print("Array: { ");  //PRI TEXT
        for(int i = 0; i < currentSize(); i++) {
            System.out.print(array_numbers[i] + " ");
        }
        System.out.print("}");  //POST TEXT
        System.out.println();
    }
    //PRINT ONLY VALUES
    void printOnlyValues() {
        System.out.print("Array: { ");  //PRE TEXT
        //ARRAY CONTENT
        for(int i = 0; i < currentSize(); i++){
            if(array_numbers[i] != null)
                System.out.print(array_numbers[i] + " ");
        }
        System.out.print("}");  //POST TEXT
        System.out.println();
    }

    public static void main(String[] args) {

        //CREATE & INSERT VALUES FOR ARRAY
        DynamicArray array_one = new DynamicArray(5);
        array_one.add(30);
        array_one.add(4);
        array_one.add(5);
        array_one.add(6);
        array_one.add(7);
        //array_one.add(55);
        //array_one.add(5,55);

        array_one.add(6,500);

        //PRINT THE ARRAY
        array_one.print();
        array_one.printOnlyValues();

        //SEARCH ELEMENTS FROM THE ARRAY
        System.out.println("-----------------");
        System.out.println("Get Search Result");
        System.out.println("-----------------");
        array_one.searchValueOf(55); //SEARCH AND PRINT INDEX
        Integer[] get_result = array_one.getSearchValueOf(55); //SEARCH AND GET INDEX
        for (Integer number: get_result) {
            if(number == null)
                break;
            System.out.println(number);
        }
        array_one.searchIndexOf(0);  //SEARCH AND PRINT VALUE
        System.out.println(array_one.getSearchIndexOf(0));  //SEARCH AND GET VALUE
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
