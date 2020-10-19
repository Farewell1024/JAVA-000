package q1;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2020/10/19 13:49
 * @since JDK 1.8
 */
public class HelloByteCode {

    public static void main(String[] args) {
        int a = 10;
        int b = 15;
        int c = (a + b) * 5 / 10;
        int[] arr = {1,2,3,4,5,6};
        for (int i : arr) {
            System.out.println(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

/*

  0 bipush 10
  2 istore_1
  3 bipush 15
  5 istore_2
  6 iload_1
  7 iload_2
  8 iadd
  9 iconst_5
 10 imul
 11 bipush 10
 13 idiv
 14 istore_3
 15 bipush 6
 17 newarray 10 (int)
 19 dup
 20 iconst_0
 21 iconst_1
 22 iastore
 23 dup
 24 iconst_1
 25 iconst_2
 26 iastore
 27 dup
 28 iconst_2
 29 iconst_3
 30 iastore
 31 dup
 32 iconst_3
 33 iconst_4
 34 iastore
 35 dup
 36 iconst_4
 37 iconst_5
 38 iastore
 39 dup
 40 iconst_5
 41 bipush 6
 43 iastore
 44 astore 4
 46 aload 4
 48 astore 5
 50 aload 5
 52 arraylength
 53 istore 6
 55 iconst_0
 56 istore 7
 58 iload 7
 60 iload 6
 62 if_icmpge 86 (+24)
 65 aload 5
 67 iload 7
 69 iaload
 70 istore 8
 72 getstatic #2 <java/lang/System.out>
 75 iload 8
 77 invokevirtual #3 <java/io/PrintStream.println>
 80 iinc 7 by 1
 83 goto 58 (-25)
 86 iconst_0
 87 istore 5
 89 iload 5
 91 aload 4
 93 arraylength
 94 if_icmpge 114 (+20)
 97 getstatic #2 <java/lang/System.out>
100 aload 4
102 iload 5
104 iaload
105 invokevirtual #3 <java/io/PrintStream.println>
108 iinc 5 by 1
111 goto 89 (-22)
114 return


 */
