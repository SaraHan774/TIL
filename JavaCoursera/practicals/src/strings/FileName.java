package strings;

public class FileName {

    private String fullPath;
    private char pathSeparator, extensionSeparator;

// "/home/user/index.html"

    public FileName(String fullPath, char pathSeparator, char extensionSeparator) {
        this.fullPath = fullPath;
        this.pathSeparator = pathSeparator;
        this.extensionSeparator = extensionSeparator;
    }

    public String extension(){
        int dot = fullPath.lastIndexOf(extensionSeparator); //가장 뒤에 있는 점의 index 를 반환한다.
        return fullPath.substring(dot + 1); //점 뒤의 문자부터 끝까지를 반환한다.
    }

    public String filename(){
        int dot = fullPath.lastIndexOf(extensionSeparator); //가장 뒤에 있는 점의 index 를 반환한다.
        int sep = fullPath.lastIndexOf(pathSeparator); // 가장 뒤에 있는 슬래시의 인덱스를 반환한다.
        return fullPath.substring(sep + 1, dot); // 슬래시 뒤의 문자부터 점의 위치 전까지를 반환한다.
    }

    public String path(){
        int sep = fullPath.lastIndexOf(pathSeparator); // 가장 뒤에 있는 슬래시를 반환한다.
        return fullPath.substring(0, sep); //가장 처음부터 맨 뒤의 슬래시 전까지의 스트링을 반환한다.
    }
}
