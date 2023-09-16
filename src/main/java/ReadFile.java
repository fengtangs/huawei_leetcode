import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {
    public static void main(String[] args) {
            String pathname = "C:\\Users\\nsf\\Desktop\\database.csv"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
            //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
            //不关闭文件会导致资源的泄露，读写文件都同理
            //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
            try (FileReader reader = new FileReader(pathname);
                 BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
            ) {
                String line;
                //网友推荐更加简洁的写法
                while ((line = br.readLine()) != null) {
                    // 一次读入一行数据
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



//            // 创建 reader
//            try (
//                    BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\nsf\\Desktop\\database.csv"))) {
//                // CSV文件的分隔符
//                String DELIMITER = ",";
//                // 按行读取
//                String line;
//                while ((line = br.readLine()) != null) {
//                    // 分割
//                    String[] columns
//
//
//
//                            = line.split(DELIMITER);
//                    // 打印行
//                    System.out.println(String.join(", ", columns));
//                }
//            } catch (
//                    IOException ex) {
//                ex.printStackTrace();
//            }

        }

}
