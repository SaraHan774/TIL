package strings;

public class FileNameDemo {

    public static void main(String[] args) {
        final String FPATH = "/home/user/index.html";
        FileName fileName = new FileName(FPATH, '/', '.');
        System.out.println("Extension : " + fileName.extension());
        System.out.println("File Name : " + fileName.filename());
        System.out.println("Path : " + fileName.path());
    }


}
