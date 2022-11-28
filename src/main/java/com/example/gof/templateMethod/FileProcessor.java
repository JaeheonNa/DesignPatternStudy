package com.example.gof.templateMethod;

import java.io.*;

public abstract class FileProcessor {
    private String path;

    public FileProcessor(String path){
        this.path = path;
    }

    public int process() {
        try(BufferedReader bReader = new BufferedReader(new FileReader(path))) {
            int result = 0;
            String line = null;
            while((line = bReader.readLine()) != null){
                result = getResult(result, Integer.parseInt(line));
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(path + "에 해당하는 파일이 없습니다", e);
        }
    }

    protected abstract int getResult(int result, int number);

}
