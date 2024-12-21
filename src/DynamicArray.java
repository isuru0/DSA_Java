import java.util.Objects;

public class DynamicArray {
    ///DECLARE VARIABLES AND ARRAY
    int array_size, array_last_index;
    int max_size = 1000;
    int min_size = 5;
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
    void shrink() {
        if(currentSize() == array_size/2) {
            //CRETE TEMPORARY ARRAY AND COPY ELEMENTS FORM EXITING ARRAY
            Integer[] temp_array_numbers = new Integer[array_size];
            for(int i = 0; i < array_size; i++) {
                temp_array_numbers[i] = array_numbers[i];
            }
            //RESIZE
            array_size = array_size/2 ;
            //REASSIGN
            array_numbers = new Integer[array_size];
            for(int i = 0; i < array_numbers.length; i++) {
                array_numbers[i] = temp_array_numbers[i];
            }
            temp_array_numbers = null;
            array_last_index = array_size -1;
        }
    }
    //REMOVE IN ORDER
    void remove(){
        int current_size = currentSize();
        if(current_size != 0) {
            array_numbers[current_size - 1] = null;
        } else {
            System.out.println("Array is already empty");
        }
        if(array_size > min_size)
            shrink();
    }
    //REMOVE USING INDEX
    void remove(int index) {
        if(index < array_size) {
            if(array_numbers[index] != null) {
                array_numbers[index] = null;
            } else
                System.out.println("The index is already empty.");
        } else
            System.out.println("The index is not in the array range.");
        if(array_size > min_size)
            shrink();
    }

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
    void update(int index, Integer value){
        if(index < currentSize()) {
            if (array_numbers[index] != null) {
                array_numbers[index] = value;
            } else {
                System.out.println("The index not filled.");
            }
        } else {
            System.out.println("The index not excite.");
        }
    }

    /// PRINT METHOD
    //FIND CURRENT ARRAY SIZE
    int currentSize() {
        int array_current_size = 0;
        for (int i = array_last_index; i >= 0; i--) {
            if(array_numbers[i] != null) {
                array_current_size = i + 1;
                break;
            } else {
                array_current_size = i;
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
        //INSERT VALUES
        System.out.println("----------------------------------");
        System.out.println("* Insert values with 3 methods *");
        System.out.println("01: Order insert");
        array_one.add(100);
        System.out.println("02: With index insert");
        array_one.add(1,4);
        System.out.println("03: Using loop");
        for(int i = 0; i < 3; i++) {
            array_one.add(i + 10);
        }
        array_one.add(6,4);
        array_one.print();
        System.out.println("----------------------------------");
        //PRINT THE ARRAY
        System.out.println("----------------------------------");
        System.out.println("* Print values with 2 methods *");
        System.out.println("01: Print all until inserted last element");
        array_one.print();
        System.out.println("02: Print only values");
        array_one.printOnlyValues();
        System.out.println("----------------------------------");
        //SEARCH ELEMENTS FROM THE ARRAY
        System.out.println("----------------------------------");
        System.out.println("* Search values and index with 2 methods *");
        System.out.println("01: Search using values");
        array_one.searchValueOf(11); //SEARCH AND PRINT INDEX
        Integer[] get_result = array_one.getSearchValueOf(55); //SEARCH AND GET INDEX
        for (Integer number: get_result) {
            if(number == null) {
                break;
            }
            System.out.println(number);
        }
        System.out.println("02: Search using index ");
        array_one.searchIndexOf(0);  //SEARCH AND PRINT VALUE
        int search_value = array_one.getSearchIndexOf(0);  //SEARCH AND GET VALUE
        array_one.print();
        System.out.println("----------------------------------");

        //UPDATE ELEMENTS
        System.out.println("----------------------------------");
        System.out.println("* Update a value *");
        array_one.update(6, 1000);
        array_one.print();
        System.out.println("----------------------------------");

        //REMOVE ELEMENTS
        System.out.println("----------------------------------");
        System.out.println("* Remove a value with 2 methods *");
        System.out.println("01: Order remove");
        array_one.remove();
        array_one.print();
        System.out.println("02: With index remove");
        array_one.remove(2);
        array_one.print();
        System.out.println("----------------------------------");
    }
}

