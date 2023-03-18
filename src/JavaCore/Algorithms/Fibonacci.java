public class Fibonacci {

//    =========== ЧИСЛО ФИБОНАЧИ ИТЕРАТИВНО================
    public static int fibIterate(int arg) {
        int [] data = new int[arg + 1];
        data[0] = 0;
        data[1] = 1;
        for (int k = 2; k < data.length ; k++) {
            data[k] =  data[k - 2] + data[k - 1];
        }
        return data[arg];
    }

//    ============= ЧИСЛО ФИБОНАЧЧИ РЕКУРСИВНО===============
    public static int fibRecurs(int arg) {
       if (arg == 0) {
           return 0;
       }
       if (arg == 1) {
           return 1;
       } else return fibRecurs(arg -2) + fibRecurs(arg -1);
    }

//     ============= ЧИСЛО ФИБОНАЧЧИ В ОДНУ СТРОЧКУ============
    public static int fibIn1Row(int arg) {
        return (arg < 2) ? arg : fibIn1Row(arg - 2) + fibIn1Row(arg - 1);
    }

}
