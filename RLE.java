   import java.io.*;


   public class RLE {

      final static boolean report_times = true;
      final static boolean report_size  = true;
      final static boolean report_filenames  = true;

      FileOutputStream out = null;
      FileInputStream in = null;
      byte[] array = new byte[1];


      public void compress(String input_file, String output_file) throws IOException {
         long start_time;
       /*Input Dan Output File*/
         if (report_filenames) {
            printf("Original file:   " + input_file);
            printf("Compressed file: " + output_file);
         }

         if (report_times) {
            start_time = System.currentTimeMillis();
         }

         int zerf = 0;
         int onef = 0;

         try {
            in = new FileInputStream(input_file);
            out = new FileOutputStream(output_file);

            byte[] _array = new byte[1];

            int rb;

            int last = -1;
            int lastbo = -2;

            int c;
            while ((c = getc()) != -1) {/* Membaca karakter berikutnya.*/
               putc(c);  // output karakter
				{
               if (lastbo == last) {
                  if (c == last) {
                     int count = 0;
                     while (( c = getc()) >= 0 ) {
                        if (c == last) {
                           count++;
                        }
                        else
                        {
                           break;
                        }
                     }

                     if ( c < 0 ) { /* Pengecekan Format */
                        if ((count >= 256) && (count % 256 == 0)) {
                           count -=256;
                        }
                        else {
                           if ( count == 0 ) count = -1;
                        }
                     }
                     if (count >=0) {
                        putc(count);
                     }

                     while ((count = count - 256) >= 0) {
                        putc(last);
                     }

                     if (c >= 0) {
                        putc(c);
                     }
                  }
               }
               // }


               lastbo = last;
               last = c;
            }

            in.close();
            out.close();
         }
            catch(Exception e) {
               printf("Error while processing file:");
               e.printStackTrace();
            }

         if (report_times) {
            start_time = System.currentTimeMillis() - start_time;
            printf("Time taken:" + ((start_time / 10) / 100F) + " seconds.");
         }

         if (report_size) {
            File f1 = new File(input_file);
            File f2 = new File(output_file);

            long f1l = f1.length();
            long f2l = f2.length();

            printf("Original file size:   " + f1l + " bytes.");

            printf("Compressed file size: " + f2l + " bytes.");
            if (f1l > f2l) {
               printf("Compressed by " + (f1l - f2l) + " bytes.");
            }
            else
            {
               printf("*** File gained in size by " + (f2l - f1l) + " bytes. ***");
            }


            if (f1l == 0L) {
               f1l = 1L;
            }

            printf("Compression ratio:    " + ((((f1l - f2l) * 10000) / f1l) / 100F) + "%");

         }

         printf("");
      }


      int getc() throws IOException {
         int rb;

         if ((rb = in.read(array, 0, 1)) == -1) {/* Membaca karakter berikutnya.*/
            return -1; // EOF flag...
         }

         return array[0] & 0xff;
      }


      void putc(int i) throws IOException {
         out.write((byte)i);
      }


      static void printf(String s) {
         System.out.println(s);
      }

      public static void main(String[] args) throws IOException {
         RLE ca = new RLE();

         String input_file = null;
         String output_file = null;

         if (args.length > 0) {
            input_file = args[0];
         }
         else {
            printf("Error: No input file specified");
            System.exit(0);
         }

         if (args.length > 1) {
            output_file = args[1];
         }
         else {
            printf("Error: No output file specified");
            System.exit(0);
         }

         ca.compress(input_file, output_file);
      }

   }
