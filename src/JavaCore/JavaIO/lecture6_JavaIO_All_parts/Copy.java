package JavaCore.JavaIO.lecture6_JavaIO_All_parts;

import java.io.*;

public class Copy {

    public static void main(String[] args) throws IOException {
        byte [] data = {'H', 'e', 'l', 'l','o'};
        InputStream in = new ByteArrayInputStream(data); // ByteArrayInputStream - адаптер который превращает массив байтов в InputStream
        OutputStream out = new FileOutputStream("c:/Hello.txt"); // FileOutputStream - адаптер файла к OutPutStream
        copy(in,out);
    }

//    private static void copy(InputStream in, OutputStream out) throws IOException {
//        while (true) {
//            int read = in.read();
//            if (read == -1) {
//                break;
//            } else {
//                out.write(read);
//            }
//        }
//        in.close();
//        out.flush(); // буферизация
//        out.close();
//    }

    //===========================БУФЕРИЗАЦИЯ=======================

//    private static void copy(InputStream in, OutputStream out) throws IOException {
//        byte [] buff = new byte[256];
//        while (true) {
//            int count = in.read(buff);
//            if (count == -1) {
//                break;
//            } else {
//                out.write(buff,0,count);
//            }
//        }
//        in.close();
//        out.flush(); // буферизация
//        out.close();
//    }


    private static void copy(InputStream in, OutputStream out) throws IOException {
     int b;
        while ((b = in.read()) != -1) {
                out.write(b);
        }
        in.close();
        out.flush(); // буферизация
        out.close();
    }

}
