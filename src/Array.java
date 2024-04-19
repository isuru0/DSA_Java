public class Array {
    public static void main(String[] args) {

        //DECLARE AND INITIAL A INTEGER ARRAY
        int [] array_numbers = new int[10];

        int size = 5;                                        //DECIDED SIZE OF ARRAY
        int array_length = array_numbers.length;             //LENGTH OF ARRAY
        int array_last_element_index = array_length - 1;     //INDEX OF LAST ELEMENT

        //INITIAL VALUES INTO ARRAY
        array_numbers[0] = 10;
        array_numbers[1] = 20;
        array_numbers[2] = 30;
        array_numbers[3] = 40;
        array_numbers[4] = 50;

        System.out.print("Elements of Array: ");
        for(int i=0; i<size; i++) {
            System.out.print(array_numbers[i] +" ");
        }
        System.out.println();
        System.out.println();

        //UPDATE VALUE OF ARRAY
        System.out.println("* Update Operation *");
        int update_index = 2;
        int update_value = 35;
        array_numbers[update_index] = update_value;

        System.out.print("Elements of Updated Array: ");
        for(int i=0; i<size; i++) {
            System.out.print(array_numbers[i] +" ");
        }
        System.out.println();
        System.out.println();

        //INSERT VALUE OF ARRAY
        System.out.println("* Insert Operation *");
        int insert_index = 2;
        int insert_value = 25;
        size++;
        for(int i=size; i>=insert_index; i--) {
            if(i == insert_index) {
                array_numbers[insert_index] = insert_value;
                break;
            } else {
                array_numbers[i] = array_numbers[i - 1];
            }
        }

        System.out.print("Elements of Inserted Array: ");
        for(int i=0; i<size; i++) {
            System.out.print(array_numbers[i] +" ");
        }
        System.out.println();
        System.out.println();

        //DELETE VALUE OF ARRAY
        System.out.println("* Delete Operation *");
        int delete_index = 2;
        for(int i=delete_index; i<=size; i++) {
            array_numbers[i] = array_numbers[i+1];
        }
        size--;

        System.out.print("Elements of Inserted Array: ");
        for(int i=0; i<size; i++) {
            System.out.print(array_numbers[i] +" ");
        }
        System.out.println();
        System.out.println();

        //SEARCH VALUE OF ARRAY
        System.out.println("* Search Operation *");
        int search_value = 35;
        boolean found = false;
        int search_index;
        for(int i=0; i<size; i++) {
            if(array_numbers[i] == search_value) {
                found = true;
                search_index = i;
                break;
            }
        }
        if(found)
            System.out.println("Found the value");
        else
            System.out.println("The value is not here!");
        System.out.println();

        //PRINT THE ARRAY WAY 01
        System.out.println("* Elements of Array *");
        for(int i=0; i<array_length; i++) {
            System.out.println("Index " +i +": " +array_numbers[i]);
        }

        /*
        //PRINT THE ARRAY WAY 02
        for(int number: array_numbers) {
            System.out.println(array_numbers[number]);
        }
        */


    }
}
