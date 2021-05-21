package editorMethods;

import java.io.*;

public class LangFormatter {
    private String fileType;
    private String OSName;
    public LangFormatter(String ft, String Osn)
    {
        fileType = ft;
        OSName = Osn;
    }

    public boolean format(String fileName){
        switch (fileType) {
            case "c": 
                clangFormat(fileName);
                break;
            case "cpp":
                clangFormat(fileName);
                break;
            case "java":
                googleJavaFormat(fileName);
                break;
            case "python":
                yapfFormat(fileName);
                break;
            default: 
                return false;
        }
        return true;
    }

    public void clangFormat(String fileName){
        System.out.println(fileName);
        try {
            if (OSName.equals("Linux")) {
                final Process p = Runtime.getRuntime().exec("./libs/clang-format-10_linux-amd64 -i " + fileName);
            }else{
                final Process p = Runtime.getRuntime().exec("cmd /c ./libs/clang-format-10_windows-amd64.exe -i " + fileName);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void googleJavaFormat(String fileName){
        
    }
    public void yapfFormat(String fileName){}
}
