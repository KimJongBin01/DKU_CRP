package util;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    /**
     * 파일에서 데이터를 읽는 메서드
     *
     * @param fileName String
     * @return ArrayList<String>
     * @throws Exception exception
     */
    public static ArrayList<String> read(String fileName) throws Exception {
        FileReader fReader = new FileReader(getAbsolutePath(fileName));
        BufferedReader bufferedReader = new BufferedReader(fReader);

        String fileContent;
        ArrayList<String> fileContentArray = new ArrayList<>();

        while ((fileContent = bufferedReader.readLine()) != null) {
            fileContentArray.add(fileContent);
        }
        return fileContentArray;
    }

    /**
     * 문자열을 파일에 저장하는 메서드
     *
     * @param fileName String
     * @param line     String
     * @throws Exception exception
     */
    public static void save(String fileName, String line) throws Exception {
        FileWriter fileWriter = new FileWriter(getAbsolutePath(fileName), true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(line);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * 파일의 절대경로를 구하는 메서드
     * (패키지 내 폴더 사용 위해)
     *
     * @param fileName String
     * @return String
     */
    public static String getAbsolutePath(String fileName) {
        File path = new File("");
        return path.getAbsolutePath() + fileName;
    }
}
