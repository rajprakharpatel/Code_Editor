package editorMethods;

import java.io.*;

public class LangFormatter {
    private final String fileType;
    private final String OSName;

    public LangFormatter(String ft, String Osn) {
        fileType = ft;
        OSName = Osn;
    }

    public void format(String fileName) {
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
            case "py":
                yapfFormat(fileName);
                break;
            default:
        }
    }

    public void clangFormat(String fileName) {
        // System.out.println(fileName);
        try {
            if (OSName.equals("Linux")) {
                final Process p = Runtime.getRuntime().exec("./libs/clang-format-10_linux-amd64 -i " + fileName);
            } else {
                final Process p = Runtime.getRuntime().exec("./libs/clang-format-10_windows-amd64.exe -i " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void googleJavaFormat(String fileName) {
        try {
            if (OSName.equals("Linux")) {
                final Process p = Runtime.getRuntime().exec("java -jar ./libs/google-java-format-1.10.0-all-deps.jar --replace " + fileName);
            } else {
                final Process p = Runtime.getRuntime().exec("java -jar ./libs/google-java-format-1.10.0-all-deps.jar --replace " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void yapfFormat(String fileName) {
        // System.out.println("yapfFormat");
        try {
            final Process p = Runtime.getRuntime().exec("./src/main/resources/yapf.sh " + fileName);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
