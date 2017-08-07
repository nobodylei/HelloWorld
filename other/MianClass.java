/**
* 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中,
*a.txt文件中的单词用回车符分割，b.txt文件中用回车或空格进行分割
*/
public class MainClass {
  public static void main(String[] args) {
    FileManager a = new FileManager("a.txt",new char[]{"\n"});
    FileManager b = new FileManager("b.txt",new char[]{"\n",""});
  }
}
